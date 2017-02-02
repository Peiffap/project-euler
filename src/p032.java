/**
 * https://projecteuler.net/problem=32
 *
 * Validated.
 */
class p032 {

    private static final char[] DIGITS = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};


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


    public static void main(String[] args) {
        boolean[] found = new boolean[10000]; // If i*j is any bigger then the concatenation has more than 9 digits.
        long sta = System.nanoTime();
        int sum = 0;
        int limit;
        String st;
        for (int i = 1; i < 100; i++) { // i can't be >100, or else 1001010100 is the shortest possible string.
            String s = Integer.toString(i);
            limit = 10000/i;
            /*
             * j has to be bigger than i, because if j < i then the combination has been tried out before, and if
             * j = i, then the concatenated string will contain the digits of i twice.
             */
            for (int j = i+1; j  < limit; j++) {
                st = s.concat(Integer.toString(j).concat(Integer.toString(i*j)));
                if (!found[i*j] && isPandigital(st)) { // Is pandigital and hasn't been found yet.
                    sum += i*j;
                    found[i*j] = true; // Has been found now.
                }
            }
        }
        System.out.println(sum);
        System.out.println((System.nanoTime()-sta)/1000000000.0);
    }
}
