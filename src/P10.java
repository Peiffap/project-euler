/**
 * https://projecteuler.net/problem=10
 *
 * Validated.
 */
public class P10 {
    public static void main(String[] args) {
        long s = System.nanoTime();
        boolean[] primes = Library.primeTab(2000000);
        long sum = 0;
        for(int i = 0; i < primes.length; i++) {
            if (primes[i])
                sum += i;
        }
        System.out.println(sum);
        long e = System.nanoTime();
        System.out.println((e-s)/1000000000.0);
    }
}
