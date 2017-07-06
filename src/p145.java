/**
 * https://projecteuler.net/problem=145
 *
 * Validated.
 */
class p145 {
    public static void main(String[] args) {
        long s = System.nanoTime();
        int count = 0;
        for (int i = 1; i < 1000000000; i++) {
            String str = reversedNum(i);
            if (onlyOdd(str) && i%10 != 0)
                count++;
        }
        System.out.println(count);
        long e = System.nanoTime();
        System.out.println((e-s)/1000000000.0);
    }

    /**
     * Returns a string that has the input integer's digits in reverse order.
     * @param n the input integer.
     * @return the string that has the input integer's digits in reverse order.
     */
    private static String reversedNum (int n) {
        String s = Integer.toString(n);
        StringBuilder r = new StringBuilder();
        for (int i = s.length() -1; i > -1; i--) {
            r.append(s.charAt(i));
        }
        int p = Integer.parseInt(s) + Integer.parseInt(r.toString());
        return Integer.toString(p);
    }

    /**
     * Determines whether a given number has only odd digits.
     * @param s the string representation of the number.
     * @return true if all the digits are odd, false if not.
     */
    private static boolean onlyOdd(String s) {
        for (int i = 0; i < s.length(); i++) {
            int d = Character.getNumericValue(s.charAt(i));
            if (d%2 == 0)
                return false;
        }
        return true;
    }
}
