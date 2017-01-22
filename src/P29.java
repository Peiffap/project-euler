/**
 * Created by admin on 24/12/16 at 13:05.
 * Validated at 13:37.
 */
public class P29 {
    public static void main(String[] args) {
        double[] arr = new double[10000];
        int count = 0;
        for (int i = 2; i <= 100; i++) {
            for (int j = 2; j <= 100; j++) {
                arr[count] = Math.pow(i, j);
                count++;
            }
        }
        changeDup(arr);
        System.out.println(trueLength(arr));
    }
    public static void changeDup (double[] d) {
        for (int i = 0; i < d.length; i++) {
            if (d[i] != -1) {
                double test = d[i];
                for (int j = i + 1; j < d.length; j++) {
                    if (test == d[j])
                        d[j] = 0;
                }
            }
        }
    }
    public static int trueLength (double[] d) {
        int l = 0;
        for (int i = 0; i < d.length; i++) {
            if (d[i] != 0)
                l++;
        }
        return l;
    }
    public static void showArr(double[] d) {
        for (int i = 0; i < d.length; i++) {
            System.out.println(d[i]);
        }
    }
}
