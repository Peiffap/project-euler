/**
 * https://projecteuler.net/problem=35
 *
 * Validated.
 */
class p035 {

    /**
     * @param base the integer we want to shift the digits of.
     * @return the integer created by shifting the digits of base one place to the left.
     */
    private static int shift (int base) {
        String s = Integer.toString(base);
        StringBuffer shifted = new StringBuffer();
        for (int i = 1; i < s.length(); i++) {
            shifted.append(s.charAt(i));
        }
        shifted.append(s.charAt(0));
        return Integer.parseInt(shifted.toString());
    }
    public static void main (String[] args) {
        long s = System.nanoTime();
        int count = 0;
        for (int i = 2; i < 1000000; i++) {
            if (Library.isPrime(i) && primeRotator(i) && noZero(i)) {
                count++;
            }
        }
        System.out.println(count);
        long e = System.nanoTime();
        System.out.println((e-s)/1000000000.0);
    }

    /**
     * Rotates the input prime until it wraps back around to the original input, and checks for primality every step
     * along the way. Breaks if one of the rotations isn't prime.
     * @param base the prime we want to rotate.
     * @return true if all rotations of this prime are prime as well. False if not.
     */
    private static boolean primeRotator (int base) {
        String str = Integer.toString(base);
        for (int i = 0; i < str.length(); i++) {
            base = shift(base);
            if (!Library.isPrime(base))
                return false;
        }
        return true;
    }

    /**
     * @param n the number to check for zeroes.
     * @return true if all digits of n are nonzero, false if not.
     */
    private static boolean noZero (int n) {
        String str = Integer.toString(n);
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '0')
                return false;
        }
        return true;
    }
}
