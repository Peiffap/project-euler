/**
 * Created by admin on 25/12/16.
 * Validated.
 */
public class P206 {
    public static String evenDig(long n) {
        String s = Long.toString(n);
        StringBuffer ret = new StringBuffer();
        for (int i = 0; i < s.length(); i+=2) {
            ret.append(s.charAt(i));
        }
        return ret.toString();
    }
    public static void main(String[] args) {
        long s = System.nanoTime();
        for (long i = 1000000000; i < 2000000000; i+=10) { // last digit has to be 00, so mod 10 == 0
            System.out.println(i);
            if (evenDig(i*i).equals("1234567890")) {
                System.out.println(i);
                long e = System.nanoTime();
                System.out.println((e-s)/1000000000.0);
                System.exit(0);
            }
        }
    }
}
