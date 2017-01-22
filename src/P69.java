/**
 * Created by admin on 27/12/16.
 * Validated.
 */
public class P69 {
    public static void main (String[] args) {
        long s = System.nanoTime();
        double maxTot = 0;
        int[] phi = phi(1000000);
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
}
