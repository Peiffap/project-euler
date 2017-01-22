/**
 * Created by admin on 25/12/16 at 17:30.
 * Validated at 18:02.
 */

import java.math.BigInteger;

public class P63 {
    public static int powGen(int length) {
        int count = 0;
        for (int  i = 1; i < 10; i++) {
            BigInteger d = BigInteger.valueOf(i);
            BigInteger p = d.pow(length);
            if (p.toString().length() == length) {
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        long s = System.nanoTime();
        int count = 0;
        for (int length = 1; length < 25; length++) {
            count += powGen(length);
        }
        System.out.println(count);
        long e = System.nanoTime();
        System.out.println((e-s)/1000000000.0);
    }
}
