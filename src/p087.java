/**
 * https://projecteuler.net/problem=87
 *
 * Validated.
 */
public class p087 {

    private static boolean[] primes = Library.primeTab(7071);
    private static boolean[] sumOfPowers = new boolean[50000000];

    public static void main (String[] args) {
        long s = System.nanoTime();
        for (int i = 0; i < primes.length; i++) {
            for (int j = 0; i*i+j*j*j < sumOfPowers.length; j++) {
                for (int k = 0; i*i+j*j*j+k*k*k*k < sumOfPowers.length; k++) {
                    if (primes[i] && primes[j] && primes[k]) {
                        sumOfPowers[i * i + j * j * j + k * k * k * k] = true;
                    }
                }
            }
        }
        int count = 0;
        for (boolean b : sumOfPowers) {
            if (b) {
                count++;
            }
        }
        System.out.println(count);
        long e = System.nanoTime();
        System.out.println((e-s)/1000000000.0);
    }
}
