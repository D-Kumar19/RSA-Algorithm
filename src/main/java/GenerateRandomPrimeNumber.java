import java.util.Random;
import java.util.ArrayList;
import java.math.BigInteger;

public class GenerateRandomPrimeNumber {
    public BigInteger primeNumberGenerator(int numberOfBits, ArrayList<Integer> primesNumbersEratosthenes){
        BigInteger randomPrimeNumber;
        MillerRabinAlgorithm millerRabinAlgorithm = new MillerRabinAlgorithm();

        do{
            randomPrimeNumber = new BigInteger(numberOfBits, new Random());
        }while (!millerRabinAlgorithm.findIfArrayListIsPrime(randomPrimeNumber, primesNumbersEratosthenes));
        return randomPrimeNumber;
    }
}