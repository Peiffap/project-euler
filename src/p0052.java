import java.util.Arrays;

/**
 * https://projecteuler.net/problem=52
 *
 * Validated.
 */
class p052 {

    /**
     * Determines whether a certain multiple of an integer n is also a permutation of that integer.
     * @param n the first number.
     * @param m the second number.
     * @return true if m*n has the same digits as n, false if not.
     */
    private static boolean sameDigits(int n, int m) {
        String s = Integer.toString(n);
        String sr = Integer.toString(m*n);
        int[] digitsn = new int[s.length()];
        int[] digitsmn = new int[sr.length()];
        for (int i = 0; i < digitsn.length; i++) {
            digitsn[i] = Character.getNumericValue(s.charAt(i));
        }
        for (int i = 0; i < digitsmn.length; i++) {
            digitsmn[i] = Character.getNumericValue(sr.charAt(i));
        }
        Arrays.sort(digitsn);
        Arrays.sort(digitsmn);
        return Arrays.equals(digitsn, digitsmn);
    }

    public static void main (String[] args) {
        long s = System.nanoTime();
        for (int i = 1; ; i++) {
            boolean found = true;
            for (int j = 2; j < 7 && found; j++) {
                found = sameDigits(i, j);
            }
            if (found) {
                System.out.println(i);
                System.out.println((System.nanoTime() - s)/1000000000.0);
                System.exit(0);
            }
        }
    }
}
