/**
 * https://projecteuler.net/problem=116
 *
 * Validated.
 */
public class p116 {

    /**
     * Computes the number of ways in which a mix of coloured tiles and black tiles can be laid out in a row of
     * length n, with at least one coloured tile.
     * @param n the length of the row you want to construct.
     * @param k the length of the coloured tiles you are trying to fit in.
     * @return the number of ways in which a row of length n can be constructed with at least one coloured tile.
     */
    private static long ways(final int n, final int k) {
        long[] ways = new long[n+1];
        ways[0] = 1;
        /*
         * To arrive at a row of length n, you can add a black tile to a row of length n-1. Thus
         * there are ways[n-1] rows where this is the case. On top of that, you can come from any row of
         * length n-k (if n >= k of course), where k is the length of the coloured tile you are trying to add.
         * That gives an extra ways[n-k] possible ways to construct a row of length n.
         */
        for (int i = 1; i < ways.length; i++) {
            ways[i] += ways[i-1];
            if (i >= k) {
                ways[i] += ways[i-k];
            }
        }
        return ways[n]-1; // We don't take into account the case where it's all black tiles.
    }
    public static void main (String[] args) {
        long s = System.nanoTime();
        System.out.println(ways(50, 2) + ways(50,3) + ways(50,4));
        long e = System.nanoTime();
        System.out.println((e-s)/1000000000.0);
    }
}
