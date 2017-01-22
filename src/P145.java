/**
 * Created by admin on 25/12/16 at 15:25.
 * Validated at 15:49.
 */
public class P145 {
    public static void main(String[] args) {
        long s = System.nanoTime();
        int count = 0;
        for (int i = 1; i < 1000000000; i++) {
            String str = reversedNum(i);
            if (onlyOdd(str) && i%10 != 0)
                count++;
            if (i%1000000 == 0)
                System.out.println(i);
        }
        System.out.println(count);
        long e = System.nanoTime();
        System.out.println((e-s)/1000000000.0);
    }
    public static String reversedNum (int n) {
        String s = Integer.toString(n);
        StringBuffer r = new StringBuffer();
        for (int i = s.length() -1; i > -1; i--) {
            r.append(s.charAt(i));
        }
        int p = Integer.parseInt(s) + Integer.parseInt(r.toString());
        return Integer.toString(p);
    }
    public static boolean onlyOdd(String s) {
        for (int i = 0; i < s.length(); i++) {
            int d = Character.getNumericValue(s.charAt(i));
            if (d%2 == 0)
                return false;
        }
        return true;
    }
}
