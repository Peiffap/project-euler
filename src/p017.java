/**
 * https://projecteuler.net/problem=17
 *
 * Validated.
 */
class p017 {
    private static String s = "teneleventwelvethirteenfourteenfifteensixteenseventeeneighteennineteen";
    public static void main (String[] args) {
        long st = System.nanoTime();
        String str = "teneleventwelvethirteenfourteenfifteensixteenseventeeneighteennineteen";
        for (int i = 1; i < 10; i++) {
            s = s.concat(str);
        }
        for (int i = 1; i < 1000; i++) {
            int a = (i % 100) / 10;
            int b = i % 10;
            int c = i / 100;
            digitAdd(c,a,b);
        }
        s = s.concat("onethousand");
        System.out.println(s.length());
        System.out.println((System.nanoTime()-st)/1000000000.0);
    }
    /**
     * Adds words of a certain length to the string.
     * @param c the first digit of the integer between 0 and 1000.
     * @param a the second digit.
     * @param b the last digit.
     */
    private static void digitAdd (int c, int a, int b) {
        if (a != 1) {
            if (a == 2) {
                s = s.concat("twenty");
            } else if (a == 3) {
                s = s.concat("thirty");
            } else if (a == 4) {
                s = s.concat("forty");
            } else if (a == 5) {
                s = s.concat("fifty");
            } else if (a == 6) {
                s = s.concat("sixty");
            } else if (a == 7) {
                s = s.concat("seventy");
            } else if (a == 8) {
                s = s.concat("eighty");
            } else if (a == 9) {
                s = s.concat("ninety");
            }

            if (b == 1) {
                s = s.concat("one");
            } else if (b == 2) {
                s = s.concat("two");
            } else if (b == 3) {
                s = s.concat("three");
            } else if (b == 4) {
                s = s.concat("four");
            } else if (b == 5) {
                s = s.concat("five");
            } else if (b == 6) {
                s = s.concat("six");
            } else if (b == 7) {
                s = s.concat("seven");
            } else if (b == 8) {
                s = s.concat("eight");
            } else if (b == 9) {
                s = s.concat("nine");
            }
        }

        if (c == 1) {
            s = s.concat("onehundred");
        } else if (c == 2){
            s = s.concat("twohundred");
        } else if (c == 3) {
            s = s.concat("threehundred");
        } else if (c == 4) {
            s = s.concat("fourhundred");
        } else if (c == 5) {
            s = s.concat("fivehundred");
        } else if (c == 6) {
            s = s.concat("sixhundred");
        } else if (c == 7) {
            s = s.concat("sevenhundred");
        } else if (c == 8) {
            s = s.concat("eighthundred");
        } else if (c == 9) {
            s = s.concat("ninehundred");
        }

        if (c > 0 && a+b != 0) {
            s = s.concat("and");
        }
    }
}
