/**
 * https://projecteuler.net/problem=23
 *
 * Validated.
 */
public class p023 {

    private static boolean[] abundant = new boolean[28123];
    private static boolean[] sumOfAb = new boolean[28123];

    /**
     * Checks whether a given number is an abundant number.
     *
     * @param n the number to check.
     * @return true if n is abundant, false if not.
     */
    public static boolean isAbundant(int n) {
        return Library.divisorSum(n) > n;
    }

    public static void main(String[] args) {
        long s = System.nanoTime();
        for (int i = 1; i < abundant.length; i++) {
            if (isAbundant(i)) {
                abundant[i] = true; // If n is abundant, then abundant[n] = true.
            }
        }
        for (int i = 1; i < abundant.length; i++) {
            for (int j = 1; j < abundant.length - i; j++) { // i+j has to less than 28123.
                if (abundant[i] && abundant[j]) {
                    sumOfAb[i + j] = true; // Their sum can be written as the sum of 2 abundant numbers (i + j).
                }
            }
        }
        int sum = 0;
        for (int i = 0; i < sumOfAb.length; i++) {
            if (!sumOfAb[i]) { // If i can't be written as the sum of 2 abundant numbers.
                sum += i;
            }
        }
        System.out.println(sum);
        long e = System.nanoTime();
        System.out.println((e-s)/1000000000.0);
    }
}
