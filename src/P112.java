/**
 * Created by admin on 25/12/16 at 17:10.
 * Validated at 17:22.
 */
public class P112 {
    public static void main(String[] args) {
        long s = System.nanoTime();
        int bouc = 0;
        for (int i = 1; i < 10000000; i++) {
            if (isBou(i))
                bouc++;
            if ((double)bouc/i >= 0.99) {
                System.out.println(i);
                long e = System.nanoTime();
                System.out.println((e-s)/1000000000.0);
                System.exit(0);
            }
        }
    }
    public static boolean isInc (int n) {
        String str = Integer.toString(n);
        for (int i = 0; i < str.length() -1; i++) {
            int b = Character.getNumericValue(str.charAt(i));
            int c = Character.getNumericValue(str.charAt(i+1));
            if (b>c)
                return false;
        }
        return true;
    }
    public static boolean isDec (int n) {
        String str = Integer.toString(n);
        for (int i = 1; i < str.length(); i++) {
            int b = Character.getNumericValue(str.charAt(i));
            int c = Character.getNumericValue(str.charAt(i-1));
            if (b > c)
                return false;
        }
        return true;
    }
    public static boolean isBou (int n) {
            return !isDec(n) && !isInc(n);
    }
}
