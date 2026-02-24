import java.util.*;

public class HillCipher {
    static Scanner sc = new Scanner(System.in);
    static String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static void main(String[] args) {
        System.out.print("Enter key size (n for an n x n matrix): ");
        int n = sc.nextInt();

        int[][] key = new int[n][n];
        System.out.println("Enter key matrix elements (row by row):");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                key[i][j] = sc.nextInt();
            }
        }

        System.out.print("Enter Plaintext (Uppercase, no spaces): ");
        String text = sc.next();

        while (text.length() % n != 0) {
            text += "X";
        }
        System.out.println("Padded Plaintext: " + text);

        int[][] textMat = strToMat(text, n);
        int[][] cipherMat = multiplyMatrices(textMat, key, n);
        String ciphertext = matToStr(cipherMat);
        System.out.println("\nEncrypted Ciphertext: " + ciphertext);

        System.out.println("\n--- Decryption Check ---");
        int det = determinant(key, n);
        det = mod26(det);
        System.out.println("Determinant mod 26: " + det);

        int invDet = modInverse(det, 26);
        if (invDet == -1) {
            System.out.println("The key matrix has no modular inverse. Decryption is impossible!");
        } else {
            System.out.println("Multiplicative Inverse of Determinant: " + invDet);
            int[][] invKey = findInverse(key, n, invDet);

            System.out.println("\nInverse Key Matrix:");
            displayMat(invKey);

            System.out.println("\nIdentity Matrix (Key * Inverse Key) mod 26:");
            int[][] identity = multiplyMatrices(key, invKey, n);
            displayMat(identity);

            // Decrypt back to prove it works
            int[][] decryptedMat = multiplyMatrices(cipherMat, invKey, n);
            System.out.println("\nDecrypted Text: " + matToStr(decryptedMat));
        }
        sc.close();
    }


    static int[][] multiplyMatrices(int[][] a, int[][] b, int n) {
        int rows = a.length;
        int[][] res = new int[rows][n];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < n; j++) {
                int sum = 0;
                for (int k = 0; k < n; k++) {
                    sum += a[i][k] * b[k][j];
                }
                res[i][j] = mod26(sum);
            }
        }
        return res;
    }

    static int mod26(int a) {
        return (a % 26 + 26) % 26;
    }

    static int modInverse(int a, int m) {
        for (int x = 1; x < m; x++) {
            if ((a * x) % m == 1) return x;
        }
        return -1; // No inverse exists
    }

    static int determinant(int[][] mat, int n) {
        if (n == 2) {
            return mat[0][0] * mat[1][1] - mat[0][1] * mat[1][0];
        }
        if (n == 3) {
            int x = mat[0][0] * (mat[1][1] * mat[2][2] - mat[1][2] * mat[2][1]);
            int y = mat[0][1] * (mat[1][0] * mat[2][2] - mat[1][2] * mat[2][0]);
            int z = mat[0][2] * (mat[1][0] * mat[2][1] - mat[1][1] * mat[2][0]);
            return x - y + z;
        }
        throw new UnsupportedOperationException("This code only supports 2x2 or 3x3 determinants.");
    }

    static int[][] findInverse(int[][] mat, int n, int invDet) {
        int[][] adj = new int[n][n];
        if (n == 2) {
            adj[0][0] = mat[1][1];
            adj[1][1] = mat[0][0];
            adj[0][1] = -mat[0][1];
            adj[1][0] = -mat[1][0];
        } else if (n == 3) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    int p = (i == 0) ? 1 : 0;
                    int q = (i == 2) ? 1 : 2;
                    int r = (j == 0) ? 1 : 0;
                    int s = (j == 2) ? 1 : 2;
                    int minor = mat[r][p] * mat[s][q] - mat[r][q] * mat[s][p];
                    adj[i][j] = minor * (int) Math.pow(-1, i + j);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                adj[i][j] = mod26(adj[i][j] * invDet);
            }
        }
        return adj;
    }

    static int[][] strToMat(String s, int n) {
        int rows = s.length() / n;
        int[][] mat = new int[rows][n];
        int k = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = ALPHABET.indexOf(s.charAt(k++));
            }
        }
        return mat;
    }

    static String matToStr(int[][] mat) {
        StringBuilder sb = new StringBuilder();
        for (int[] row : mat) {
            for (int val : row) {
                sb.append(ALPHABET.charAt(val));
            }
        }
        return sb.toString();
    }

    static void displayMat(int[][] mat) {
        for (int[] row : mat) {
            for (int val : row) {
                System.out.print(val + "\t");
            }
            System.out.println();
        }
    }
}