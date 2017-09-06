package algorithm.algorithm10000lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by HunJin on 2017-07-22.
 */
public class NumberOfStairs {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());
        long[] count = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        for (int j = 1; j < number; j++) {
            long c[] = new long[10];
            for (int i = 0; i < count.length; i++) {
                if (i == 0) {
                    c[i] = count[i + 1];
                } else if (i == 9) {
                    c[i] = count[i - 1];
                } else {
                    c[i] = count[i - 1] + count[i + 1];
                }
            }
            for (int i = 0; i < c.length; i++) {
                count[i] = c[i] % 1000000000;
            }
        }

        long sum = 0;
        for (int i = 1; i < count.length; i++) {
            sum += count[i];
        }
        System.out.println(sum % 1000000000);
    }
}
