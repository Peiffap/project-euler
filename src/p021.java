/**
 * https://projecteuler.net/problem=21
 *
 * Validated.
 */
public class p021 {
    /**
     * @param n the integer we want to sum the divisors of.
     * @return the sum of the divisors of n.
     */
    public static int divSum (int n) {
        int sum = 1;
        for (int i = 2; i*i <= n; i++) {
            if (n%i == 0 && i*i != n) {
                sum += i + n/i;
            } else if (n%i == 0) {
                sum += i;
            }
        }
        return sum;
    }
    public static void main (String[] args) {
        long s = System.nanoTime();
        int sum = 0;
        int[] divSums = new int[10000];
        for (int i = 0; i < divSums.length; i++) {
            divSums[i] = divSum(i);
        }
        for (int i = 1; i < 10000; i++) {
            for (int j = i+1; j < 10000; j++) {
                if (divSums[i] == j && divSums[j] == i) {
                    sum += i + j;
                }
            }
        }
        System.out.println(sum);
        long e = System.nanoTime();
        System.out.println((e-s)/1000000000.0);
    }
}
