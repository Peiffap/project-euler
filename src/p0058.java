/**
 * https://projecteuler.net/problem=58
 *
 * Validated.
 */
class p058 {

    /*
     * Consider n to be the absolute value of the row number.
     * Entries on the bottom right diagonal have formula 4n^2 + 4n + 1.
     * Entries on the top right diagonal have formula 4n^2 - 2n + 1.
     * Entries on the bottom left diagonal have formula 4n^2 + 2n + 1.
     * Entries on the top left diagonal have formula 4n^2 + 1.
     */

    public static void main (String[] args) {
        long s = System.nanoTime();
        double numEval = 1.0;
        double pFound = 0.0;
        int n;
        for (n = 1; pFound/numEval > .1 || pFound == 0; n++) {
            if (Library.isPrime(4*n*n-2*n+1)) {
                pFound++;
            }
            if (Library.isPrime(4*n*n+2*n+1)) {
                pFound++;
            }
            if (Library.isPrime(4*n*n+1)) {
                pFound++;
            }
            numEval += 4;
        }
        int side = 2*n-1; // Once the condition is false, n still gets incremented, so the solution is 2n+1-2 = 2n-1.
        System.out.println(side);
        long e = System.nanoTime();
        System.out.println((e-s)/1000000000.0);
    }
}
