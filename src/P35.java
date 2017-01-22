/**
 * Created by admin on 23/12/16 at 21:46.
 * Validated at 22:33.
 */
public class P35 {
    public static int shift (int base) {
        String s = Integer.toString(base);
        StringBuffer shift = new StringBuffer();
        for (int i = 1; i < s.length(); i++) {
            shift.append(s.charAt(i));
        }
        shift.append(s.charAt(0));
        return Integer.parseInt(shift.toString());
    }
    public static void main (String[] args) {
        int count = 0;
        for (int i = 2; i < 1000000; i++) {
            if (isPrime(i) && primeRotator(i) && noZero(i)) {
                count++;
            }

        }
        System.out.println(count);
    }
    public static boolean isPrime (int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n%i == 0)
                return false;
        }
        return true;
    }
    public static boolean primeRotator (int base) {
        String str = Integer.toString(base);
        for (int i = 0; i < str.length(); i++) {
            base = shift(base);
            if (!isPrime(base))
                return false;
        }
        return true;
    }
    public static boolean noZero (int n) {
        String str = Integer.toString(n);
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '0')
                return false;
        }
        return true;
    }
}
