/**
 * https://projecteuler.net/problem=27
 *
 * Validated.
 */
public class p027 {

    private static boolean[] primes = Library.primeTab(100000);

    /**
     * @param a the x-coefficient in n*n + a*n + b.
     * @param b the constant in n*n + a*n + b.
     * @return the longest chain of primes one can construct by applying the above formula for a given a and b,
     * starting at n = 0.
     */
    public static int consec (int a, int b) {
        int n = 0;
        while (primes[Math.abs(n*n + a*n + b)]) {
            n++;
        }
        return n;
    }

    public static void main (String[] args) {
        long s = System.nanoTime();
        int max = 40;
        int maxProd = 41;
        for (int a = -999; a < 1000; a++) {
            for (int b = -1000; b <= 1000; b++) {
                if (!primes[Math.abs(b)]) {}
                else if (consec(a,b) > max) {
                    max = consec(a,b);
                    maxProd = a*b;
                }
            }
        }
        System.out.println(maxProd);
        long e = System.nanoTime();
        System.out.println((e-s)/1000000000.0);
    }
}
