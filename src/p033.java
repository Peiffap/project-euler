/**
 * https://projecteuler.net/problem=33
 *
 * Validated.
 */
public class p033 {
    /**
     * Checks if the fraction can be solved by cancelling out digits.
     * @param n the numerator.
     * @param d the denominator.
     * @return true if it can be solved this way, false if not.
     */
    private static boolean cancelDigits(int n, int d) {
        String str1 = n + "";
        int s1 = Character.getNumericValue(str1.charAt(0));
        int s2 = Character.getNumericValue(str1.charAt(1));
        String str2 = d + "";
        int s3 = Character.getNumericValue(str2.charAt(0));
        int s4 = Character.getNumericValue(str2.charAt(1));
        if (s1 == s3) {
            return (double) s2/s4 == (double) n/d;
        } else if (s1 == s4) {
            return (double) s2/s3 == (double) n/d;
        } else if (s2 == s3) {
            return (double) s1/s4 == (double) n/d;
        } else if (s2 == s4) {
            return (double) s1/s3 == (double) n/d;
        } else {
            return false;
        }
    }

    public static void main (String[] args) {
        int count = 0;
        long s = System.nanoTime();
        for (int i = 10; i < 100 && count < 4; i++) {
            for (int j = i+1; j < 100 && count < 4; j++) {
                if (i%10 == 0 || j%10 == 0) {}
                else if (cancelDigits(i, j)) {
                    count++;
                    System.out.println(i + " " + j); // Those simplify to 1/4, 1/5, 2/5 and 1/2. Their product is 1/100.
                }
            }
        }
        long e = System.nanoTime();
        System.out.println((e-s)/1000000000.0);
    }
}
