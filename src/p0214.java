/**
 * https://projecteuler.net/problem=214
 *
 * Validated.
 */
class p214 {

    private static int[] lengths = new int[40000000];
    private static int[] totients = Library.phi(40000000);
    private static int[] primes = Library.primesBelow(40000000);

    public static void main (String[] args) {
        long st = System.nanoTime();
        lengths[1] = 1;
        /*
         * Each chain starts at the number and then follows the chain of that number's totient. That means that
         * the length of n's chain is 1 + the length of totient(n)'s chain. totient(n) is always < n, so that value has
         * been computed before and stored in the array.
         */
        for (int i = 2; i < 40000000; i++) {
            lengths[i] = 1 + lengths[totients[i]];
        }
        long s = 0;
        for (int i : primes) { // We only care about primes.
            if (lengths[i] == 25) {
                s += i;
            }
        }
        System.out.println(s);
        System.out.println((System.nanoTime()-st)/1000000000.0);
    }

}
