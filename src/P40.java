/**
 * Created by admin on 20/12/16.
 * Validated on 21/12/16 at 00:03.
 */
public class P40 {
    public static String fracString(int length) {
        StringBuffer sb = new StringBuffer();
        for (int i = 1; sb.length() < length;i++) {
            sb.append(i);
        }
        return sb.toString();
    }
    public static void main (String[] args) {
        String s = fracString(1000000);
        int d1 = Character.getNumericValue(s.charAt(0));
        int d10 = Character.getNumericValue(s.charAt(9));
        int d100 = Character.getNumericValue(s.charAt(99));
        int d1000 = Character.getNumericValue(s.charAt(999));
        int d10000 = Character.getNumericValue(s.charAt(9999));
        int d100000 = Character.getNumericValue(s.charAt(99999));
        int d1000000 = Character.getNumericValue(s.charAt(999999));
        System.out.println(d1*d10*d100*d1000*d10000*d100000*d1000000);
    }
}
