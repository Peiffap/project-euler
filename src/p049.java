import java.util.Arrays;
/**
 * https://projecteuler.net/problem=49
 *
 * Validated.
 */
class p049 {
    public static void main (String[] args) {
        long s = System.nanoTime();
        boolean[] primes = Library.primeTab(10000);
        int index = 0;
        int j = 0;
        int k = 0;
        int[] results = new int[24];
        boolean condition = true;
        for (int i = 1001; i < 10000; i++) {
            int[] digits = Library.integerToArray(i);
            int[] digits2 = Arrays.copyOf(digits, digits.length);
            if (primes[i] && !Library.contains(Integer.toString(i), '0')) {
                index++;
                while (Library.nextPermutation(digits) && condition) {
                    if (primes[Library.arrayToInteger(digits)]) {
                        index++;
                        if (index == 2) {
                            j = Library.arrayToInteger(digits);
                        }
                        if (index == 3) {
                            k = Library.arrayToInteger(digits);
                        }
                    }
                }
                if (index == 3 && k - j == j- i && i != 1487) {
                    int a = 1;
                    results[0] = i;
                    while (Library.nextPermutation(digits2)) {
                        results[a++] = Library.arrayToInteger(digits2);
                    }
                    for (int b : results) {
                        if (primes[b]) {
                            System.out.println(b);
                        }
                    }
                    System.out.println((System.nanoTime()-s)/1000000000.0);
                    System.exit(0);
                }
                index = 0;
            }
        }
    }
}
