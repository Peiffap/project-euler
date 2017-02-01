import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Library with some useful subroutines for project Euler problem solving.
 */

public class Library {

    /**
     * Returns the factorial of an integer.
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
     * @param b the BigInteger whose digits we want to sum.
     * @return the sum of the digits of b.
     */
    static int digitSum (BigInteger b) {
        int sum = 0;
        String s = b.toString();
        for (int i = 0; i < s.length(); i++) {
            sum += Character.getNumericValue(s.charAt(i));
        }
        return sum;
    }

    /**
     * Allows for easy viewing of the integers in an array by printing each of its elements to standard output.
     * @param arr the array we want to view.
     */
    static void showVect(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i == arr.length-1)
                System.out.println();
        }
    }

    /**
     * Checks an integer for primality by performing a wheel factorization of circumference 6.
     * @param n the integer to check for primality.
     * @return true if n is a prime number, false if not.
     */
    static boolean isPrime (int n) {
        if (n < 2) {
            return false;
        } else if (n < 4) {
            return true;
        } else if (n%2 == 0 || n%3 == 0) {
            return false;
        } else {
            int limit = sqrt(n);
            for (int i = 6; i-1 <= limit; i+=6) {
                if (n%(i+1) == 0 || n%(i-1) == 0) {
                    return false;
                }
            }
            return true;
        }
    }


    /**
     * Checks a string for palindromicity.
     * @param s the string to check.
     * @return true if s is a palindrome, false if not.
     */
    static boolean isPalindrome(String s) {
        StringBuffer reverse = new StringBuffer();
        for (int i = s.length()-1; i >-1; i--) {
            reverse.append(s.charAt(i));
        }
        return reverse.toString().equals(s);
    }

    /**
     * Calculates Euler's totient function, also called the phi function, for all integers up to length and stores
     * these values in an array.
     * @param length the index of the last number for which the totient function is calculated.
     * @return an array of ints with each input being the totient function of its index.
     */
    static int[] phi(int length) {
        int[] phi = new int[length+1];
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
     * @param n the integer of which we are trying to find the number of divisors.
     * @return the number of divisors this number n has.
     */
    static int numDiv (int n) {
        int divs = 0;
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n%i == 0 && i*i != n) {
                divs += 2;
            } else if (n%i == 0) {
                divs++;
            }
        }
        return divs;
    }

    /**
     * @param n the integer we want to sum the divisors of.
     * @return the sum of the divisors of n.
     */
    static int divisorSum (int n) {
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

    /**
     * Computes the sum of the letter values of s.
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
     * @param n the integer to truncate.
     * @return the truncated integer.
     */
    static int truncateRight(int n) {
        String s = Integer.toString(n);
        String str = s.substring(0, s.length()-1);
        return Integer.parseInt(str);
    }


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

        @Override public boolean hasNext() {
            return true;
        }
        @Override public Long next() {
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
                         p = this.bps.next(), this.bpa.add((int)p), sqr = p * p) ;
                    for (int i = 0; i < this.bpa.size() - 1; i++) {
                        long p = this.bpa.get(i);
                        long s = (p * p - 3) >>> 1;
                        if (s >= this.lowi) // Adjust start index based on page lower limit...
                            s -= this.lowi;
                        else {
                            long r = (this.lowi - s) % p;
                            s = (r != 0) ? p - r : 0;
                        }
                        for (int j = (int)s; j < BFBTS; j += p)
                            this.buf[j >>> 5] |= 1 << (j & 31);
                    }
                }
            }
            while ((this.bi < BFBTS) &&
                    ((this.buf[(int)this.bi >>> 5] & (1 << ((int)this.bi & 31))) != 0))
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
     * @param length the number up to which the array goes.
     * @return a boolean array specifying if the index of each element is prime.
     */
    static boolean[] primeTab(int length) {
        boolean[] isPrime = new boolean[length+1];
        if (length < 40000000) {
            if (length >= 2) {
                isPrime[2] = true;
            }
            for (int i = 3; i < isPrime.length; i+=2) {
                isPrime[i] = true; // Assume all odd numbers are primes.
            }
            int limit = Library.sqrt(length);
            int limit1;
            for (int i = 3; i <= limit; i+=2) {
                if (isPrime[i]) {
                    limit1 = length/i;
                    for (int j = i; j <= limit1; j+=2) {
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
     * @param n the integer to verify for palindromicity.
     * @return true if n is a palindrome, false if not.
     */
    static boolean isPalindrome (int n) {
        String s = n + "";
        String rev = "";
        for (int i = s.length()-1; i >= 0; i--) {
            rev += s.charAt(i);
        }
        return rev.equals(s);
    }
}
