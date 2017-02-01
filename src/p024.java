/**
 * https://projecteuler.net/problem=24
 *
 * Validated.
 */
class p024 {
    public static void main(String[] args) {
        long s = System.nanoTime();
        int[] nums = {0,1,2,3,4,5,6,7,8,9};
        for (int i = 1; i < 1000000; i++) {
            nextPermutation(nums);
        }
        Library.showVect(nums);
        long e = System.nanoTime();
        System.out.println((e-s)/1000000000.0);
    }

    /**
     * Changes the input array (which represents a number n) such as to make it represent the next permutation of n.
     * @param array an array representation of a number.
     * @return true if there was a next permutation of array, false if not.
     */
    private static boolean nextPermutation(int[] array) {
        int i = array.length - 1;
        while (i > 0 && array[i - 1] >= array[i])
            i--;
        if (i <= 0)
            return false;
        int j = array.length - 1;
        while (array[j] <= array[i - 1])
            j--;
        int temp = array[i - 1];
        array[i - 1] = array[j];
        array[j] = temp;
        j = array.length - 1;
        while (i < j) {
            temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            i++;
            j--;
        }
        return true;
    }
}
