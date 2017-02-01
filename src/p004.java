/**
 * https://projecteuler.net/problem=4
 *
 * Validated.
 */

import java.util.ArrayList;

public class p004 {

    public static void main(String[] args) {
        long s = System.nanoTime();
        ArrayList<Integer> prods = new ArrayList<>();
        for (int i = 1; i < 1000; i++) {
            for (int j = i; j < 1000; j++) {
                prods.add(i*j);
            }
        }
        int max = 0;
        for (int i = prods.size()-1; i >= 0; i--) {
            if (Library.isPalindrome(prods.get(i)) && prods.get(i) > max) {
                max = prods.get(i);
            }
        }
        System.out.println(max);
        long e = System.nanoTime();
        System.out.println((e-s)/1000000000.0);
    }
}
