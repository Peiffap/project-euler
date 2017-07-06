/**
 * https://projecteuler.net/problem=50
 *
 * Validated.
 */
class p050 {
    public static void main (String[] args) {
        long s = System.nanoTime();
        int[] primes = Library.primesBelow(999999);
        int maxLength = 21;
        int num = 953;
        for (int start = 0; start < primes.length-701; start++) {
            for (int end = start+700; end > start; end--) {
                int x = arrayConsecSum(primes, start, end);
                if (Library.isPrime(x) && end-start > maxLength && x < 1000000) {
                    maxLength = end-start;
                    num = x;
                }
            }
        }
        System.out.println(num);
        long e = System.nanoTime();
        System.out.println((e-s)/1000000000.0);
    }
    /**
     * Computes the sum of a certain subset of consecutive integers in a array.
     * @param arr the array.
     * @param start the index of the first element
     * @param end the index of the last element
     * @return the sum of the elements in arr, from arr[start] till arr[end].
     */
    private static int arrayConsecSum(int[] arr, int start, int end) {
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += arr[i];
        }
        return sum;
    }
}