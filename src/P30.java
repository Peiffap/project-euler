/**
 * Created by admin on 25/12/16 at 12:56.
 * Validated at 13:03.
 */
public class P30 {
    public static void main (String[] args) {
        long s = System.currentTimeMillis();
        int sum = 0;
        for (int i = 2; i < 500000; i++) {
            if (i == digPow(i)) {
                sum += i;
            }
        }
        System.out.println(sum);
        long e = System.currentTimeMillis();
        System.out.println((e-s)/1000.0);

    }
    public static int digPow (int n) {
        int sum = 0;
        String s = Integer.toString(n);
        for (int i = 0; i < s.length(); i++) {
            int d = Character.getNumericValue(s.charAt(i));
            sum += Math.pow(d, 5);
        }
        return sum;
    }
}
