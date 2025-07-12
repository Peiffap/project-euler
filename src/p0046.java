/**
 * https://projecteuler.net/problem=46
 *
 * Validated.
 */
class p046 {

    private static int[] perfSquares = new int[80]; // All perfect squares up to 80^2.
    private static int[] primes = new int[800]; // All primes under 5800. 800 is the pi(x) approximation for x = 7000.

    public static void main (String[] args) {
        long s = System.nanoTime();
        int index = 0;
        fill(); // Fills up the perfect squares array.
        boolean[] goldbach = Library.primeTab(6000); // All numbers up to 6000, true means verifies conjecture.
        for (int i = 0; i < goldbach.length; i++) {
            if (goldbach[i]) { // Conjecture applies to composite numbers, primes are always marked virtually true.
                primes[index++] = i;
            }
            if (i%2 == 0) { // Only applies to odd numbers, even numbers are marked virtually true.
                goldbach[i] = true;
            }
        }
        for (int i : primes) {
            for (int j = 1;j < perfSquares.length; j++) {
                if (i+2*perfSquares[j] < 5800) {
                    goldbach[i + 2*perfSquares[j]] = true; // Generates all possible numbers using both arrays.
                }
            }
        }
        for (int i = 33; i < goldbach.length; i++) {
            if (!goldbach[i]) { // Searches for first number that does not verify the conjecture.
                System.out.println(i);
                long e = System.nanoTime();
                System.out.println((e-s)/1000000000.0);
                System.exit(0);
            }
        }
    }

    /**
     * Fills the perfSquares array with all perfect squares up to its hardcoded length.
     */
    private static void fill() {
        for (int i = 1; i < perfSquares.length; i++) { // Fills the perfect squares.
            perfSquares[i] = i*i;
        }
    }
}
