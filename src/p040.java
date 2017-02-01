/**
 * https://projecteuler.net/problem=40
 *
 * Validated.
 */
public class p040 {
    /**
     * Returns the smallest string of consecutive integers of length greater than or equal to l.
     * @param l the minimum length of the string
     * @return the smallest string of consecutive integers of length greater than or equal to l.
     */
    private static String numString(int l) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; sb.length() < l; i++) {
            sb.append(i);
        }
        return sb.toString();
    }
    public static void main (String[] args) {
        long st = System.nanoTime();
        String s = numString(1000000);
        int d1 = Character.getNumericValue(s.charAt(0));
        int d10 = Character.getNumericValue(s.charAt(9));
        int d100 = Character.getNumericValue(s.charAt(99));
        int d1000 = Character.getNumericValue(s.charAt(999));
        int d10000 = Character.getNumericValue(s.charAt(9999));
        int d100000 = Character.getNumericValue(s.charAt(99999));
        int d1000000 = Character.getNumericValue(s.charAt(999999));
        System.out.println(d1*d10*d100*d1000*d10000*d100000*d1000000);
        long e = System.nanoTime();
        System.out.println((e-st)/1000000000.0);
    }
}
