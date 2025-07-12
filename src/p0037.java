/**
 * https://projecteuler.net/problem=37
 *
 * Validated.
 */
class p037 {
    public static void main (String[] args) {
        long s = System.nanoTime();
        int count = 0;
        int sum = 0;
        for (int i = 10; true; i++) {
            if (isTruncatable(i)) {
                count++;
                sum += i;
                if (count == 11) {
                    System.out.println(sum);
                    long e = System.nanoTime();
                    System.out.println((e-s)/1000000000.0);
                    System.exit(0);
                }
            }
        }
    }

    /**
     * Returns an integer that is the input integer without its first digit.
     * @param n the integer to truncate.
     * @return the truncated integer.
     */
    private static int truncateLeft(int n) {
        String s = Integer.toString(n);
        String str = s.substring(1,s.length());
        return Integer.parseInt(str);
    }

    /**
     * Evaluates whether a given integer's left truncations and right truncations are also primes.
     * @param n the integer to check.
     * @return true if n is truncatable, false if not.
     */
    private static boolean isTruncatable(int n) {
        int dummy = n;
        while (Library.isPrime(n) && n > 9) {
            n = truncateLeft(n);
        }
        if (n > 9 || !Library.isPrime(n) || n < 2)
            return false;
        n = dummy;
        while (Library.isPrime(n) && n > 9) {
            n = Library.truncateRight(n);
        }
        if (n > 9 || !Library.isPrime(n) || n < 2)
            return false;
        return true;
    }
}
