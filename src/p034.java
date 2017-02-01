/**
 * https://projecteuler.net/problem=34
 *
 * Validated.
 */
public class p034 {
    public static void main (String[] args) {
        long s = System.nanoTime();
        int sum = 0;
        for (int i = 3; i < 2800000; i++) {
            if (digFacSum(i) == i) {
                sum += i;
            }
        }
        System.out.println(sum);
        long e = System.nanoTime();
        System.out.println((e-s)/1000000000.0);
    }

    /**
     * @param n the number whose digits we want to sum the factorials of.
     * @return the sum of the factorials of the digits of n.
     */
    private static int digFacSum (int n) {
        String s = Integer.toString(n);
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            int d = Character.getNumericValue(s.charAt(i));
            sum += Library.fact(d).intValue();
        }
        return sum;
    }
}