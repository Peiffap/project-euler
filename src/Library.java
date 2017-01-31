import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Library with some useful subroutines for project Euler solving.
 */

public class Library {

    /**
     * Returns a boolean array stating with each element stating whether its index is a prime number.
     * @param length the number up to which the array goes.
     * @return a boolean array specifying if the index is prime.
     */
    public static boolean[] primeTab(int length) {
        boolean[] isPrime = new boolean[length+1];
        for (int i = 2; i < isPrime.length; i++) {
            isPrime[i] = true; // Assume all primes.
        }
        for (int i = 2; i*i <= length; i++) {
            if (isPrime[i]) {
                for (int j = i; j <= length/i; j++) {
                    isPrime[j*i] = false; // "Cross" out any multiples of previously found primes.
                }
            }
        }
        return isPrime;
    }

    /**
     * Returns the factorial of an integer.
     * @param n the integer you want to calculate the factorial of.
     * @return a BigInteger whose value is n!.
     */
    public static BigInteger fact(int n) {
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
    public static int digitSum (BigInteger b) {
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
    public static void showVect(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i == arr.length-1)
                System.out.println();
        }
    }

    /**
     * Checks an integer for primality.
     * @param n the integer to check for primality.
     * @return true if n is a prime number, false if not.
     */
    public static boolean isPrime (int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n%i == 0)
                return false;
        }
        return true;
    }

    /**
     * Checks a string for palindromicity.
     * @param s the string to check.
     * @return true if s is a palindrome, false if not.
     */
    public static boolean isPalindrome(String s) {
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
    public static int[] phi(int length) {
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
    public static int digitSum(BigDecimal b) {
        String s = b.toPlainString();
        int sum = Character.getNumericValue(s.charAt(0));
        for (int i = 2; i < 101; i++) {
            sum += Character.getNumericValue(s.charAt(i));
        }
        return sum;
    }

    /**
     * Computes the number of divisors of a given integer.
     * @param n the integer of which we are trying to find the number of divisors.
     * @return the number of divisors this number n has.
     */
    public static int numDiv (int n) {
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
    public static int divisorSum (int n) {
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
    public static int wordValue(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum += s.charAt(i) - 'A' + 1;
        }
        return sum;
    }
}
