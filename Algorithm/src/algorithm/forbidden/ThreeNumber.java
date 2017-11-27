package algorithm.forbidden;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by HunJin on 2016-12-09.
 */
public class ThreeNumber {
    public static void main(String[] args) {
        new ThreeNumber().solve();
    }

    void solve() {
        int[] values = input();
        Arrays.sort(values);
        System.out.println(values[1]);
    }

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int[] input() {

        int[] result = new int[3];
        try {
            String[] dump = br.readLine().split(" ");
            for(int i=0;i<result.length;i++) {
                result[i] = Integer.parseInt(dump[i]);
            }
        } catch (IOException ie) {
            ie.printStackTrace();
        }
        return result;
    }
}
