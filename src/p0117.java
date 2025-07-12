/**
 * https://projecteuler.net/problem=117
 *
 * Validated.
 */
class p117 {

    /**
     * Computes the number of ways in which a row of length n can be filled up with tiles of lengths 1, i, j and k.
     * @param n the length of the row.
     * @param i the length of the first oblong tile.
     * @param j the length of the second oblong tile.
     * @param k the length of the third oblong tile.
     * @return the number of ways in which a row of length n can be filled up with tiles of lengths 1, i, j and k.
     */
    private static long ways(int n, int i, int j, int k) {
        long[] ways = new long[n+1];
        ways[0] = 1;
        /*
         * To arrive at a row of length n, you can add a black tile to a row of length n-1. Thus
         * there are ways[n-1] rows where this is the case. On top of that, you can come from any row of
         * length n-i, n-j or n-k (if n >= i,j,k of course), where i,j,k are the lengths of the coloured tiles you are
         * trying to add. That gives an extra ways[n-i] + ways[n-j] + ways[n-k] possible ways to construct a row of
         * length n.
         */
        for (int x = 1; x < ways.length; x++) {
            ways[x] += ways[x-1];
            if (x >= i) {
                ways[x] += ways[x-i];
            }
            if (x >= j) {
                ways[x] += ways[x-j];
            }
            if (x >= k) {
                ways[x] += ways[x-k];
            }
        }
        return ways[n];
    }

    public static void main(String[] args) {
        long s = System.nanoTime();
        System.out.println(ways(50, 2, 3, 4));
        long e = System.nanoTime();
        System.out.println((e-s)/1000000000.0);
    }
}
