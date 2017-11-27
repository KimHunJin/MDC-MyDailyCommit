package algorithm.forbidden;

import java.util.Scanner;

/**
 * Created by HunJin on 2017-01-08.
 */
public class LIS {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        while (number-- > 0) {
            int n = sc.nextInt();
            int[] sequences = new int[n];
            for (int i = 0; i < n; i++) {
                sequences[i] = sc.nextInt();
            }
            int[] length = new int[n];
            for (int i = 0; i < n; i++) {
                length[i] = 1;
                for (int j = 0; j < i; j++) {
                    if (sequences[j] < sequences[i] && length[i] < length[j] + 1) {
                        length[i] = length[j] + 1;
                    }
                }
            }
            int ans = length[0];
            for (int i = 0; i < n; i++) {
                if (ans < length[i]) {
                    ans = length[i];
                }
            }
            System.out.println(ans);
        }
    }
}
