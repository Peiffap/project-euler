/**
 * Created by admin on 27/01/17.
 * Validated.
 */
public class P2 {
    public static void main(String[] args) {
        long s = System.nanoTime();
        int dummy = 1;
        int next = 1;
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
