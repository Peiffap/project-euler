/**
 * Created by admin on 27/01/17.
 * Validated.
 */
public class P12 {
    public static int numDiv (int n) {
        int divs = 0;
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n%i == 0 && i*i != n) {
                divs += 2;
            } else if (n%i == 0) {
                divs++;
            }
        }
        return divs;
    }
    public static void main(String[] args) {
        long s = System.nanoTime();
        int num = 0;
        for (int i = 1; i < 15000; i++) {
            num += i;
            if (numDiv(num) > 500) {
                System.out.println(num);
                long e = System.nanoTime();
                System.out.println((e-s)/1000000000.0);
                System.exit(0);
            }
        }
    }
}
