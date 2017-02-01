/**
 * https://projecteuler.net/problem=30
 *
 * Validated.
 */
public class p030 {
    public static void main (String[] args) {
        long s = System.nanoTime();
        int sum = 0;
        for (int i = 2; i < 500000; i++) {
            if (i == digPow(i)) {
                sum += i;
            }
        }
        System.out.println(sum);
        long e = System.nanoTime();
        System.out.println((e-s)/1000000000.0);

    }

    /**
     * @param n the integer whose digits we want to raise to the 5th power.
     * @return the sum of the fifth powers of the digits of n.
     */
    private static int digPow (int n) {
        int sum = 0;
        String s = Integer.toString(n);
        for (int i = 0; i < s.length(); i++) {
            int d = Character.getNumericValue(s.charAt(i));
            sum += Math.pow(d, 5);
        }
        return sum;
    }
}
