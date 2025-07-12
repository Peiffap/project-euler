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
            Library.nextPermutation(nums);
        }
        Library.showVect(nums);
        long e = System.nanoTime();
        System.out.println((e-s)/1000000000.0);
    }
}
