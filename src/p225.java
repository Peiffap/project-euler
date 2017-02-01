/**
 * https://projecteuler.net/problem=225
 *
 * Validated.
 */
class p225 {
    public static void main(String[] args) {
        long s = System.nanoTime();
        boolean[] tried = new boolean[2010];
        int n = 124;
        int count = 0;
        int i = 27;
        while (count < n) {
            long t1 = 1; // First term.
            long t2 = 1; // Second term.
            long t3 = 3; // Third term.
            long dummy; // Dummy variable used to store t1.
            /*
             * Either all three consecutive terms are 1, or i divides t3. If three consecutive terms are 1, that means
             * the Tribonacci sequence is going to loop through all previous values (mod i of course) over and over
             * again without ever reaching 0. That means not a single term in it will be evenly divisible by i.
             */
            while (t3 > 0 && t1*t2*t3 != 1 && !tried[i]) {
                dummy = t1;
                t1 = t2;
                t2 = t3;
                t3 = (t1 + t2 + dummy) % i;
            }
            if (t3 > 0) { // It broke out of the loop because 3 consecutive terms were 1, so we have a new non-divisor.
                count++;
                /*
                 * Say i doesn't divide a single term in Tribonacci. Then obviously, neither does j*i.
                 */
                for (int j = 3; j*i < tried.length; j+=2) {
                    tried[j*i] = true;
                }
            }
            i += 2;
        }
        System.out.println(i-2); //
        long e = System.nanoTime();
        System.out.println((e-s)/1000000000.0);
    }
}
