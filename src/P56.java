/**
 * Created by admin on 25/12/16 at 15:00.
 * Validated at 15:13.
 */

import java.math.BigInteger;

public class P56 {
    public static void main( String[] args) {
        long st = System.currentTimeMillis();
        int max = 0;
        for (int i = 2; i < 100; i++) {
            String s = Integer.toString(i);
            BigInteger b = new BigInteger(s);
            for (int j = 1; j < 100; j++) {
                BigInteger d = b.pow(j);
                if (max < digSum(d))
                    max = digSum(d);
            }
        }
        System.out.println(max);
        long e = System.currentTimeMillis();
        System.out.println((e-st)/1000.0);
    }
    public static int digSum(BigInteger b) {
        String s = b.toString();
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum += Character.getNumericValue(s.charAt(i));
        }
        return sum;
    }
}
