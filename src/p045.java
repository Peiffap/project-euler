import java.util.Arrays;

/**
 * https://projecteuler.net/problem=45
 *
 * Validated.
 */

public class p045 {
    public static void main (String[] args) {
        long s = System.nanoTime();
        long[] pen = new long[35000];
        long[] hex = new long[40000];
        pen[1] = 1;
        for (int n = 2; n < pen.length; n++) {
            pen[n] = pen[n-1] + 3*n - 2; // Recurrence equation for pentagonal numbers.
            hex[n] = n*(2*n-1); // Every hexagonal number is also a triangular number.
        }
        for (int i = 170; i < pen.length; i++) {
            if (Arrays.binarySearch(hex, pen[i]) >= 0) { // Returns a positive value only if the element was found.
                System.out.println(pen[i]);
                long e = System.nanoTime();
                System.out.println((e-s)/1000000000.0);
                System.exit(0);
            }
        }
    }
}
