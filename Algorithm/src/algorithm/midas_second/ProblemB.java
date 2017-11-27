package algorithm.midas_second;

import java.util.Scanner;

public class ProblemB {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        int n = Integer.parseInt(s[0], 10);
        int m = Integer.parseInt(s[1], 10);

        int dif = 0;

        int f = Integer.parseInt(sc.nextLine(), 10);
        for (int i = 1; i < n; i++) {
            int g = Integer.parseInt(sc.nextLine(), 10);
            dif = g - f;
            f = g;
        }

        int div = (n - 1) / (m - 1);

        int result = div * dif;

        System.out.println(result);
    }
}
