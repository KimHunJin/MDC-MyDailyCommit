package algorithm.midaschallange;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by HunJin on 2017-05-12.
 */
public class DiskSpace {
    public static void main(String[] args) throws IOException {
        new DiskSpace().solve();
    }

    BufferedReader br;

    void solve() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        int loop = Integer.parseInt(br.readLine());
        String[] dump = br.readLine().split(" ");
        int[] numbers = new int[loop];

        for(int i=0;i<numbers.length;i++) {
            numbers[i] = Integer.parseInt(dump[i]);
        }

        int clustSize = Integer.parseInt(br.readLine());

        int count = 0;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % clustSize > 0) {
                count += (numbers[i] / clustSize + 1);
            } else {
                count += numbers[i] / clustSize;
            }
        }

        System.out.println(clustSize * count);

    }


}
