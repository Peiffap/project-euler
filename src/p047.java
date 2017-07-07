import java.util.Arrays;
/**
 * https://projecteuler.net/problem=47
 *
 * Validated.
 */
class p047 {
    public static void main (String[] args) {
        boolean[] primeTab = Library.primeTab(150000);
        long s = System.nanoTime();
        int[] distinctFactors = new int[150000];
        for (int i = 1; i < distinctFactors.length; i++) {
            if (primeTab[i])
                i++;
            distinctFactors[i] = distinctPrimeFactors(i);
            if (distinctFactors[i] == 4 && distinctFactors[i - 1] == 4 && distinctFactors[i - 2] == 4 && distinctFactors[i - 3] == 4) {
                System.out.println(i - 3);
                System.out.println((System.nanoTime() - s) / 1000000000.0);
                System.exit(0);
            }
        }
    }
    /**
     * Computes the number of distinct prime factors of a given integer.
     * @param n the integer.
     * @return the number of distinct prime factors of n.
     */
    private static int distinctPrimeFactors (int n) {
        int[] factorsWithDup = Library.primeFactorization(n);
        return removeDuplicates(factorsWithDup).length;
    }
    /**
     * Removes duplicates from an array of integers.
     * @param arr the array.
     * @return A new array containing the same integers, but without duplicates.
     */
    private static int[] removeDuplicates (int[] arr) {
        int[] dup = new int[arr.length];
        int index = 0;
        for (int i : arr) {
            if (!Library.contains(dup, i)) {
                dup[index] = i;
                index++;
            }
        }
        int firstZero = 0;
        for (int i = 0; i < dup.length; i++) {
            if (dup[i] == 0) {
                firstZero = i;
                break;
            }
        }
        if (firstZero == 0) {
            return dup;
        }
        return Arrays.copyOf(dup,firstZero);
    }
}
