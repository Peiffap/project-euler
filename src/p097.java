/**
 * https://projecteuler.net/problem=97
 *
 * Validated.
 */

import java.math.BigInteger;

class p097 {
    public static void main(String[] args) {
        long s = System.nanoTime();
        BigInteger b = new BigInteger("2");
        b = b.pow(7830457);
        b = b.multiply(new BigInteger("28433"));
        b = b.add(new BigInteger("1"));
        BigInteger c = new BigInteger("10000000000");
        b = b.mod(c);
        System.out.println(b);
        long e = System.nanoTime();
        System.out.println((e-s)/1000000000.0);
    }
}
