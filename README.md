<div align="center">
  <h1>🏔️ Hill Cipher Implementation (Java)</h1>
  <p><b>A clean, terminal-based Java application that encrypts and decrypts text using the Hill Cipher algorithm.</b></p>
  <br>

  <img src="https://img.shields.io/badge/Language-Java-orange?style=for-the-badge&logo=java" alt="Java">
  <img src="https://img.shields.io/badge/Security-Cryptography-blue?style=for-the-badge" alt="Cryptography">
</div>

<hr>

<p>Unlike simple substitution ciphers, the Hill Cipher uses linear algebra (matrix multiplication modulo 26) to encrypt blocks of text, making it highly resistant to basic frequency analysis.</p>

<hr>

<h2>✨ Features</h2>
<ul>
  <li><b>Dynamic Key Sizing:</b> Supports standard <i>n &times; n</i> matrices (currently optimized for 2&times;2 and 3&times;3 inverses).</li>
  <li><b>Auto-Padding:</b> Automatically pads your plaintext with <code>X</code> so it perfectly divides into your matrix size.</li>
  <li><b>Mathematical Validation:</b> Calculates the determinant modulo 26 and checks for the modular multiplicative inverse. If you enter a mathematically invalid key, it warns you instead of crashing.</li>
  <li><b>Identity Matrix Proof:</b> Multiplies the key by its calculated inverse to output the Identity Matrix, proving the math checks out before attempting decryption.</li>
</ul>

<h2>⚙️ Prerequisites</h2>
<ul>
  <li><b>Java Development Kit (JDK):</b> Version 8 or higher.</li>
  <li>A standard terminal or command prompt.</li>
</ul>

<h2>🚀 How to Run</h2>
<ol>
  <li>Clone this repository to your local machine:
    <pre><code>git clone https://github.com/5ymb/HillCipher.git</code></pre>
  </li>
  <li>Open your terminal, navigate to the folder, and compile the Java code:
    <pre><code>javac HillCipher.java</code></pre>
  </li>
  <li>Run the compiled program:
    <pre><code>java HillCipher</code></pre>
  </li>
</ol>

<h2>💻 Example Usage</h2>
<p>Here’s what the terminal output looks like when you run the program with a 3&times;3 key matrix to encrypt the word <b>ACT</b>:</p>

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

<br>

<div align="center">
  <h3>⚠️ Important Cryptographic Note</h3>
  <p>For decryption to be mathematically possible, the <b>determinant of your key matrix must be coprime to 26</b>.</p>
  <p><i>This means the Greatest Common Divisor (GCD) of your determinant and 26 must be exactly 1. If your determinant evaluates to a number that shares a factor with 26 (like 2 or 13), the key matrix is singular in modulo 26 arithmetic. The cipher becomes one-way (irreversible), and the program will alert you that decryption is impossible.</i></p>
</div>

<hr>
<p align="center"><i>Developed by Abdulqader</i></p>
