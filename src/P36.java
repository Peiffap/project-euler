/**
 * https://projecteuler.net/problem=36
 *
 * Validated.
 */
public class P36 {
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 0; i <= 1000000; i++) {
            String ten = Integer.toString(i);
            String two = Integer.toBinaryString(i);
            if (Library.isPalindrome(two) && Library.isPalindrome(ten))
                sum += i;
        }
        System.out.println(sum);
    }
}
