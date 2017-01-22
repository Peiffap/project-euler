/**
 * Created by admin on 31/12/16.
 * Library with some useful subroutines for project Euler solving.
 */
public class Library {
    public static boolean[] primeTab(int length) {
        boolean[] isPrime = new boolean[length+1];
        for (int i = 2; i < isPrime.length; i++) {
            isPrime[i] = true;
        }
        for (int i = 2; i*i <= length; i++) {
            if (isPrime[i]) {
                for (int j = i; j <= length/i; j++) {
                    isPrime[j*i] = false;
                }
            }
        }
        return isPrime;
    }
    public static void main(String[] args) {
        long s = System.nanoTime();
        boolean[] primes = primeTab(100000000);
        int o = 0;
        for (int i = 2; i < primes.length; i++) {
            if (primes[i])
                o++;
        }
        System.out.println(o);
        long e = System.nanoTime();
        System.out.println((e-s)/1000000000.0);
    }
}
