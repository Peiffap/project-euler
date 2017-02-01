/**
 * https://projecteuler.net/problem=21
 *
 * Validated.
 */
class p021 {
    public static void main (String[] args) {
        long s = System.nanoTime();
        int sum = 0;
        int[] divSums = new int[10000];
        for (int i = 0; i < divSums.length; i++) {
            divSums[i] = Library.divisorSum(i);
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
