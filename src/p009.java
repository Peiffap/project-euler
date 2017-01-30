/**
 * https://projecteuler.net/problem=9
 *
 * Validated.
 */
public class p009 {
    public static void main(String[] args) {
        long s = System.nanoTime();
        for (int c = 1; c < 1000; c++) {
            for (int b = c; b < 1000-c; b++) {
                for (int a = b; a < 1000-b; a++) {
                    if (c*c + b*b == a*a && a+b+c == 1000) {
                        System.out.println(a*b*c);
                        long e = System.nanoTime();
                        System.out.println((e-s)/1000000000.0);
                        System.exit(0);
                    }
                }
            }
        }
    }
}
