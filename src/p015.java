/**
 * https://projecteuler.net/problem=15
 *
 * Validated.
 */

/*
 * This problem is a simple combinatorics problem. It basically comes down to computing the amount of
 * different orders to choose 40 elements from a set containing 40 elements (20 'RIGHT', 20 'DOWN').
*/
public class p015 {
    public static void main (String[] args) {
        System.out.println(Library.fact(40).divide(Library.fact(20).pow(2)));
    }
}
