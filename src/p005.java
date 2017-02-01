/**
 * https://projecteuler.net/problem=5
 *
 * Validated.
 */
class p005 {
    public static void main (String[] args) {
        long s = System.nanoTime();
        System.out.println(16*9*5*7*11*13*17*19); // Highest powers below 20 of all primes below 20.
        long e = System.nanoTime();
        System.out.println((e-s)/1000000000.0);
    }
}
