import java.math.BigInteger;
import java.util.ArrayList;

class MillerRabinAlgorithm {
	private static boolean a_d_Test(BigInteger q, BigInteger d, BigInteger p) {
		return q.modPow(d, p).equals(BigInteger.ONE);
	}

	boolean findIfBigNumberIsPrime(BigInteger p, BigInteger q) {
		BigInteger x = p.subtract(BigInteger.ONE);
		BigInteger d;
		int s = 0;

		while (true) {
			if (x.mod(BigInteger.TWO).equals(BigInteger.ZERO)) {
				x = x.divide(BigInteger.TWO);
				s += 1;
			}
			if (!x.mod(BigInteger.TWO).equals(BigInteger.ZERO)) {
				d = x;
				break;
			}
		}

		if (MillerRabinAlgorithm.a_d_Test(q, d, p)) {
			return true;
		} else {
			return this.a_2i_d_Test(q, d, p, s);
		}
	}

	boolean findIfArrayListIsPrime(BigInteger p, ArrayList<Integer> primeNumbers) {
		BigInteger checkIfPrime;

		for (Integer iterator : primeNumbers) {
			checkIfPrime = BigInteger.valueOf(iterator);

			if (p.mod(checkIfPrime).equals(BigInteger.ZERO)) {
				return false;
			}
			if (checkIfPrime.compareTo(p.sqrt()) > 0) {
				break;
			}
		}

		BigInteger prime;
		int count = 5;
		while (count > 0) {
			count -= 1;

			RandomIntegerGenerator randomIntegerGenerator = new RandomIntegerGenerator();
			prime = randomIntegerGenerator.randomBigInteger(p);
			if (!this.findIfBigNumberIsPrime(p, prime)) {
				return false;
			}
		}
		return true;
	}

	private boolean a_2i_d_Test(BigInteger q, BigInteger d, BigInteger p, int s) {
		for (int i = 0; i < s; i++) {
			if (q.modPow(BigInteger.TWO.pow(i).multiply(d), p).equals(p.subtract(BigInteger.ONE))) {
				return true;
			}
		}
		return false;
	}
}