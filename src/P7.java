/**
 * Created by admin on 27/01/17.
 * Validated.
 */
public class P7 {
    public static void main (String[] args) {
        long s = System.nanoTime();
        boolean[] primes = Library.primeTab(120000);
        int count = 0;
        for (int i = 0; i < primes.length; i++) {
            if (primes[i])
                count++;
            if (count == 10001) {
                System.out.println(i);
                long e = System.nanoTime();
                System.out.println((e-s)/1000000000.0);
                System.exit(0);
            }
        }
    }
}
