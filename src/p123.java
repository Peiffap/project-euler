import java.math.BigInteger;

/**
 * https://projecteuler.net/problem=123
 *
 * Validated.
 */
class p123 {
    public static void main (String[] args) {
        long s = System.nanoTime();
        boolean[] p = Library.primeTab(10000000);
        int[] primes = new int[25000];
        int index = 1;
        int lowestIndexBelow10B = 0; // Efficiency.
        boolean given = false; // Have we initialised lowestIndex yet?
        for (int i = 2; index < primes.length; i++) {
            if (p[i]) {
                primes[index++] = i;
                if (primes[index-1] > 100000 && !given) {
                    lowestIndexBelow10B = index-1;
                    given = true;
                }
            }
        }
        for (int i = lowestIndexBelow10B; i < primes.length; i++) { // If mod pn^2 > 10^10, then pn > 10^5.
            BigInteger b = new BigInteger(Integer.toString(primes[i]));
            BigInteger a = b.subtract(BigInteger.ONE);
            BigInteger c = b.add(BigInteger.ONE);
            if (((a.pow(i).add(c.pow(i))).mod(b.multiply(b)).longValue() > Math.pow(10,10))) {
                System.out.println(i);
                long e = System.nanoTime();
                System.out.println((e-s)/1000000000.0);
                System.exit(0);
            }
        }
    }
}
