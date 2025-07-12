/**
 * https://projecteuler.net/problem=216
 *
 * Validated.
 */

import java.math.BigInteger;

class p216 {
    public static void main (String[] args) {
        long s = System.nanoTime();
        int count = 0;
        for (int i = 2; i < 50000000; i++) {
            if (i % 100000 == 0)
                System.out.println(i);
            BigInteger b = new BigInteger(Integer.toString(i));
            b = b.pow(2);
            b = b.multiply(new BigInteger("2"));
            b = b.subtract(new BigInteger("1"));
            if (b.isProbablePrime(20))
                count++;
        }
        System.out.println(count);
        long e = System.nanoTime();
        System.out.println((e-s)/1000000000.0);
    }
}
