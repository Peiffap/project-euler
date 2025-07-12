import java.util.Arrays;

/**
 * https://projecteuler.net/problem=44
 *
 * Validated.
 */
class p044 {

    private static long[] pen = new long[3400];

    public static void main (String[] args) {
        long s = System.nanoTime();
        for (int n = 1; n < pen.length; n++) {
            pen[n] = n*(3*n-1)/2;
        }
        long min = Long.MAX_VALUE;
        for (int i = 1; i < pen.length/2; i++) {
            for (int j = i + 1; i + j < pen.length; j++) {
                if (Arrays.binarySearch(pen, pen[i] + pen[j]) >= 0 // Sum is pentagonal.
                        && Arrays.binarySearch(pen, pen[j] - pen[i]) >= 0 // Difference is pentagonal.
                        && pen[j] - pen[i] < min) { // Difference is new minimum.
                    min = pen[j] - pen[i];
                }
            }
        }
        System.out.println(min);
        long e = System.nanoTime();
        System.out.println((e-s)/1000000000.0);
    }
}
