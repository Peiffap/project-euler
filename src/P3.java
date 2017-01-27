/**
 * Created by admin on 27/01/17.
 * Validated.
 */
public class P3 {
    public static boolean isPrime(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n%i == 0)
                return false;
        }
        return true;
    }
    public static void main (String[] args) {
        long s = System.nanoTime();
        double n = 600851475143.0;
        boolean[] primes = Library.primeTab((int) Math.sqrt(n));
        for (int i = primes.length-1; i >= 0; i--) {
            if (primes[i] && n%i == 0) {
                System.out.println(i);
                long e = System.nanoTime();
                System.out.println((e-s)/1000000000.0);
                System.exit(0);
            }
        }
    }
}
