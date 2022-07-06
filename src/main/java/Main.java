import java.util.ArrayList;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {

        // Checking Extended Euclidean Algorithm:
        ExtendedEuclideanAlgorithm extendedEuclideanAlgorithm = new ExtendedEuclideanAlgorithm();
        BigInteger a = new BigInteger("402");
        BigInteger b = new BigInteger("123");
        System.out.println("Extended Euclidean Algorithm: " + "\n" + "Value of A: " + a + "\n" + "Value of B: " + b);
        BigInteger[] Extended_Euclidean_Result = extendedEuclideanAlgorithm.findGCD(a, b);
        System.out.println("GCD = " + Extended_Euclidean_Result[0] + "\n" + "X = " + Extended_Euclidean_Result[1] + "\n" + "Y = " + Extended_Euclidean_Result[2]);

        // Checking Fast Modular Algorithm:
        FastModularAlgorithm fastModularAlgorithm = new FastModularAlgorithm();
        a = new BigInteger("6");
        b = new BigInteger("73");
        BigInteger m = new BigInteger("100");
        System.out.println("\nFast Modular Algorithm: " + "\n" + "Value of A: " + a + "\n" + "Value of B: " + b + "\n" + "Value of M: " + m);
        BigInteger Fast_Modular_Result = fastModularAlgorithm.findMod(a, b, m);
        System.out.println("Fast Modular Exponentiation = " + Fast_Modular_Result);

        // Checking Miller Rabin Algorithm:
        MillerRabinAlgorithm millerRabinAlgorithm = new MillerRabinAlgorithm();
        BigInteger p = new BigInteger("561");
        BigInteger q = new BigInteger("2");
        System.out.println("\nMiller Rabin Algorithm: " + "\n" + "Value of P: " + p + "\n" + "Value of Q: " + q);
        if(millerRabinAlgorithm.findIfBigNumberIsPrime(p, q)){System.out.println("It is a Composite Number!");}
        else{System.out.println("It is a Prime Number!");}

        // Checking RSA Algorithm:
        RSAAlgorithm rsaAlgorithm = new RSAAlgorithm();
        p = new BigInteger("463");
        q = new BigInteger("547");
        BigInteger e = new BigInteger("47");
        String message = "Hello! How are you?";
        System.out.println("\nRSA Algorithm: " + "\n" + "Value of P: " + p + "\n" + "Value of Q: " + q + "\n" + "Value of E: " + e);
        System.out.println("Message: " + message);
        rsaAlgorithm.rsaCheckEnDecKeyNormal(p, q, e, message);

        // Checking Chinese Remainder Algorithm:
        ChineseRemainderAlgorithm chineseRemainderAlgorithm = new ChineseRemainderAlgorithm();
        p = new BigInteger("463");
        q = new BigInteger("547");
        e = new BigInteger("47");
        BigInteger c = new BigInteger("47");
        System.out.println("\nChinese Remainder Algorithm: " + "\n" + "Value of P: " + p + "\n" + "Value of Q: " + q + "\n" + "Value of C: " + c + "\n" + "Value of E: " + e);
        BigInteger Chinese_Remainder_Result = chineseRemainderAlgorithm.findChineseRemainderKey(p, q, c, e);
        System.out.println("Chinese Remainder Key = " + Chinese_Remainder_Result);

        // Using Sieve of Eratosthenes Algorithm:
        SieveOfEratosthenes sieveOfEratosthenesAlgorithm = new SieveOfEratosthenes();
        System.out.println("\nUsing Sieve of Eratosthenes to Generate Prime Numbers: ");
        ArrayList<Integer> primeNumbers = sieveOfEratosthenesAlgorithm.sieveToGeneratePrime((int) Math.pow(10, 3));
        for (Integer prime_number : primeNumbers) {
            System.out.print(prime_number + " ");
        }

        // Checking RSA Algorithm:
        System.out.println("\n\nRSA Algorithm Using Big Integers: ");
        message = "Hello World!";
        rsaAlgorithm.RSACheckENDECKeyBigPrimeNumbers(1500, primeNumbers, message);
    }
}