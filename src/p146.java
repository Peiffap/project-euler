/**
 * https://projecteuler.net/problem=146
 *
 * Validated.
 */

import java.math.BigInteger;

class p146 {

    /**
     * Generates primes to check for 'consecutive primality' and returns whether the generated numbers were consecutive
     * primes.
     * @param n the integer whose square is used to generate consecutive primes.
     * @return true if n*n allows for generation of consecutive primes, false if not.
     */
    private static boolean primeGen (int n) {
        BigInteger b = new BigInteger(Integer.toString(n));
        b = b.pow(2);
        return consec(b);
    }
    public static void main(String[] args) {
        long s = System.nanoTime();
        int sum = 0;
        // if n%2 = 1, n^2 + 1 = 2k; not prime
        // if n%5 = [1, 2, 3, 4], n^2 + [9, 3, 7, 1] = 5k; not prime
        // hence n has to be a multiple of 10
        // similarly, we need n%3 = [2, 3] and n%7 = [3, 4]
        // combining all of this, we see that we need n%210 = [10, 80, 130, 200]
        for (int i = 0; i < 150000000; i += 210) {
            if (primeGen(i + 10)) {
                sum += i + 10;
            }
            if (primeGen(i + 80)) {
                sum += i + 80;
            }
            if (primeGen(i + 130)) {
                sum += i + 130;
            }
            if (primeGen(i + 200)) {
                sum += i + 200;
            }
        }
        System.out.println(sum);
        long e = System.nanoTime();
        System.out.println((e-s)/1000000000.0);
    }

    /**
     * For a given BigInteger b, checks if b+1, b+3, b+7, b+9, b+13 and b+27 are all consecutive primes.
     * @param b the BigInteger to check for 'consecutive primality'.
     * @return true if b+1, b+3, b+7, b+9, b+13 and b+27 are all consecutive primes, false if not.
     */
    public static boolean consec (BigInteger b) {
        BigInteger a = b.nextProbablePrime(); // 1
        if (!a.equals(b.add(BigInteger.ONE)))
            return false;
        BigInteger c = a.nextProbablePrime(); // 3
        if (!c.equals(b.add(new BigInteger("3"))))
            return false;
        BigInteger d = c.nextProbablePrime(); // 7
        if (!d.equals(b.add(new BigInteger("7"))))
            return false;
        BigInteger e = d.nextProbablePrime(); // 9
        if (!e.equals(b.add(new BigInteger("9"))))
            return false;
        BigInteger f = e.nextProbablePrime(); // 13
        if (!f.equals(b.add(new BigInteger("13"))))
            return false;
        BigInteger g = f.nextProbablePrime(); // 27
        if (!g.equals(b.add(new BigInteger("27"))))
            return false;
        return true;
    }
}
