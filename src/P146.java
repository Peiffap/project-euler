/**
 * Created by admin on 27/12/16.
 * Validated.
 */

import java.math.BigInteger;

public class P146 {
    public static boolean primeGen (int n) {
        BigInteger b = new BigInteger(Integer.toString(n));
        b = b.pow(2);
        return consec(b);
    }
    public static void main(String[] args) {
        long s = System.nanoTime();
        int sum = 0;
        for (int i = 10; i < 1000000; i+=10) { // has to be 0 mod 10
            if(primeGen(i)) {
                sum += i;
            }
        }
        System.out.println(sum);
        long e = System.nanoTime();
        System.out.println((e-s)/1000000000.0);
    }
    public static boolean consec (BigInteger b) {
        BigInteger a = b.nextProbablePrime(); // 1
        if (!a.equals(b.add(BigInteger.ONE)))
            return false;
        BigInteger c = a.nextProbablePrime(); // 3
        if (!c.equals(b.add(new BigInteger("3"))))
            return false;
        BigInteger d = c.nextProbablePrime(); // 7
        if (!d.equals(b.add(new BigInteger("7"))))
            return false;
        BigInteger e = d.nextProbablePrime(); // 9
        if (!e.equals(b.add(new BigInteger("9"))))
            return false;
        BigInteger f = e.nextProbablePrime(); // 13
        if (!f.equals(b.add(new BigInteger("13"))))
            return false;
        BigInteger g = f.nextProbablePrime(); // 27
        if (!g.equals(b.add(new BigInteger("27"))))
            return false;
        return true;
    }
}
