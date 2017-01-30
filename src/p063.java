/**
 * https://projecteuler.net/problem=63
 *
 * Validated.
 */

import java.math.BigInteger;

public class p063 {

    /**
     * Counts the amount of times for which i^l has l digits, with i ranging from 1 to 9.
     * @param l the length of the number, also thep power to which i is raised.
     * @return the amount of times i^l has l digits for 0 < i < 10.
     */
    public static int powGen(int l) {
        int count = 0;
        for (int  i = 1; i < 10; i++) {
            BigInteger d = BigInteger.valueOf(i);
            BigInteger p = d.pow(l);
            if (p.toString().length() == l) {
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        long s = System.nanoTime();
        int count = 0;
        for (int length = 1; length < 25; length++) {
            count += powGen(length);
        }
        System.out.println(count);
        long e = System.nanoTime();
        System.out.println((e-s)/1000000000.0);
    }
}
