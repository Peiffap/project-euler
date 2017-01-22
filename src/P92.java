/**
 * Created by admin on 26/12/16.
 * Validated.
 */
public class P92 {
    public static int digPowSum (int n) {
        int sum = 0;
        String s = Integer.toString(n);
        for (int i = 0; i < s.length(); i++) {
            int j = Character.getNumericValue(s.charAt(i));
            sum += j*j;
        }
        return sum;
    }
    public static boolean a89 (int n) {
        while (n != 1 && n!= 89) {
            n = digPowSum(n);
        }
        return n == 89;
    }
    public static void main (String[] args) {
        long s = System.nanoTime();
        int count = 0;
        for (int i = 1; i < 10000000; i++) {
            if (a89(i))
                count++;
        }
        System.out.println(count);
        long e = System.nanoTime();
        System.out.println((e-s)/1000000000.0);
    }
}
