import java.math.BigInteger;
/**
 * https://projecteuler.net/problem=104
 *
 * Validated.
 */
public class p104 {

    private static final char[] DIGITS = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};

    public static void main (String[] args) {
        long s = System.nanoTime();
        BigInteger f1 = BigInteger.ONE;
        BigInteger f2 = BigInteger.ONE;
        BigInteger iter;
        long index = 2;
        BigInteger mod = new BigInteger("10000000000");
        boolean doublyPandigital = false;
        while (index < 2000) { // Otherwise the numbers aren't long enough.
            iter = f1.add(f2);
            f1 = f2;
            f2 = iter;
            index++;
        }
        while (!doublyPandigital) {
            iter = f1.add(f2);
            f1 = f2;
            f2 = iter;
            index++;
            if (isPandigital(iter.remainder(mod).toString()) && isPandigital(iter.toString().substring(0, 9))){
                doublyPandigital = true;
            }
        }
        System.out.println(index);
        System.out.println((System.nanoTime()-s)/1000000000.0);
    }
    /**
     * @param s the string to examine for pandigitality.
     * @return true if s contains all characters 1 through 9, false if not.
     */
    private static boolean isPandigital(String s) {
        boolean allContained = s.length() == DIGITS.length;
        for (int i = 0; i < DIGITS.length && allContained; i++) {
            allContained = Library.contains(s, DIGITS[i]);
        }
        return allContained;
    }
}
