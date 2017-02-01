/**
 * https://projecteuler.net/problem=92
 *
 * Validated.
 */
public class p092 {
    /**
     * Sums the squares of the digits of n.
     * @param n the number on which the calculation is being performed.
     * @return the sum of the squares of the digits of n.
     */
    private static int digPowSum (int n) {
        int sum = 0;
        String s = Integer.toString(n);
        for (int i = 0; i < s.length(); i++) {
            int j = Character.getNumericValue(s.charAt(i));
            sum += j*j;
        }
        return sum;
    }

    /**
     * Determines whether the chain created by continuously calculating digPowSum(n) loops to 89.
     * @param n the number to check.
     * @return true if it arrives at 89, false if it arrives at 1.
     */
    private static boolean arrives89 (int n) {
        while (n != 1 && n!= 89) {
            n = digPowSum(n);
        }
        return n == 89;
    }
    public static void main (String[] args) {
        long s = System.nanoTime();
        int count = 0;
        for (int i = 1; i < 10000000; i++) {
            if (arrives89(i))
                count++;
        }
        System.out.println(count);
        long e = System.nanoTime();
        System.out.println((e-s)/1000000000.0);
    }
}
