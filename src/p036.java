/**
 * https://projecteuler.net/problem=36
 *
 * Validated.
 */
public class p036 {
    public static void main(String[] args) {
        long s = System.nanoTime();
        int sum = 0;
        for (int i = 0; i <= 1000000; i++) {
            String ten = Integer.toString(i);
            String two = Integer.toBinaryString(i);
            if (Library.isPalindrome(two) && Library.isPalindrome(ten))
                sum += i;
        }
        System.out.println(sum);
        long e = System.nanoTime();
        System.out.println((e-s)/1000000000.0);
    }
}
