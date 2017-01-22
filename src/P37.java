/**
 * Created by admin on 27/12/16.
 * Validated.
 */
public class P37 {
    public static void main (String[] args) {
        long s = System.nanoTime();
        int count = 0;
        int sum = 0;
        for (int i = 10; i > 1; i++) {
            if (isTrunc(i)) {
                count++;
                sum += i;
                if (count == 11) {
                    System.out.println(sum);
                    long e = System.nanoTime();
                    System.out.println((e-s)/1000000000.0);
                    System.exit(0);
                }
            }
        }
    }
    public static int truncL(int n) {
        String s = Integer.toString(n);
        String str = s.substring(1,s.length());
        return Integer.parseInt(str);
    }
    public static int truncR(int n) {
        String s = Integer.toString(n);
        String str = s.substring(0, s.length()-1);
        return Integer.parseInt(str);
    }
    public static boolean isTrunc(int n) {
        int dummy = n;
        while (isPrime(n) && n > 9) {
            n = truncL(n);
        }
        if (n > 9 || !isPrime(n) || n < 2)
            return false;
        n = dummy;
        while (isPrime(n) && n > 9) {
            n = truncR(n);
        }
        if (n > 9 || !isPrime(n) || n < 2)
            return false;
        return true;
    }
    public static boolean isPrime(int n) {
        for (int i = 2; i*i <= n; i++) {
            if (n%i == 0)
                return false;
        }
        return true;
    }
}
