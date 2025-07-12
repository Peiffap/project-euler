/**
 * https://projecteuler.net/problem=71
 *
 * Validated.
 */
class p071 {

    static final double TS = 3/7.0;
    static final int MAX = 1_000_000;

    public static void main(String[] args) {
        long s = System.nanoTime();
        double currentLargest = -1;
        int currentNum = -1;
        double frac;
        double n;
        for (int d = MAX - 1; d > 0; d--) {
            n = Math.floor(TS * d);
            frac = n / d;
            if (frac < TS && frac > currentLargest && Library.gcd((int) n, d) == 1) {
                currentNum = (int) n;
                currentLargest = frac;
            }
        }
        System.out.println(currentNum);
        long e = System.nanoTime();
        System.out.println((e - s) / 1_000_000_000.0);
    }
}
