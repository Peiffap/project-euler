import java.util.Arrays;

/**
 * https://projecteuler.net/problem=70
 *
 * Validated.
 */

public class p070 {
    public static void main(String[] args) {
        long s = System.nanoTime();
        double minRatio = Double.POSITIVE_INFINITY;
        int result = 0;
        int[] phi = Library.phi(10000000);
        for (int i = 2; i < 10000000; i++) {
                char[] a = Integer.toString(i).toCharArray();
                char[] a2 = Integer.toString(phi[i]).toCharArray();
                Arrays.sort(a);
                Arrays.sort(a2);
                if (Arrays.equals(a, a2) && (double) i / phi[i] < minRatio) {
                    minRatio = (double) i / phi[i];
                    result = i;
                }
        }
        System.out.println(result);
        long e = System.nanoTime();
        System.out.println((e-s)/1000000000.0);
    }
}
