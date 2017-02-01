/**
 * https://projecteuler.net/problem=39
 *
 * Validated.
 */
class p039 {
    /**
     * Finds the number of right triangles with a perimeter of p and integral length sides. This is equivalent to
     * computing the number of solutions to the equation a^2 + b^2 = c^2, with a+b+c = p.
     * @param p the perimeter of a right triangle.
     * @return the number of right triangles with a perimeter of p and integral length sides.
     */
    private static byte sumOf2SquaresSolutions(short p) {
        byte count = 0;
        for (short a = 1; a < p-2; a++) {
            for (short b = a; b+a < p-1; b++) {
                if ((p-a-b)*(p-a-b) == a*a + b*b) {
                    count++;
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        long s = System.nanoTime();
        byte maxSols = 3;
        short bestP = 120;
        for (short p = 3; p <= 1000; p++) {
            byte sols = sumOf2SquaresSolutions(p);
            if (sols > maxSols) {
                maxSols = sols;
                bestP = p;
            }
        }
        System.out.println(bestP);
        System.out.println((System.nanoTime()-s)/1000000000.0);
    }
}
