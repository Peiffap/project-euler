/**
 * Created by admin on 25/12/16.
 * Validated.
 */

import java.math.BigInteger;

public class P55 {
    public static void main(String[] args) {
        long s = System.currentTimeMillis();
        int count = 0;
        for (int i = 1; i < 10000; i++) {
            if (isLychrel(i))
                count++;
        }
        System.out.println(count);
        long e = System.currentTimeMillis();
        System.out.println((e-s)/1000.0);
    }
    public static boolean isPalindrome(String s) {
        String reverse = reverse(new BigInteger(s));
        return reverse.equals(s);
    }
    public static boolean isLychrel(long n) {
        int iter = 0;
        String s = n + "";
        BigInteger b = new BigInteger(s);
        boolean pal = false;
        while (!pal && iter < 50) {
            b = b.add(new BigInteger(reverse(b)));
            iter++;
            pal = isPalindrome(reverse(b));
        }
        return iter >= 50;
    }
    public static String reverse(BigInteger n) {
        String s = n.toString();
        StringBuffer reverse = new StringBuffer();
        for (int i = s.length()-1; i >-1; i--) {
            reverse.append(s.charAt(i));
        }
        return reverse.toString();
    }
}
