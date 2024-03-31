# Cryptonaut: RSA-Algorithm

Welcome to *Cryptonaut: RSA-Algorithm* – an advanced implementation of RSA Encryption Algorithms designed for developers and cryptography enthusiasts. This repository is your go-to resource for exploring and implementing RSA algorithms with a modular and accessible design.

## Description

RSA (Rivest–Shamir–Adleman) is one of the first public-key cryptosystems and is widely used for secure data transmission. In this repository, we've dissected the RSA algorithm into its core components and provided implementations for each, making it easier for you to understand and utilize in your projects. 

## Features

- **Extended Euclidean Algorithm**: Utilize this for computing the greatest common divisor, an essential step in generating RSA keys.
- **Fast Modular Exponentiation**: A method for efficiently computing power mod operations, critical for both key generation and encryption/decryption processes.
- **Miller-Rabin Primality Test**: An algorithm used to determine if a number is prime, ensuring the selection of secure prime numbers for RSA.
- **Prime Number Generator**: Leverages a custom random number generator for the generation of prime numbers, fundamental for RSA cryptography.
- **Chinese Remainder Theorem (CRT)**: Implements the CRT for efficient decryption key generation, optimizing the decryption process.
- **RSA Key Generation**: Facilitates the generation of public and private key pairs, the backbone of RSA encryption.
- **Sieve of Eratosthenes**: Efficiently generates a list of prime numbers within a given range, aiding in the prime selection step.

## Getting Started

To begin using the *Cryptonaut: RSA-Algorithm*, clone this repository to your local machine:

```bash
git clone https://github.com/yourusername/RSA-Algorithm.git
```
---

## Contributing

I welcome contributions to **Cryptonaut: RSA-Algorithm**! If you have suggestions for improving the game or have found a way to beat the current record, please feel free to contribute. Here's how you can do so:

1. Fork the repository.
2. Create a new branch (`git checkout -b <branch_name>`).
3. Commit your changes (`git commit -m 'Added some features...'`).
4. Push to the branch (`git push origin <branch_name>`).
5. Open a pull request.

## Acknowledgments
This project is inspired by the foundational work in public-key cryptography by Rivest, Shamir, and Adleman.
