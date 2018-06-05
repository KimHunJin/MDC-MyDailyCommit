package algorithm.algorithm10000lab;

import java.util.Scanner;

public class ContinuousSum {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] values = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = sc.nextInt();
        }

        int sum[] = new int[n];
        for (int i = 0; i < n; i++) {
            sum[i] = values[i];

            if (i > 0) {
                if (sum[i] < sum[i - 1] + values[i]) {
                    sum[i] = sum[i - 1] + values[i];
                }
            }
        }

        int max = sum[0];
        for (int i = 1; i < n; i++) {
            if (max < sum[i]) {
                max = sum[i];
            }
        }
        System.out.println(max);
    }
}
