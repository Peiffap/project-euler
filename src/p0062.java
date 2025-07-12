import java.util.Arrays;

/**
 * https://projecteuler.net/problem=62
 *
 * Validated.
 */
class p062 {

    private static long[] cubes = new long[10000];
    private static boolean[] found = new boolean[10000];

    public static void main(String[] args) {
        for (int i = 2; i < cubes.length; i++) {
            cubes[i] = (long) i*i*i;
        }
        long s = System.nanoTime();
        for (int i = 354; ; i++) {
            System.out.println(i);
            if (!found[i] && cubePermutations(cubes[i], i) == 5) {
                System.out.println(cubes[i]);
                System.out.println((System.nanoTime()-s)/1000000000.0);
                System.exit(0);
            }
        }
    }

    /**
     * Computes the number of permutations of a cube that are also cubes. Cuts off if that number exceeds five.
     * @param n the cube we're taking permutations of.
     * @param cbrt the cube root of that number. This is used for efficiency.
     * @return the number of permutations of n that are also cubes, stops calculating if that number exceeds 5.
     */
    private static int cubePermutations (long n, int cbrt) {
        String str = Long.toString(n);
        int[] digits = new int[str.length()];
        int zeroes = 0;
        for (int i = 0; i < digits.length; i++) {
            digits[i] = Character.getNumericValue(str.charAt(i));
            if (digits[i] == 0) {
                zeroes++;
            }
        }
        if (zeroes > 1) {
            return 0;
        }
        int count = 1;
        int max = 9999;
        if (cbrt < 2155) {
            max = 2155;
        }
        if (cbrt < 4642) {
            max = 4642;
        }
        while (Library.nextPermutation(digits) && count < 6) {
            long temp = Library.toLong(digits);
            int index = Arrays.binarySearch(cubes, cbrt, max, temp);
            if (index > 0) {
                count++;
                found[index] = true;
            }
        }
        return count;
    }
}
