/**
 * https://projecteuler.net/problem=179
 *
 * Validated.
 */
public class p179 {
    public static void main(String[] args) {
        long s = System.currentTimeMillis();
        int count = 0;
        for (int i = 2; i < 10000000; i++) {
            if (Library.numDiv(i) == Library.numDiv(i+1))
                count++;
        }
        System.out.println(count);
        long e = System.currentTimeMillis();
        System.out.println((e-s)/1000.0);
    }
}
