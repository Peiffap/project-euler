/**
 * https://projecteuler.net/problem=29
 *
 * Validated.
 */
public class p029 {
    public static void main(String[] args) {
        long s = System.nanoTime();
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
        long e = System.nanoTime();
        System.out.println((e-s)/1000000000.0);
    }

    /**
     * Changes an array of doubles such as to replace every duplicate with 0.
     * @param d the array of doubles we want to transform duplicates in.
     */
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

    /**
     * @param d the array of doubles we want to know the true length of.
     * @return the amount on nonzero elements in d.
     */
    public static int trueLength (double[] d) {
        int l = 0;
        for (int i = 0; i < d.length; i++) {
            if (d[i] != 0)
                l++;
        }
        return l;
    }
}
