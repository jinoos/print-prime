package function;

/**
 * Created by jinoos on 2018. 6. 1..
 */
class PrimeGenerator {
    private int candidate;
    private int ord;
    private int square;
    private int[] multiples;

    int[] generatePrimeNumbers(int numberOfPrimes) {
        int ordMax = 30;
        multiples = new int[ordMax + 1];
        candidate = 1;
        int primeIndex = 1;
        ord = 2;
        square = 9;

        int[] primes;
        primes = new int[numberOfPrimes + 1];
        primes[1] = 2;

        while (primeIndex < numberOfPrimes) {
            findNextPrime(primes);
            primeIndex = primeIndex + 1;
            primes[primeIndex] = candidate;
        }

        return primes;

    }

    private void findNextPrime(int[] primes) {
        int n;
        boolean possiblyPrime;

        do {
            candidate = candidate + 2;
            if (candidate == square) {
                ord = ord + 1;
                square = primes[ord] * primes[ord];
                multiples[ord - 1] = candidate;
            }
            n = 2;
            possiblyPrime = true;
            while (n < ord && possiblyPrime) {
                while (multiples[n] < candidate) {
                    multiples[n] = multiples[n] + primes[n] + primes[n];
                }
                if (multiples[n] == candidate) {
                    possiblyPrime = false;
                }
                n = n + 1;
            }
        } while (!possiblyPrime);
    }

}
