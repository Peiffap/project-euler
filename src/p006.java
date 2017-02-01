/**
 * https://projecteuler.net/problem=6
 *
 * Validated.
 */
class p006 {
    public static void main(String[] args) {
        long s = System.nanoTime();
        int squareSum = 1;
        for (int i = 2; i <= 100; i++) {
            squareSum += i*i;
        }
        int sumSquare = 100*101/2; // Sum of numbers up to n = n*(n+1)/2.
        sumSquare *= sumSquare;
        System.out.println(sumSquare - squareSum);
        long e = System.nanoTime();
        System.out.println((e-s)/1000000000.0);
    }
}
