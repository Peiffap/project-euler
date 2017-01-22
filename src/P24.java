/**
 * Created by admin on 29/12/16.
 * Validated.
 */
public class P24 {
    public static void main(String[] args) {
        long s = System.nanoTime();
        int[] nums = {0,1,2,3,4,5,6,7,8,9};
        for (int i = 1; i < 1000000; i++) {
            nextPermutation(nums);
        }
        showVect(nums);
        long e = System.nanoTime();
        System.out.println((e-s)/1000000000.0);
    }
    public static boolean nextPermutation(int[] array) {
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
    public static void showVect(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i == arr.length-1)
                System.out.println();
        }
    }
}
