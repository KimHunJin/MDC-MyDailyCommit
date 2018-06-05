package algorithm.hackerrank;

import java.util.Scanner;

public class XorAndSum {

    private static final long MODULO = (int) (Math.pow(10, 9) + 7);

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        Scanner sc = new Scanner(System.in);
        String s_a = sc.nextLine();
        String s_b = sc.nextLine();

        long a = Long.valueOf(s_a, 2) % MODULO;
        long b = Long.valueOf(s_b, 2) % MODULO;

        long result = 0;
        long lastN = 0;
        for (int i = 0; i <= 314159; i++) {
            result = (result % MODULO) + ((a ^ b) % MODULO);
            result = result % MODULO;
            b = (b << 1) % MODULO;
        }

        System.out.println(result % MODULO);
    }
}
