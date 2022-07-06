import java.math.BigInteger;
import java.util.Random;

class RandomIntegerGenerator {
	public BigInteger randomBigInteger(BigInteger limit) {
		BigInteger randomNumber;
		BigInteger[] gcd;

		do {
			randomNumber = new BigInteger(limit.bitLength(), new Random());
			ExtendedEuclideanAlgorithm extendedEuclideanAlgorithm = new ExtendedEuclideanAlgorithm();
			gcd = extendedEuclideanAlgorithm.findGCD(randomNumber, limit);
		} while (randomNumber.compareTo(limit) >= 0 || randomNumber.compareTo(BigInteger.TWO) < 0 || !gcd[0].equals(BigInteger.ONE));
		return randomNumber;
	}
}