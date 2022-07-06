import java.util.ArrayList;

public class SieveOfEratosthenes {
    public ArrayList<Integer> sieveToGeneratePrime(int n) {
        boolean[] primeNumbersCheck = new boolean[n + 1];

        for (int i = 0; i <= n; i++) primeNumbersCheck[i] = true;

        for (int i = 2; i * i <= n; i++)
            if (primeNumbersCheck[i])
                for (int j = i * i; j <= n; j += i) primeNumbersCheck[j] = false;

        ArrayList<Integer> primeNumbers = new ArrayList<>();
        for (int i = 2; i <= n; i++)
            if (primeNumbersCheck[i]) primeNumbers.add(i);
        return primeNumbers;
    }
}