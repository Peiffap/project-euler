/**
 * https://projecteuler.net/problem=1
 *
 * Validated.
 */
class p001 {
    public static void main(String[] args) {
        long s = System.nanoTime();
        int sum = 0;
        for (int i = 3; i < 1000; i++) {
            if (i%3 == 0 || i%5 == 0) {
                sum += i;
            }
        }
        System.out.println(sum);
        long e = System.nanoTime();
        System.out.println((e-s/1000000000.0));
    }
}
