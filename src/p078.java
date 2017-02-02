/**
 * https://projecteuler.net/problem=78
 *
 * Validated.
 */
class p078 {


    private static final int MOD = 1000000;

    /**
     * Calculates their is a set size under n for which the number of partitions is a multiple of 1000000.
     * @param n the maximum set size.
     * @return the set length if there is one, Integer.MIN_VALUE otherwise.
     */
    private static int waysMod(int n) {
        int[] ways = new int[n];
        ways[0] = 1;
        for (int i = 1; i < n; i++) {
            for (int j = i; j < n; j++) {
                ways[j] = (ways[j] + ways[j-i])%MOD;
            }
        }
        for (int k = n-1; k > n/2; k--) {
            if (ways[k] == 0) {
                return k;
            }
        }
        return Integer.MIN_VALUE;
    }

    public static void main (String[] args) {
        long s = System.nanoTime();
        for (int i = 16; ; i*=2) {
            int result = waysMod(i);
            if (result >= 0) {
                System.out.println(result);
                System.out.println((System.nanoTime()-s)/1000000000.0);
                System.exit(0);
            }
        }
    }
}
