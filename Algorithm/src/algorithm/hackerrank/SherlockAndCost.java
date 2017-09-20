package algorithm.hackerrank;

import java.util.Scanner;

public class SherlockAndCost {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int loop = 0; loop < T; loop++) {
            int n = sc.nextInt();
            int[] b = new int[n];
            for(int i=0;i<n;i++) {
                b[i] = sc.nextInt();
            }
            int hi = 0;
            int low = 0;
            for (int i = 1; i < n; i++) {
                int high_to_low_df = Math.abs(b[i - 1] - 1);
                int low_to_high_df = Math.abs(b[i] - 1);
                int high_to_high_df = Math.abs(b[i] - b[i - 1]);

                int low_next = Math.max(low, hi + high_to_low_df);
                int high_next = Math.max(hi + high_to_high_df, low + low_to_high_df);

                low = low_next;
                hi = high_next;
            }
            System.out.println(Math.max(hi, low));
        }
    }
}
