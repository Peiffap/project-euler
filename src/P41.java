/**
 * Created by admin on 23/12/16 at 22:51.
 * Validated at 23:18.
 */
public class P41 {
    public static boolean contains (String s, char c) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c)
                return true;
        }
        return false;
    }
    public static boolean isPrime (int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n%i == 0)
                return false;
        }
        return true;
    }
    public static void main(String[] args) {
        for (int i = 10000000; i > 1000000; i--) {
            String str = Integer.toString(i);
            if (isPrime(i) && contains(str, '1') && contains(str, '2') && contains(str, '3') && contains(str, '4') && contains(str, '5') && contains(str, '6') && contains(str, '7')) {
                System.out.println(i); // with 9 and 8 digits, mod3 is always 0
                System.exit(0);
            }
        }
    }
}

