/**
 * https://projecteuler.net/problem=114
 *
 * Validated.
 */
class p114 {

    public static void main(String[] args) {
        long s = System.nanoTime();
        System.out.println(ways(50, 3));
        System.out.println((System.nanoTime()-s)/1000000000.0);
    }

    /**
     * Computes in the number of ways in which a row of length n can be filled up using black tiles of length one
     * and red tiles of greater than or equal to k. Coloured tiles always have to be separated by a black tile.
     * @param n the length of the row.
     * @param k the minimum length of a coloured tile.
     * @return the number of ways in which the row can be tiled.
     */
    private static long ways(final int n, final int k) {
        if (n < k) {
            return 1;
        }
        long[] ways = new long[n+1];
        for (int i = 0; i < k; i++) {
            ways[i] = 1;
        }
        for (int i = k; i < ways.length; i++) {
            ways[i] += ways[i-1] + 1;
            for (int j = k; j < i; j++) {
                ways[i] += ways[i-j-1];
            }
        }
        return ways[n];
    }
}
