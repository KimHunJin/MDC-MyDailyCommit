package algorithm.forbidden;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by HunJin on 2016-12-09.
 */
public class SmallX {
    public static void main(String[] args) throws IOException {
        new SmallX().solve();
    }

    void solve() throws IOException {
        int loops = iRead();
        int x = iRead();

        for(int i=0;i<loops;i++) {
            int small = iRead();
            if(x > small) {
                System.out.print(small + " ");
            }
        }
    }

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String readWord() throws IOException {
        StringBuilder b = new StringBuilder();
        int c;
        c = br.read();
        while (c >= 0 && c <= ' ')
            c = br.read();
        if (c < 0)
            return "";
        while (c > ' ') {
            b.append((char) c);
            c = br.read();
        }
        return b.toString();
    }

    int iRead() throws IOException {
        return Integer.parseInt(readWord());
    }
}
