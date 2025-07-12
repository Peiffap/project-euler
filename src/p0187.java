/**
 * https://projecteuler.net/problem=187
 *
 * Validated.
 */
class p187 {
    public static void main (String[] args) {
        long s = System.nanoTime();
        boolean[] primes = Library.primeTab(100000000);
        boolean[] semiprimes = new boolean[100000000];
        for (int i = 2; i <= Math.sqrt(primes.length); i++) {
            for (int j = i; j*i < primes.length; j++) {
                if (primes[i] && primes[j]) {
                    semiprimes[i*j] = true;
                }
            }
        }
        int count = 0;
        for (boolean b : semiprimes) {
            if (b) {
                count++;
            }
        }
        System.out.println(count);
        long e = System.nanoTime();
        System.out.println((e-s)/1000000000.0);
    }
}
