/**
 * https://projecteuler.net/problem=48
 *
 * Validated.
 */

import java.math.BigInteger;

class p048 {
    public static void main(String[] args) {
        long s = System.nanoTime();
        BigInteger sum = BigInteger.ZERO;
        for (int i = 1; i <= 1000; i++) {
            sum = sum.add((new BigInteger(Integer.toString(i))).pow(i));
        }
        System.out.println(sum.mod(BigInteger.TEN.pow(10)));
        long e = System.nanoTime();
        System.out.println((e-s)/1000000000.0);
    }
}
