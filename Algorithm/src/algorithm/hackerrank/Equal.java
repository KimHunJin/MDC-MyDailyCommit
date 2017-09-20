package algorithm.hackerrank;

import java.util.Arrays;
import java.util.Scanner;

public class Equal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine(), 10);
        for (int loop = 0; loop < T; loop++) {
            int n = Integer.parseInt(sc.nextLine(), 10);
            int[] v = new int[n];
            String[] s = sc.nextLine().split(" ");

            for (int i = 0; i < n; i++) {
                v[i] = Integer.parseInt(s[i]);
            }

            Arrays.sort(v);
            long sum = Long.MAX_VALUE;
            for (int base = 0; base < 3; base++) {
                long currentSum = 0;
                for (int i = 0; i < v.length; i++) {
                    int delta = v[i] - v[0] + base;
                    currentSum += (int) delta / 5 + delta % 5 / 2 + delta % 5 % 2 / 1;
                }
                sum = Math.min(sum, currentSum);
            }
            System.out.println(sum);
        }
    }
}
