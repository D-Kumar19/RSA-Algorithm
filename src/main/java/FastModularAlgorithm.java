import java.math.BigInteger;

public class FastModularAlgorithm {
    public BigInteger findMod(BigInteger a, BigInteger b, BigInteger m){
        BigInteger result = BigInteger.ONE;

        while(b.compareTo(BigInteger.ZERO) > 0) {
            if (b.and(BigInteger.ONE).equals(BigInteger.ONE))
                result = result.multiply(a).mod(m);

            a = a.modPow(BigInteger.TWO, m);
            b = b.shiftRight(1);
        }
        return result;
    }
}