/**
 * Created by admin on 25/12/16.
 * Validated.
 */
public class P179 {
    public static int numDiv (int n) {
        int num = 2;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n%i == 0 && i != Math.sqrt(n))
                num += 2;
            else if (n%i == 0 && i == Math.sqrt(n))
                num++;
        }
        return num;
    }
    public static void main(String[] args) {
        long s = System.currentTimeMillis();
        int count = 0;
        for (int i = 2; i < 10000000; i++) {
            if (numDiv(i) == numDiv(i+1))
                count++;
        }
        System.out.println(count);
        long e = System.currentTimeMillis();
        System.out.println((e-s)/1000.0);
    }
}
