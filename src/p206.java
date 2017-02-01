/**
 * https://projecteuler.net/problem=206
 *
 * Validated.
 */
public class p206 {

    /**
     * Returns a string representation of the number found by only taking into account the even digits of n.
     * @param n the number whose even digits we want to find.
     * @return a string representation of the number found by only taking into account the even digits of n.
     */
    private static String evenDig(long n) {
        String s = Long.toString(n);
        StringBuilder ret = new StringBuilder();
        for (int i = 0; i < s.length(); i+=2) {
            ret.append(s.charAt(i));
        }
        return ret.toString();
    }
    public static void main(String[] args) {
        long s = System.nanoTime();
        for (long i = 1000000000; i < 2000000000; i+=10) { // Last digit has to be 0, so mod 10 == 0
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
