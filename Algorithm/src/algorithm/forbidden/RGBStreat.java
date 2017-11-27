package algorithm.forbidden;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by HunJin on 2017-03-07.
 */
public class RGBStreat {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        new RGBStreat().solve();
    }

    void solve() {
        try {
            int loop = Integer.parseInt(br.readLine(), 10);
            int[][] values = new int[loop][3];
            for (int i = 0; i < loop; i++) {
                String[] dump = br.readLine().split(" ");
                for (int j = 0; j < dump.length; j++) {
                    values[i][j] = Integer.parseInt(dump[j]);
                }
            }

            for (int[] value : values) {
                for (int i : value) {
                    System.out.print(i + " ");
                }
                System.out.println();
            }
        } catch (IOException ie) {
            ie.printStackTrace();
        }
    }

    String readWord() throws IOException {
        StringBuilder sb = new StringBuilder();
        int c;
        c = br.read();
        while (c >= 0 && c <= ' ') {
            c = br.read();
        }
        if (c < 0) {
            return "";
        }
        while (c > ' ') {
            sb.append((char) c);
            c = br.read();
        }
        return br.toString();
    }

    int iRead() throws IOException {
        return Integer.parseInt(readWord());
    }
}
