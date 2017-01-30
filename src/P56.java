/**
 * https://projecteuler.net/problem=56
 *
 * Validated.
 */

import java.math.BigInteger;

public class P56 {
    public static void main( String[] args) {
        long st = System.nanoTime();
        int max = 0;
        for (int i = 2; i < 100; i++) {
            String s = Integer.toString(i);
            BigInteger b = new BigInteger(s);
            for (int j = 1; j < 100; j++) {
                BigInteger d = b.pow(j);
                if (max < Library.digitSum(d))
                    max = Library.digitSum(d);
            }
        }
        System.out.println(max);
        long e = System.nanoTime();
        System.out.println((e-st)/1000000000.0);
    }
}
