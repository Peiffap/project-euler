import java.util.Arrays;

/**
 * https://projecteuler.net/problem=32
 *
 * Validated.
 */
class p032 {

    private static int[] digits = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    private static int[] perms = new int[Library.fact(10).intValue()]; // All 10! permutations of 123456789.

    public static void main(String[] args) {
        long sta = System.nanoTime();
        perms[0] = 123456789;
        boolean[] permsFound = new boolean[10000];
        for (int i = 1; i < perms.length; i++) {
            Library.nextPermutation(digits);
            perms[i] = Library.toInteger(digits);
        }
        long sum = 0;
        for (int i = 3; i < 50; i++) {
            String s = Integer.toString(i);
            int limit = 2000;
            if (i > 5) {
                limit = 10000/i;
            }
            for (int j = i+100; j < limit; j++) {
                String st = s + j + i*j;
                if (st.length() < 10) {
                    int search = Integer.parseInt(st);
                    if (Arrays.binarySearch(perms, search) > 0 && !permsFound[i*j]) { // Hasn't been found yet.
                        sum += i * j;
                        permsFound[i*j] = true; // Has been found.
                    }
                } else {
                    i++;
                    j = i+1;
                }
            }
        }
        System.out.println(sum);
        System.out.println((System.nanoTime()-sta)/1000000000.0);
    }
}
