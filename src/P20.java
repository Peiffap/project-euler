/**
 * Created by admin on 27/01/17.
 * Validated.
 */

import java.math.BigInteger;

public class P20 {
    public static BigInteger fact (int n) {
        BigInteger b = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            b = b.multiply(new BigInteger(Integer.toString(i)));
        }
        return b;
    }

    public static int digSum (BigInteger j) {
        int sum = 0;
        String s = j.toString();
        for (int i = 0; i < s.length(); i++) {
            sum += Character.getNumericValue(s.charAt(i));
        }
        return sum;
    }

    public static void main (String[] args) {
        long s = System.nanoTime();
        System.out.println(digSum(fact(100)));
        long e = System.nanoTime();
        System.out.println((e-s)/1000000000.0);
    }
}
