import java.math.BigInteger;

class ChineseRemainderAlgorithm {
	BigInteger findChineseRemainderKey(BigInteger p, BigInteger q, BigInteger c, BigInteger e) {
		BigInteger n = p.multiply(q);
		BigInteger phiN = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));

		ExtendedEuclideanAlgorithm extendedEuclideanAlgorithm = new ExtendedEuclideanAlgorithm();
		BigInteger[] result = extendedEuclideanAlgorithm.findGCD(e, phiN);
		BigInteger d = result[1].mod(phiN);

		BigInteger dp = d.mod(p.subtract(BigInteger.ONE));
		BigInteger dq = d.mod(q.subtract(BigInteger.ONE));

		BigInteger mp = c.modPow(dp, p);
		BigInteger mq = c.modPow(dq, q);

		result = extendedEuclideanAlgorithm.findGCD(p, q);
		return (mp.multiply(result[2]).multiply(q).add(mq.multiply(result[1]).multiply(p))).mod(n);
	}
}