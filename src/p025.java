/**
 * https://projecteuler.net/problem=25
 *
 * Validated.
 */

import java.math.BigInteger;

public class p025 {
    public static void main(String[] args) {
        long s = System.nanoTime();
        BigInteger a = BigInteger.ONE;
        BigInteger b = BigInteger.ONE;
        int index = 2;
        while (true) {
            a = a.add(b);
            index++;
            if (a.toString().length() >= 1000) {
                break;
            }
            b = b.add(a);
            index++;
            if (b.toString().length() >= 1000) {
                break;
            }
        }
        System.out.println(index);
        long e = System.nanoTime();
        System.out.println((e-s)/1000000000.0);
        System.exit(0);
    }
}
