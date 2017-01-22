/**
 * Created by admin on 23/12/16 at 22:38.
 * Validated at 22:47.
 */
public class P36 {
    public static boolean isPalindrome(String s) {
        StringBuffer reverse = new StringBuffer();
        for (int i = s.length()-1; i >-1; i--) {
            reverse.append(s.charAt(i));
        }
        return reverse.toString().equals(s);
    }
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 0; i <= 1000000; i++) {
            String ten = Integer.toString(i);
            String two = Integer.toBinaryString(i);
            if (isPalindrome(two) && isPalindrome(ten))
                sum += i;
        }
        System.out.println(sum);
    }
}
