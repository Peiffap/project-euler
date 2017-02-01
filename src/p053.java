/**
 * https://projecteuler.net/problem=53
 *
 * Validated.
 */
class p053 {
    public static void main(String[] args) {
        long s= System.nanoTime();
        int count = 0;
        for (int n = 23; n <= 100; n++) {
            for (int r = 1; r <= n; r++) {
                if (comb(n, r) > 1000000)
                    count++;
            }
        }
        System.out.println(count);
        long e = System.nanoTime();
        System.out.println(e-s/1000000000.0);
    }

    /**
     * Calculates combinatoric selections.
     * @param n the amount of elements in the set.
     * @param r the amount of elements to be taken from the set.
     * @return the amount of possible ways to to take r elements from a set of n elements.
     */
    private static double comb(int n, int r) {
        if (r > n-r) {
            return (factDiv(n,r)/factDiv(n-r,0));
        }
        return (factDiv(n,n-r)/factDiv(r,0));
    }

    /**
     * Calculates a fraction of factorials.
     * @param t the number whose factorial is in the numerator.
     * @param b the number whose factorial is in the denominator.
     * @return top!/bottom!
     */
    private static double factDiv(int t, int b) {
        double fact = 1;
        for (int i = b+1; i <= t; i++) {
            fact *= i;
        }
        return fact;
    }
}