/**
 * Created by admin on 25/12/16.
 * Validated.
 */

import java.math.BigDecimal;

public class P80 {
    public static void main(String[] args) {
        long s = System.nanoTime();
        int sum = 0;
        for (int i = 2; i < 100; i++) {
            if (i != 4 && i != 9 && i != 16 && i != 25 && i != 36 && i != 49 && i != 64 && i != 81) {
                BigDecimal test = new BigDecimal(i);
                sum += digSum(sqrt(test,101));
            }
        }
        System.out.println(sum);
        long e = System.nanoTime();
        System.out.println((e-s)/1000000000.0);
    }
    public static int digSum (BigDecimal b) {
        String s = b.toPlainString();
        int sum = Character.getNumericValue(s.charAt(0));
        for (int i = 2; i < 101; i++) {
            sum += Character.getNumericValue(s.charAt(i));
        }
        return sum;
    }
    public static BigDecimal sqrt(BigDecimal A, final int SCALE) {
        BigDecimal x0 = new BigDecimal("0");
        BigDecimal x1 = new BigDecimal(Math.sqrt(A.doubleValue()));
        BigDecimal TWO = new BigDecimal(2);
        while (!x0.equals(x1)) {
            x0 = x1;
            x1 = A.divide(x0, SCALE, BigDecimal.ROUND_HALF_UP);
            x1 = x1.add(x0);
            x1 = x1.divide(TWO, SCALE, BigDecimal.ROUND_HALF_UP);

        }
        return x1;
    }
}