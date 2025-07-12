/**
 * https://projecteuler.net/problem=357
 *
 * Validated.
 */
class p357 {

    private static int[] primes = Library.primesBelow(100000000);
    private static boolean[] isPrime = Library.primeTab(100000000);

    public static void main(String[] args) {
        long s = System.nanoTime();
        long sum = 0;
        for (int i : primes) {
            if (isPrimeGenerating(i-1)) { // n+n/n has to be prime, so n+1 has to be prime.
                sum += i-1;
            }
        }
        System.out.println(sum);
        System.out.println((System.nanoTime()-s)/1000000000.0);
    }

    /**
     * Returns true if for every divisor d of n, d+n/d is a prime number.
     * @param n the number to test.
     * @return true if n is prime generating, false if not.
     */
    private static boolean isPrimeGenerating (int n) {
        int[] divs = Library.divisors(n);
        for (int i : divs) {
            if (!isPrime[i+n/i]) {
                return false;
            }
        }
        return true;
    }
}
