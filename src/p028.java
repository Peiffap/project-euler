/**
 * https://projecteuler.net/problem=28
 *
 * Validated.
 */
class p028 {
    public static void main (String[] args) {
        long s = System.nanoTime();
        int sum = 1;
        /*
         * Consider n to be the absolute value of the row number.
         * Entries on the top right diagonal have formula 4n^2 + 4n + 1.
         * Entries on the bottom right diagonal have formula 4n^2 - 2n + 1.
         * Entries on the top left diagonal have formula 4n^2 + 2n + 1.
         * Entries on the bottom left diagonal have formula 4n^2 + 1.
         * Sum all of these together to get 16n^2 + 4n + 4.
         */
        for (int n = 1; n <= 500; n++) {
            sum += 4*n*n + n + 1;
        }
        sum *= 4;
        System.out.println(sum-3);
        long e = System.nanoTime();
        System.out.println((e-s)/1000000000.0);
    }
}
