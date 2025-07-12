/**
 * https://projecteuler.net/problem=38
 *
 * Validated.
 */
class p038 {

    private static char[] digits = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};

    /**
     * @param s the string to examine for pandigitality.
     * @return true if s contains all characters 1 through 9 and has length 9, false if not.
     */
    private static boolean isPandigital (String s) {
        boolean allContained = s.length() == digits.length;
        for (int i = 0; i < digits.length && allContained; i++) {
            allContained = Library.contains(s, digits[i]);
        }
        return allContained ;
    }


    public static void main(String[] args) {
        long st = System.nanoTime();
        int max = 918273645;
        for (int i = 10; i < 100000; i++) {
            String s = Integer.toString(i);
            for (int n = 2; s.length() < 10; n++) {
                s = s.concat(Integer.toString(n*i));
                if (s.length() == 9 && isPandigital(s) && Integer.parseInt(s) > max) {
                    max = Integer.parseInt(s);
                }
            }
        }
        System.out.println(max);
        System.out.println((System.nanoTime()-st)/1000000000.0);
    }
}
