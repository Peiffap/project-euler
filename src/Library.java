import java.math.*;
import java.util.*;


/**
 * Library with some useful subroutines for project Euler problem solving.
 */

class Library {

    /**
     * Returns the factorial of an integer.
     *
     * @param n the integer you want to calculate the factorial of.
     * @return a BigInteger whose value is n!.
     */
    static BigInteger fact(int n) {
        BigInteger b = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            b = b.multiply(new BigInteger(Integer.toString(i)));
        }
        return b;
    }

    /**
     * Returns the sum of the digits of a BigInteger.
     *
     * @param b the BigInteger whose digits we want to sum.
     * @return the sum of the digits of b.
     */
    static int digitSum(BigInteger b) {
        int sum = 0;
        String s = b.toString();
        for (int i = 0; i < s.length(); i++) {
            sum += Character.getNumericValue(s.charAt(i));
        }
        return sum;
    }

    /**
     * Allows for easy viewing of the integers in an array by printing each of its elements to standard output.
     *
     * @param arr the array we want to view.
     */
    static void showVect(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
            if (i == arr.length - 1)
                System.out.println();
        }
    }

    /**
     * Checks an integer for primality by performing a wheel factorization of circumference 6.
     *
     * @param n the integer to check for primality.
     * @return true if n is a prime number, false if not.
     */
    static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        } else if (n < 4) {
            return true;
        } else if (n % 2 == 0 || n % 3 == 0) {
            return false;
        } else {
            int limit = sqrt(n);
            for (int i = 6; i - 1 <= limit; i += 6) {
                if (n % (i + 1) == 0 || n % (i - 1) == 0) {
                    return false;
                }
            }
            return true;
        }
    }


    /**
     * Checks a string for palindromicity.
     *
     * @param s the string to check.
     * @return true if s is a palindrome, false if not.
     */
    static boolean isPalindrome(String s) {
        StringBuilder reverse = new StringBuilder();
        for (int i = s.length() - 1; i > -1; i--) {
            reverse.append(s.charAt(i));
        }
        return reverse.toString().equals(s);
    }

    /**
     * Calculates Euler's totient function, also called the phi function, for all integers up to length and stores
     * these values in an array.
     *
     * @param length the index of the last number for which the totient function is calculated.
     * @return an array of ints with each input being the totient function of its index.
     */
    static int[] phi(int length) {
        int[] phi = new int[length + 1];
        phi[1] = 1;
        for (int i = 2; i < phi.length; i++) {
            if (phi[i] == 0) {
                phi[i] = i - 1;
                for (int j = 2; i * j < phi.length; j++) {
                    if (phi[j] == 0)
                        continue;

                    int q = j;
                    int f = i - 1;
                    while (q % i == 0) {
                        f *= i;
                        q /= i;
                    }
                    phi[i * j] = f * phi[q];
                }
            }
        }
        return phi;
    }

    /**
     * Computes the sum of the digits of a given BigDecimal.
     *
     * @param b the BigDecimal whose digits we want to sum.
     * @return the sum of the digits of b.
     */
    static int digitSum(BigDecimal b) {
        String s = b.toPlainString();
        int sum = Character.getNumericValue(s.charAt(0));
        for (int i = 2; i < s.length(); i++) {
            sum += Character.getNumericValue(s.charAt(i));
        }
        return sum;
    }

    /**
     * Computes the sum of the digits of a given integer.
     *
     * @param b the integer whose digits we want to sum.
     * @return the sum of the digits of b.
     */
    static int digitSum(int b) {
        String s = Integer.toString(b);
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum += Character.getNumericValue(s.charAt(i));
        }
        return sum;
    }

    /**
     * Computes the number of divisors of a given integer.
     *
     * @param n the integer of which we are trying to find the number of divisors.
     * @return the number of divisors this number n has.
     */
    static int numDiv(int n) {
        int divs = 0;
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0 && i * i != n) {
                divs += 2;
            } else if (n % i == 0) {
                divs++;
            }
        }
        return divs;
    }

    /**
     * @param n the integer we want to sum the divisors of.
     * @return the sum of the divisors of n.
     */
    static int divisorSum(int n) {
        int sum = 1;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0 && i * i != n) {
                sum += i + n / i;
            } else if (n % i == 0) {
                sum += i;
            }
        }
        return sum;
    }

    /**
     * Computes the sum of the letter values of s.
     *
     * @param s the string we want to know the value of.
     * @return the sum of the letter values of a given string.
     */
    static int wordValue(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum += s.charAt(i) - 'A' + 1;
        }
        return sum;
    }

    /**
     * Returns an integer that is the input integer without its last digit.
     *
     * @param n the integer to truncate.
     * @return the truncated integer.
     */
    static int truncateRight(int n) {
        String s = Integer.toString(n);
        String str = s.substring(0, s.length() - 1);
        return Integer.parseInt(str);
    }

    /**
     * Computes the floor of the square root of an integer.
     *
     * @param x the integer whose square root we are trying to find.
     * @return the integer that is the floor of the square root of x.
     */
    static int sqrt(int x) {
        int y = 0;
        for (int i = 32768; i != 0; i >>>= 1) {
            y |= i;
            if (y > 46340 || y * y > x)
                y ^= i;
        }
        return y;
    }

    /**
     * This class creates an infinite iterator with a very fast page-segmentation algorithm. It sieves only odd numbers
     * to improve performance. It outperforms most optimized sieves for inputs greater than 40M.
     */
    static class primeIterator implements Iterator<Long> {
        private final int BFSZ = 1 << 16;
        private long bi = -1;
        private long lowi = 0;
        private final ArrayList<Integer> bpa = new ArrayList<>();
        private Iterator<Long> bps;
        private final int[] buf = new int[BFSZ];

        @Override
        public boolean hasNext() {
            return true;
        }

        @Override
        public Long next() {
            final int BFBTS = BFSZ * 32;
            if (this.bi < 1) {
                if (this.bi < 0) {
                    this.bi = 0;
                    return 2L;
                }
                // this.bi must be 0.
                final int BFRNG = BFBTS * 2;
                long nxt = 3 + (this.lowi << 1) + BFRNG;
                if (this.lowi <= 0) { // Special culling for first page as no base primes yet:
                    for (int i = 0, p = 3, sqr = 9; sqr < nxt; i++, p += 2, sqr = p * p)
                        if ((this.buf[i >>> 5] & (1 << (i & 31))) == 0)
                            for (int j = (sqr - 3) >> 1; j < BFBTS; j += p)
                                this.buf[j >>> 5] |= 1 << (j & 31);
                } else { // After the first page:
                    for (int i = 0; i < this.buf.length; i++)
                        this.buf[i] = 0; // Clear the sieve buffer.
                    if (this.bpa.isEmpty()) { // If this is the first page after the zero one:
                        this.bps = new primeIterator(); // Initialize separate base primes stream:
                        this.bps.next(); // Advance past the only even prime of two.
                        this.bpa.add(this.bps.next().intValue()); // Get the next prime (3 in this case).
                    }
                    // Get enough base primes for the page range...
                    for (long p = this.bpa.get(this.bpa.size() - 1), sqr = p * p; sqr < nxt;
                         p = this.bps.next(), this.bpa.add((int) p), sqr = p * p)
                        ;
                    for (int i = 0; i < this.bpa.size() - 1; i++) {
                        long p = this.bpa.get(i);
                        long s = (p * p - 3) >>> 1;
                        if (s >= this.lowi) // Adjust start index based on page lower limit...
                            s -= this.lowi;
                        else {
                            long r = (this.lowi - s) % p;
                            s = (r != 0) ? p - r : 0;
                        }
                        for (int j = (int) s; j < BFBTS; j += p)
                            this.buf[j >>> 5] |= 1 << (j & 31);
                    }
                }
            }
            while ((this.bi < BFBTS) &&
                    ((this.buf[(int) this.bi >>> 5] & (1 << ((int) this.bi & 31))) != 0))
                this.bi++; // Find next marker still with prime status.
            if (this.bi < BFBTS) // Within buffer: output computed prime.
                return 3 + ((this.lowi + this.bi++) << 1);
            else { // Beyond buffer range: advance buffer.
                this.bi = 0;
                this.lowi += BFBTS;
                return this.next(); // And recursively loop.
            }
        }
    }

    /**
     * Returns a boolean array stating with each element stating whether its index is a prime number. If the input is
     * greater than 40M, it uses a special nested class called primeIterator, otherwise it uses a highly optimized
     * algorithm that runs faster for smaller inputs.
     *
     * @param length the number up to which the array goes.
     * @return a boolean array specifying if the index of each element is prime.
     */
    static boolean[] primeTab(int length) {
        boolean[] isPrime = new boolean[length + 1];
        if (length < 40000000) {
            if (length >= 2) {
                isPrime[2] = true;
            }
            for (int i = 3; i < isPrime.length; i += 2) {
                isPrime[i] = true; // Assume all odd numbers are primes.
            }
            int limit = Library.sqrt(length);
            int limit1;
            for (int i = 3; i <= limit; i += 2) {
                if (isPrime[i]) {
                    limit1 = length / i;
                    for (int j = i; j <= limit1; j += 2) {
                        isPrime[j * i] = false; // "Cross" out any multiples of previously found primes.
                    }
                }
            }
            return isPrime;
        }
        Iterator<Long> gen = new primeIterator();
        long i = gen.next();
        while (i <= length) {
            isPrime[(int) i] = true;
            i = gen.next();
        }
        return isPrime;
    }

    /**
     * Computes the n first primes.
     *
     * @param n the number of primes to be computed.
     * @return an array of integers containing the n first primes.
     */
    static int[] firstPrimes(int n) {
        Iterator<Long> gen = new primeIterator();
        int[] primes = new int[n];
        for (int i = 0; i < primes.length; i++) {
            primes[i] = gen.next().intValue();
        }
        return primes;
    }

    /**
     * Computes all primes below max (inclusive) and stores them in an array.
     *
     * @param max the maximum value of the primes.
     * @return the array containing all primes below max.
     */
    static int[] primesBelow(int max) {
        Iterator<Long> gen = new primeIterator();
        ArrayList<Integer> primes = new ArrayList<>();
        long i = gen.next();
        while (i <= max) {
            primes.add((int) i);
            i = gen.next();
        }
        int[] p = new int[primes.size()];
        for (int j = 0; j < p.length; j++) {
            p[j] = primes.get(j);
        }
        return p;
    }

    /**
     * Verifies whether an integer is a palindrome.
     *
     * @param n the integer to verify for palindromicity.
     * @return true if n is a palindrome, false if not.
     */
    static boolean isPalindrome(int n) {
        return isPalindrome(Integer.toString(n));
    }

    /**
     * Returns the greatest common divisor between two numbers.
     * @param a the first number.
     * @param b the second number.
     * @return the long that is the greatest common divisor between a and b.
     */
    static int gcd(int a, int b) {
    /*
     * The reason we require both arguments to be >= 0 is because otherwise, what do you return on
     * gcd(0, Integer.MIN_VALUE)? BigInteger.gcd would return positive 2^31, but positive 2^31 isn't
     * an int.
     */
        if (a == 0) {
            // 0 % b == 0, so b divides a, but the converse doesn't hold.
            return b;
        } else if (b == 0) {
            return a; // Similar logic.
        }
    /*
     * Uses the binary GCD algorithm; see http://en.wikipedia.org/wiki/Binary_GCD_algorithm. This is
     * >40% faster than the Euclidean algorithm in benchmarks.
     */
        int aTwos = Integer.numberOfTrailingZeros(a);
        a >>= aTwos; // Divide out all 2s.
        int bTwos = Integer.numberOfTrailingZeros(b);
        b >>= bTwos; // Divide out all 2s.
        while (a != b) { // Both a, b are odd.
            // The key to the binary GCD algorithm is as follows:
            // Both a and b are odd. Assume a > b; then gcd(a - b, b) = gcd(a, b).
            // But in gcd(a - b, b), a - b is even and b is odd, so we can divide out powers of two.

            // We bend over backwards to avoid branching, adapting a technique from
            // http://graphics.stanford.edu/~seander/bithacks.html#IntegerMinOrMax

            int delta = a - b; // Can't overflow, since a and b are nonnegative.

            int  minDeltaOrZero = delta & (delta >> (Integer.SIZE - 1));
            // Equivalent to Math.min(delta, 0).

            a = delta - minDeltaOrZero - minDeltaOrZero; // Sets a to Math.abs(a - b).
            // A is now nonnegative and even.

            b += minDeltaOrZero; // Sets b to min(old a, b).
            a >>= Long.numberOfTrailingZeros(a); // Divide out all 2s, since 2 doesn't divide b.
        }
        return a << Math.min(aTwos, bTwos);
    }

    /**
     * @param str the string to examine.
     * @param c   the character that we're looking for.
     * @return true if str contains c, false if not.
     */
    static boolean contains(String str, char c) {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == c) {
                return true;
            }
        }
        return false;
    }

    /**
     * Changes the input array (which represents a number n) such as to make it represent the next permutation of n.
     *
     * @param array an array representation of a number.
     * @return true if there was a next permutation of array, false if not.
     */
    static boolean nextPermutation(int[] array) {
        int i = array.length - 1;
        while (i > 0 && array[i - 1] >= array[i])
            i--;
        if (i <= 0)
            return false;
        int j = array.length - 1;
        while (array[j] <= array[i - 1])
            j--;
        int temp = array[i - 1];
        array[i - 1] = array[j];
        array[j] = temp;
        j = array.length - 1;
        while (i < j) {
            temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            i++;
            j--;
        }
        return true;
    }

    /**
     * Converts an array of digits to an integer.
     *
     * @param arr the array containing the digits.
     * @return an integer that is the concatenation of the digits in arr.
     */
    static int toInteger(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i : arr) {
            sb.append(i);
        }
        return Integer.parseInt(sb.toString());
    }

    /**
     * Converts an array of digits to a long.
     *
     * @param arr the array containing the digits.
     * @return a long that is the concatenation of the digits in arr.
     */
    static long toLong(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i : arr) {
            sb.append(i);
        }
        return Long.parseLong(sb.toString());
    }

    /**
     * Converts an array of digits to a string.
     *
     * @param arr the array containing the digits.
     * @return a string that is the concatenation of the digits in arr.
     */
    static String concatString(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i : arr) {
            sb.append(i);
        }
        return sb.toString();
    }

    /**
     * Calculates N choose K.
     *
     * @param n the number of elements.
     * @param k the number of sets.
     * @return N choose K.
     */
    static BigInteger binomialCoefficient(int n, int k) {
        if (k > n - k)
            k = n - k;
        BigInteger b = BigInteger.ONE;
        for (int i = 1, m = n; i <= k; i++, m--)
            b = b.multiply(BigInteger.valueOf(m)).divide(BigInteger.valueOf(i));
        return b;
    }

    /**
     * Calculates the subfactorial of n, sometimes written !n.
     *
     * @param num the number we're calculating the subfactorial of.
     * @return !num.
     */
    static BigInteger subfact(int num) {
        if (num == 0) {
            return BigInteger.ONE;
        }

        BigDecimal sum = BigDecimal.ZERO;
        for (int i = 0; i <= num; i++) {
            BigDecimal fact = new BigDecimal(fact(i));
            BigDecimal toAdd = BigDecimal.valueOf(Math.pow(-1, i)).divide(fact, MathContext.DECIMAL128);
            sum = sum.add(toAdd);
        }

        BigDecimal answer = new BigDecimal(fact(num)).multiply(sum, MathContext.DECIMAL128);
        return answer.toBigInteger();
    }

    static int[] primeFactorization (int n) {
        ArrayList<Integer> factorsList = PollardRho.primeFactors(n);
        int[] factors = new int[factorsList.size()];
        for (int i = 0; i < factorsList.size(); i++) {
            factors[i] = factorsList.get(i);
        }
        return factors;
    }

    static class PollardRho {

        /**
         * Hide utility class.
         */
        private PollardRho() {
        }

        /**
         * Factorization using Pollard's rho algorithm.
         * @param n number to factors, must be &gt; 0
         * @return the list of prime factors of n.
         */
        static ArrayList<Integer> primeFactors(int n) {
            final ArrayList<Integer> factors = new ArrayList<Integer>();

            n = SmallPrimes.smallTrialDivision(n, factors);
            if (1 == n) {
                return factors;
            }

            if (SmallPrimes.millerRabinPrimeTest(n)) {
                factors.add(n);
                return factors;
            }

            int divisor = rhoBrent(n);
            factors.add(divisor);
            factors.add(n / divisor);
            return factors;
        }

        /**
         * Implementation of the Pollard's rho factorization algorithm.
         * <p>
         * This implementation follows the paper "An improved Monte Carlo factorization algorithm"
         * by Richard P. Brent. This avoids the triple computation of f(x) typically found in Pollard's
         * rho implementations. It also batches several gcd computation into 1.
         * <p>
         * The backtracking is not implemented as we deal only with semi-primes.
         *
         * @param n number to factor, must be semi-prime.
         * @return a prime factor of n.
         */
        static int rhoBrent(final int n) {
            final int x0 = 2;
            final int m = 25;
            int cst = SmallPrimes.PRIMES_LAST;
            int y = x0;
            int r = 1;
            do {
                int x = y;
                for (int i = 0; i < r; i++) {
                    final long y2 = ((long) y) * y;
                    y = (int) ((y2 + cst) % n);
                }
                int k = 0;
                do {
                    final int bound = Math.min(m, r - k);
                    int q = 1;
                    for (int i = -3; i < bound; i++) { // Start at -3 to ensure we enter this loop at least 3 times.
                        final long y2 = ((long) y) * y;
                        y = (int) ((y2 + cst) % n);
                        final long divisor = Math.abs(x - y);
                        if (0 == divisor) {
                            cst += SmallPrimes.PRIMES_LAST;
                            k = -m;
                            y = x0;
                            r = 1;
                            break;
                        }
                        final long prod = divisor * q;
                        q = (int) (prod % n);
                        if (0 == q) {
                            return gcd(Math.abs((int) divisor), n);
                        }
                    }
                    final int out = gcd(Math.abs(q), n);
                    if (1 != out) {
                        return out;
                    }
                    k += m;
                } while (k < r);
                r = 2 * r;
            } while (true);
        }
    }
    static class SmallPrimes {

        /**
         * The first 512 prime numbers.
         * <p>
         * It contains all primes smaller or equal to the cubic square of Integer.MAX_VALUE.
         * As a result, <code>int</code> numbers which are not reduced by those primes are guaranteed
         * to be either prime or semi prime.
         */
        static final int[] PRIMES = {2,
                3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73,
                79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179,
                181, 191, 193, 197, 199, 211, 223, 227, 229, 233, 239, 241, 251, 257, 263, 269, 271, 277, 281, 283,
                293, 307, 311, 313, 317, 331, 337, 347, 349, 353, 359, 367, 373, 379, 383, 389, 397, 401, 409, 419,
                421, 431, 433, 439, 443, 449, 457, 461, 463, 467, 479, 487, 491, 499, 503, 509, 521, 523, 541, 547,
                557, 563, 569, 571, 577, 587, 593, 599, 601, 607, 613, 617, 619, 631, 641, 643, 647, 653, 659, 661,
                673, 677, 683, 691, 701, 709, 719, 727, 733, 739, 743, 751, 757, 761, 769, 773, 787, 797, 809, 811,
                821, 823, 827, 829, 839, 853, 857, 859, 863, 877, 881, 883, 887, 907, 911, 919, 929, 937, 941, 947,
                953, 967, 971, 977, 983, 991, 997, 1009, 1013, 1019, 1021, 1031, 1033, 1039, 1049, 1051, 1061, 1063, 1069, 1087,
                1091, 1093, 1097, 1103, 1109, 1117, 1123, 1129, 1151, 1153, 1163, 1171, 1181, 1187, 1193, 1201, 1213, 1217, 1223, 1229,
                1231, 1237, 1249, 1259, 1277, 1279, 1283, 1289, 1291, 1297, 1301, 1303, 1307, 1319, 1321, 1327, 1361, 1367, 1373, 1381,
                1399, 1409, 1423, 1427, 1429, 1433, 1439, 1447, 1451, 1453, 1459, 1471, 1481, 1483, 1487, 1489, 1493, 1499, 1511, 1523,
                1531, 1543, 1549, 1553, 1559, 1567, 1571, 1579, 1583, 1597, 1601, 1607, 1609, 1613, 1619, 1621, 1627, 1637, 1657, 1663,
                1667, 1669, 1693, 1697, 1699, 1709, 1721, 1723, 1733, 1741, 1747, 1753, 1759, 1777, 1783, 1787, 1789, 1801, 1811, 1823,
                1831, 1847, 1861, 1867, 1871, 1873, 1877, 1879, 1889, 1901, 1907, 1913, 1931, 1933, 1949, 1951, 1973, 1979, 1987, 1993,
                1997, 1999, 2003, 2011, 2017, 2027, 2029, 2039, 2053, 2063, 2069, 2081, 2083, 2087, 2089, 2099, 2111, 2113, 2129, 2131,
                2137, 2141, 2143, 2153, 2161, 2179, 2203, 2207, 2213, 2221, 2237, 2239, 2243, 2251, 2267, 2269, 2273, 2281, 2287, 2293,
                2297, 2309, 2311, 2333, 2339, 2341, 2347, 2351, 2357, 2371, 2377, 2381, 2383, 2389, 2393, 2399, 2411, 2417, 2423, 2437,
                2441, 2447, 2459, 2467, 2473, 2477, 2503, 2521, 2531, 2539, 2543, 2549, 2551, 2557, 2579, 2591, 2593, 2609, 2617, 2621,
                2633, 2647, 2657, 2659, 2663, 2671, 2677, 2683, 2687, 2689, 2693, 2699, 2707, 2711, 2713, 2719, 2729, 2731, 2741, 2749,
                2753, 2767, 2777, 2789, 2791, 2797, 2801, 2803, 2819, 2833, 2837, 2843, 2851, 2857, 2861, 2879, 2887, 2897, 2903, 2909,
                2917, 2927, 2939, 2953, 2957, 2963, 2969, 2971, 2999, 3001, 3011, 3019, 3023, 3037, 3041, 3049, 3061, 3067, 3079, 3083,
                3089, 3109, 3119, 3121, 3137, 3163, 3167, 3169, 3181, 3187, 3191, 3203, 3209, 3217, 3221, 3229, 3251, 3253, 3257, 3259,
                3271, 3299, 3301, 3307, 3313, 3319, 3323, 3329, 3331, 3343, 3347, 3359, 3361, 3371, 3373, 3389, 3391, 3407, 3413, 3433,
                3449, 3457, 3461, 3463, 3467, 3469, 3491, 3499, 3511, 3517, 3527, 3529, 3533, 3539, 3541, 3547, 3557, 3559, 3571, 3581,
                3583, 3593, 3607, 3613, 3617, 3623, 3631, 3637, 3643, 3659, 3671};

        /** The last number in PRIMES. */
        static final int PRIMES_LAST = PRIMES[PRIMES.length - 1];

        /**
         * Hide utility class.
         */
        private SmallPrimes() {
        }

        /**
         * Extract small factors.
         * @param n the number to factor, must be &gt; 0.
         * @param factors the list where to add the factors.
         * @return the part of n which remains to be factored, it is either a prime or a semi-prime.
         */
        static int smallTrialDivision(int n, final List<Integer> factors) {
            for (int p : PRIMES) {
                while (0 == n % p) {
                    n /= p;
                    factors.add(p);
                }
            }
            return n;
        }

        /**
         * Miller-Rabin probabilistic primality test for int type, used in such a way that a result is always guaranteed.
         * <p>
         * It uses the prime numbers as successive base therefore it is guaranteed to be always correct.
         * (see Handbook of applied cryptography by Menezes, table 4.1).
         *
         * @param n number to test: an odd integer &ge; 3.
         * @return true if n is prime. false if n is definitely composite.
         */
        static boolean millerRabinPrimeTest(final int n) {
            if (n < 40000000) {
                return isPrime(n);
            }
            final int nMinus1 = n - 1;
            final int s = Integer.numberOfTrailingZeros(nMinus1);
            final int r = nMinus1 >> s;
            // r must be odd, it is not checked here.
            int t = 1;
            if (n >= 2047) {
                t = 2;
            }
            if (n >= 1373653) {
                t = 3;
            }
            if (n >= 25326001) {
                t = 4;
            } // Works up to 3.2 billion, int range stops at 2.7 so we are safe.
            BigInteger br = BigInteger.valueOf(r);
            BigInteger bn = BigInteger.valueOf(n);

            for (int i = 0; i < t; i++) {
                BigInteger a = BigInteger.valueOf(SmallPrimes.PRIMES[i]);
                BigInteger bPow = a.modPow(br, bn);
                int y = bPow.intValue();
                if ((1 != y) && (y != nMinus1)) {
                    int j = 1;
                    while ((j <= s - 1) && (nMinus1 != y)) {
                        long square = ((long) y) * y;
                        y = (int) (square % n);
                        if (1 == y) {
                            return false;
                        } // Definitely composite.
                        j++;
                    }
                    if (nMinus1 != y) {
                        return false;
                    } // Definitely composite.
                }
            }
            return true; // Definitely prime.
        }
    }

    /**
     * Computes the divisors of n (that aren't 1 or n) and returns them in an array.
     *
     * @param n the integer of which we are trying to find the divisors.
     * @return the divisors this number has (other than 1 and n) stored in an array.
     */
    static int[] divisors(int n) {
        ArrayList<Integer> divs = new ArrayList<>();
        int limit = sqrt(n)+1;
        for (int i = 2; i <= limit; i++) {
            if (n % i == 0 && i != limit) {
                divs.add(i);
                divs.add(n/i);
            } else if (n % i == 0) {
                divs.add(i);
            }
        }
        int[] divisors = new int[divs.size()];
        for (int i = 0; i < divs.size(); i++) {
            divisors[i] = divs.get(i);
        }
        return divisors;
    }


    /**
     * Converts an integer to an array containing each of its digits.
     *
     * @param n the integer to convert.
     * @return the digits of this integer in an array.
     */
    static int[] integerToArray(int n) {
        String s = Integer.toString(n);
        int[] digits = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            digits[i] = Character.getNumericValue(s.charAt(i));
        }
        return digits;
    }
}