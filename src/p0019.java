/**
 * https://projecteuler.net/problem=19
 *
 * Validated.
 */
class p019 {
    public static void main (String[] args) {
        long s = System.nanoTime();
        int days = 0;
        for (int i = 1901; i < 2001; i++) {
            if (isLeapYear(i)) {
                days += 366;
            } else {
                days += 365;
            }
        }
        int sundays = 0;
        int currentDay = 3;
        for (int i = 0; i < days; i++) {
            if (currentDay%7 == 0) {
                sundays++;
            }
            currentDay++;
        }
        System.out.println((int)1200.0*sundays/days); // Probability of first day being a sunday.
        System.out.println((System.nanoTime()-s)/1000000000.0);
    }

    /**
     * @param n the year to examine.
     * @return true if n is a leap year, false if not.
     */
    private static boolean isLeapYear (int n) {
        if (n%4 == 0) {
            if (n%100 != 0 && n%400 != 0) {
                return true;
            } else if (n%100 == 0 && n%400 != 0) {
                return false;
            } else {
                return true;
            }
        }
        return false;
    }
}
