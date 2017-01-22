/**
 * Created by admin on 24/12/16 at 00:14.
 * Validated at 00:43.
 */
public class P53 {
    public static void main(String[] args) {
        long s= System.currentTimeMillis();
        int count = 0;
        for (int n = 23; n <= 100; n++) {
            for (int r = 1; r <= n; r++) {
                if (comb(n, r) > 1000000)
                    count++;
            }
        }
        System.out.println(count);
        long e = System.currentTimeMillis();
        System.out.println(e-s);
    }
    public static double comb(int n, int r) {
        if (r > n-r) {
            return (factDiv(n,r)/factDiv(n-r,0));
        }
        return (factDiv(n,n-r)/factDiv(r,0));
    }
    public static double factDiv(int top, int bottom) {
        double fact = 1;
        for (int i = bottom+1; i <= top; i++) {
            fact *= i;
        }
        return fact;
    }
}