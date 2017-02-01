/**
 * https://projecteuler.net/problem=20
 *
 * Validated.
 */
class p020 {
    public static void main (String[] args) {
        long s = System.nanoTime();
        System.out.println(Library.digitSum(Library.fact(100)));
        long e = System.nanoTime();
        System.out.println((e-s)/1000000000.0);
    }
}
