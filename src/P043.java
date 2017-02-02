/**
 * https://projecteuler.net/problem=43
 *
 * Validated.
 */
class P043 {

    private static final int[] primes = {2, 3, 5, 7, 11, 13, 17};
    private static long[] perms = new long[Library.fact(11).intValue()];
    private static int[] digits = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

    public static void main(String[] args) {
        perms[0] = 123456789L;
        long sum = 0;
        for (int i = 1; i < perms.length; i++) {
            Library.nextPermutation(digits);
            perms[i] = Library.toLong(digits);
        }
        for (long l : perms) {
            if (hasSubstringProperty(l)) {
                sum += l;
            }
        }
        System.out.println(sum);
    }

    /**
     * Determines whether a number has the substring divisibility property.
     * @param l the number.
     * @return true if it does, false if not.
     */
    private static boolean hasSubstringProperty(final long l) {
        final String s = Long.toString(l);
        boolean hasProperty = true;
        if (s.length() == 9) { // Leading zero.
            for (int i = 0; i < 7  && hasProperty; i++) {
                hasProperty = Long.parseLong(s.substring(i, i+3))%primes[i] == 0;
            }
            return hasProperty;
        }
        for (int i = 1; i < 8  && hasProperty; i++) { // No leading zero.
            hasProperty = Long.parseLong(s.substring(i, i+3))%primes[i-1] == 0;
        }
        return hasProperty;
    }
}
