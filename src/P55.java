/**
 * https://projecteuler.net/problem=55
 *
 * Validated.
 */

import java.math.BigInteger;

public class P55 {
    public static void main(String[] args) {
        long s = System.nanoTime();
        int count = 0;
        for (int i = 1; i < 10000; i++) {
            if (isLychrel(i))
                count++;
        }
        System.out.println(count);
        long e = System.nanoTime();
        System.out.println((e-s)/1000000000.0);
    }

    /**
     * Evaluates whether a given number is a Lychrel number.
     * @param n the number to evaluate.
     * @return true if n is a Lychrel number, false if not.
     */
    public static boolean isLychrel(long n) {
        int iter = 0;
        String s = n + "";
        BigInteger b = new BigInteger(s);
        boolean pal = false;
        while (!pal && iter < 50) {
            b = b.add(new BigInteger(reverse(b)));
            iter++;
            pal = Library.isPalindrome(reverse(b));
        }
        return iter >= 50;
    }

    /**
     * Determines the number obtained by reading a given BigInteger in reverse order.
     * @param n the BigInteger to reverse.
     * @return the string representation of the reversed number.
     */
    public static String reverse(BigInteger n) {
        String s = n.toString();
        StringBuffer reverse = new StringBuffer();
        for (int i = s.length()-1; i >-1; i--) {
            reverse.append(s.charAt(i));
        }
        return reverse.toString();
    }
}
