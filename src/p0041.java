/**
 * https://projecteuler.net/problem=41
 *
 * Validated.
 */
class p041 {
    /**
     * Checks whether a certain character occurs in a given string.
     * @param s the string to check.
     * @param c the character to search for.
     * @return true if s contains c, false if not.
     */
    private static boolean contains (String s, char c) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c)
                return true;
        }
        return false;
    }
    public static void main(String[] args) {
        long s = System.nanoTime();
        for (int i = 10000000; i > 1000000; i--) {
            String str = Integer.toString(i);
            if (Library.isPrime(i) && contains(str, '1') && contains(str, '2') && contains(str, '3')
                    && contains(str, '4') && contains(str, '5') && contains(str, '6')
                    && contains(str, '7')) {
                System.out.println(i); // With 9 and 8 digits, n%3 is always 0.
                long e = System.nanoTime();
                System.out.println((e-s)/1000000000.0);
                System.exit(0);
            }
        }
    }
}

