package function;

public class PrintPrimes {
    private int numberOfPrimes = 1000;

    public void main() {
        int[] primes = new PrimeGenerator().generatePrimeNumbers(numberOfPrimes);
        new NumberPrinter().print(numberOfPrimes, primes);
    }
}
