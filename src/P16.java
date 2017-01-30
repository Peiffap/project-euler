/**
 * https://projecteuler.net/problem=16
 *
 * Validated.
 */

import java.math.BigInteger;

public class P16 {
    public static void main(String[] args) {
        long s = System.nanoTime();
        System.out.println(Library.digitSum((BigInteger.ONE.add(BigInteger.ONE)).pow(1000)));
        long e = System.nanoTime();
        System.out.println((e-s)/1000000000.0);
    }
}
