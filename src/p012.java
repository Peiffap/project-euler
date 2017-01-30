/**
 * https://projecteuler.net/problem=12
 *
 * Validated.
 */
public class p012 {
    public static void main(String[] args) {
        long s = System.nanoTime();
        int num = 0;
        for (int i = 1; i < 15000; i++) {
            num += i;
            if (Library.numDiv(num) > 500) {
                System.out.println(num);
                long e = System.nanoTime();
                System.out.println((e-s)/1000000000.0);
                System.exit(0);
            }
        }
    }
}
