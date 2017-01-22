/**
 * Created by admin on 25/12/16 at 12:36.
 * Validated at 12:47.
 */
public class P34 {
    public static int fact (int x) {
        int f = 1;
        for (int i = 1; i <= x; i++) {
            f *= i;
        }
        return f;
    }
    public static void main (String[] args) {
        long s = System.currentTimeMillis();
        int sum = 0;
        for (int i = 3; i < 2800000; i++) {
            if (digFacSum(i) == i) {
                sum += i;
            }
        }
        System.out.println(sum);
        long e = System.currentTimeMillis();
        System.out.println((e-s)/1000.0);
    }
    public static int digFacSum (int n) {
        String s = Integer.toString(n);
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            int d = Character.getNumericValue(s.charAt(i));
            sum += fact(d);
        }
        return sum;
    }
}