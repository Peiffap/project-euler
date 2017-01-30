/**
 * https://projecteuler.net/problem=2
 *
 * Validated.
 */
public class p002 {
    public static void main(String[] args) {
        long s = System.nanoTime();
        int dummy = 1; // F_1
        int next = 1; // F_2
        int sum = 0;
        while (dummy+next <= 4000000) {
            dummy += next;
            next += dummy;
            if (dummy%2 == 0) {
                sum += dummy;
            }
            if (next%2 == 0) {
                sum += next;
            }
        }
        System.out.println(sum);
        long e = System.nanoTime();
        System.out.println((e-s)/1000000000.0);
    }
}
