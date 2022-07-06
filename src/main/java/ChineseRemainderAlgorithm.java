import java.math.BigInteger;

public class ChineseRemainderAlgorithm {
    public BigInteger findChineseRemainderKey(BigInteger p, BigInteger q, BigInteger c, BigInteger e){
        BigInteger n = p.multiply(q);
        BigInteger phiN = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));

        ExtendedEuclideanAlgorithm extendedEuclideanAlgorithm = new ExtendedEuclideanAlgorithm();
        BigInteger[] Result = extendedEuclideanAlgorithm.findGCD(e, phiN);
        BigInteger D = Result[1].mod(phiN);

        BigInteger dp = D.mod(p.subtract(BigInteger.ONE));
        BigInteger dq = D.mod(q.subtract(BigInteger.ONE));

        BigInteger mp = c.modPow(dp, p);
        BigInteger mq = c.modPow(dq, q);

        Result = extendedEuclideanAlgorithm.findGCD(p, q);
        return (mp.multiply(Result[2]).multiply(q).add(mq.multiply(Result[1]).multiply(p))).mod(n);
    }
}