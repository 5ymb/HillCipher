<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Hill Cipher in Java - README</title>
    <style>
        :root {
            --bg-color: #f4f4f9;
            --text-color: #333;
            --primary-color: #2c3e50;
            --accent-color: #3498db;
            --code-bg: #272822;
            --code-text: #f8f8f2;
        }
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            line-height: 1.6;
            color: var(--text-color);
            background-color: var(--bg-color);
            max-width: 900px;
            margin: 0 auto;
            padding: 20px;
        }
        header {
            border-bottom: 3px solid var(--accent-color);
            padding-bottom: 10px;
            margin-bottom: 30px;
        }
        h1, h2, h3 {
            color: var(--primary-color);
        }
        h2 {
            margin-top: 40px;
            border-bottom: 1px solid #ddd;
            padding-bottom: 5px;
        }
        ul, ol {
            margin-bottom: 20px;
        }
        li {
            margin-bottom: 8px;
        }
        pre {
            background-color: var(--code-bg);
            color: var(--code-text);
            padding: 15px;
            border-radius: 5px;
            overflow-x: auto;
            font-family: 'Courier New', Courier, monospace;
        }
        code {
            background-color: #e8e8e8;
            color: #d6336c;
            padding: 2px 5px;
            border-radius: 3px;
            font-family: 'Courier New', Courier, monospace;
        }
        pre code {
            background-color: transparent;
            color: inherit;
            padding: 0;
        }
        .note {
            background-color: #e7f3fe;
            border-left: 6px solid #2196F3;
            margin-bottom: 15px;
            padding: 15px;
            border-radius: 4px;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 10px;
            text-align: left;
        }
        th {
            background-color: var(--primary-color);
            color: white;
        }
    </style>
</head>
<body>

    <header>
        <h1>Hill Cipher Implementation (Java)</h1>
        <p>A dynamic, terminal-based Java application for encrypting and decrypting text using the Hill Cipher algorithm.</p>
    </header>

    <main>
        <section id="overview">
            <h2>Overview</h2>
            <p>This project implements the <strong>Hill Cipher</strong>, a polyalphabetic substitution cipher based on linear algebra. The program allows users to input a key matrix of size <em>n x n</em>, processes plaintext by converting it into numerical vectors, and performs matrix multiplication modulo 26 to generate ciphertext.</p>
        </section>

        <section id="features">
            <h2>Features</h2>
            <ul>
                <li><strong>Dynamic Key Sizing:</strong> Supports dynamic matrix sizing (e.g., 2x2, 3x3) based on user input.</li>
                <li><strong>Automatic Padding:</strong> Automatically pads the plaintext with the character <code>X</code> if the length does not cleanly divide by the key size.</li>
                <li><strong>Mathematical Validation:</strong> Calculates the determinant modulo 26 and checks for modular multiplicativity (coprime to 26) to ensure the key is valid for decryption.</li>
                <li><strong>Identity Matrix Verification:</strong> Proves the accuracy of the calculated inverse matrix by multiplying it with the original key to display the Identity Matrix.</li>
            </ul>
        </section>

        <section id="requirements">
            <h2>Prerequisites</h2>
            <p>To compile and run this program, you will need:</p>
            <ul>
                <li>Java Development Kit (JDK) 8 or higher installed on your machine.</li>
                <li>A standard terminal or command prompt.</li>
            </ul>
        </section>

        <section id="usage">
            <h2>How to Run</h2>
            <ol>
                <li>Save the Java code to a file named <code>HillCipher.java</code>.</li>
                <li>Open your terminal and navigate to the directory containing the file.</li>
                <li>Compile the code using the <code>javac</code> command:
                    <pre><code>javac HillCipher.java</code></pre>
                </li>
                <li>Run the compiled program:
                    <pre><code>java HillCipher</code></pre>
                </li>
                <li>Follow the on-screen prompts to enter your key size, matrix elements, and plaintext.</li>
            </ol>
        </section>

        <section id="example">
            <h2>Example Usage</h2>
            <p>Here is an example of what the terminal output looks like when encrypting and decrypting the word <strong>ACT</strong> with a 3x3 matrix:</p>
            <pre><code>Enter key size (n for an n x n matrix): 3
Enter key matrix elements (row by row):
6 24 1
13 16 10
20 17 15
Enter Plaintext (Uppercase, no spaces): ACT
Padded Plaintext: ACT

Encrypted Ciphertext: POH

--- Decryption Check ---
Determinant mod 26: 25
Multiplicative Inverse of Determinant: 25

Inverse Key Matrix:
8       5       10      
21      8       21      
21      12      8       

Identity Matrix (Key * Inverse Key) mod 26:
1       0       0       
0       1       0       
0       0       1       

Decrypted Text: ACT</code></pre>
        </section>

        <section id="limitations">
            <h2>Limitations & Notes</h2>
            <div class="note">
                <strong>Important Cryptographic Note:</strong> For the decryption to work, the determinant of your key matrix must not share any common factors with 26 (it must be coprime). If you enter a matrix with a determinant like 2 or 13, the program will alert you that decryption is impossible.
            </div>
            <ul>
                <li>The current determinant and inverse logic hardcodes support for <strong>2x2</strong> and <strong>3x3</strong> matrices. Higher-order matrices will require a recursive determinant/adjugate function.</li>
                <li>Only uppercase English letters (A-Z) without spaces or special characters are supported for the plaintext input.</li>
            </ul>
        </section>
    </main>

    <footer>
        <p style="text-align: center; margin-top: 50px; font-size: 0.9em; color: #777;">
            &copy; 2026 Hill Cipher Java Implementation
        </p>
    </footer>

</body>
</html>
