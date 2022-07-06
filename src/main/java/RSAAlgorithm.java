import java.lang.*;
import java.util.Random;
import java.util.ArrayList;
import java.math.BigInteger;

public class RSAAlgorithm {
    public void rsaCheckEnDecKeyNormal(BigInteger p, BigInteger q, BigInteger e, String message){
        BigInteger n = p.multiply(q);
        BigInteger phiN = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));

        ExtendedEuclideanAlgorithm extendedEuclideanAlgorithm = new ExtendedEuclideanAlgorithm();
        BigInteger[] gcd = extendedEuclideanAlgorithm.findGCD(e, phiN);
        BigInteger D = gcd[1].mod(phiN);

        String x = encryption(e, n, message);
        String y = decryption(D, n, x);

        System.out.println("Private Key = (" + D + ", " + n + ")");
        System.out.println("Public Key = (" + e + ", " + n + ")");

        System.out.println("Encrypted Value of Text: " + x);
        System.out.println("Decrypted Value of Text: " + y);
    }
    public void RSACheckENDECKeyBigPrimeNumbers(int numberOfBits, ArrayList<Integer> primeNumbersEratosthenes, String message){
        GenerateRandomPrimeNumber generateRandomPrimeNumber = new GenerateRandomPrimeNumber();
        BigInteger p = generateRandomPrimeNumber.primeNumberGenerator(numberOfBits, primeNumbersEratosthenes);
        BigInteger q = generateRandomPrimeNumber.primeNumberGenerator(numberOfBits, primeNumbersEratosthenes);

        BigInteger N = p.multiply(q);
        BigInteger phiN = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));

        BigInteger[] gcd;
        BigInteger e;
        do {
            e = new BigInteger(phiN.bitLength(), new Random());

            ExtendedEuclideanAlgorithm extendedEuclideanAlgorithm = new ExtendedEuclideanAlgorithm();
            gcd = extendedEuclideanAlgorithm.findGCD(e,phiN);
        } while (e.compareTo(phiN) >= 0 || e.compareTo(BigInteger.TWO) < 0 || !gcd[0].equals(BigInteger.ONE));

        BigInteger D = gcd[1].mod(phiN);
        System.out.println("P = " + p + "\n" + "Q = " + q + "\n" + "E = " + e + "\n" + "Message = " + message);

        String X = encryption(e, N, message);
        String Y = decryption(D, N, X);

        System.out.println("Private Key = (" + D + ", " + N + ")");
        System.out.println("Public Key = (" + e + ", " + N + ")");

        System.out.println("Encrypted Value of Text: " + X);
        System.out.println("Decrypted Value of Text: " + Y);
    }
    public String encryption(BigInteger e, BigInteger n, String message){
        String cipher = "";
        for(int i = 0; i < message.length(); i++){
            int M = message.charAt(i);

            FastModularAlgorithm fastModularAlgorithm = new FastModularAlgorithm();
            cipher = cipher.concat(fastModularAlgorithm.findMod(BigInteger.valueOf(M), e, n).toString()).concat(" ");
        }
        return cipher;
    }
    public String decryption(BigInteger d, BigInteger n, String c){
        String message = "";

        String[] cipherCharacters = c.split(" ");
        for(String i: cipherCharacters){
            FastModularAlgorithm fastModularAlgorithm = new FastModularAlgorithm();
            message = message.concat(Character.toString(fastModularAlgorithm.findMod(new BigInteger(i), d, n).intValue()));
        }
        return message;
    }
}