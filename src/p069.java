/**
 * https://projecteuler.net/problem=69
 *
 * Validated.
 */
class p069 {
    public static void main (String[] args) {
        long s = System.nanoTime();
        double maxTot = 0;
        int[] phi = Library.phi(1000000);
        int maxphi = 0;
        for (int i = 2; i <= 1000000; i++) {
            double phidiv = (double)i/phi[i];
            if (phidiv > maxTot) {
                maxTot = phidiv;
                maxphi = i;
            }
        }
        System.out.println(maxphi);
        long e = System.nanoTime();
        System.out.println((e-s)/1000000000.0);
    }
}
