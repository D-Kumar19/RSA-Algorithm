import java.math.BigInteger;
public class ExtendedEuclideanAlgorithm {
    public BigInteger[] findGCD(BigInteger a, BigInteger b){

        BigInteger[] gcd = {a, BigInteger.ONE, BigInteger.ZERO};
        if(!b.equals(BigInteger.ZERO)){
            BigInteger[] tempResults = findGCD(b, a.mod(b));
            gcd[0] = tempResults[0];
            gcd[1] = tempResults[2];
            gcd[2] = tempResults[1].subtract(tempResults[2].multiply(a.divide(b)));
        }
    return gcd;
    }
}