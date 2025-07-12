/**
 * https://projecteuler.net/problem=15
 *
 * Validated.
 */

/*
 * This problem is a simple combinatorics problem. It basically comes down to computing the amount of
 * different orders to choose 40 elements from a set containing 40 elements (20 'RIGHT', 20 'DOWN').
*/
class p015 {
    public static void main (String[] args) {
        long s = System.nanoTime();
        System.out.println(Library.fact(40).divide(Library.fact(20).pow(2)));
        long e = System.nanoTime();
        System.out.println((e-s)/1000000000.0);
    }
}
