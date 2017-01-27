/**
 * Created by admin on 27/01/17.
 * Validated.
 */

import java.math.BigInteger;

public class P16 {
    public static void main(String[] args) {
        long s = System.nanoTime();
        System.out.println(digSum((BigInteger.ONE.add(BigInteger.ONE)).pow(1000)));
        long e = System.nanoTime();
        System.out.println((e-s)/1000000000.0);
    }
    public static int digSum (BigInteger j) {
        int sum = 0;
        String s = j.toString();
        for (int i = 0; i < s.length(); i++) {
            sum += Character.getNumericValue(s.charAt(i));
        }
        return sum;
    }
}
