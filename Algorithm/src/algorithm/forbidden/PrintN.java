package algorithm.forbidden;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by HunJin on 2016-12-09.
 */
public class PrintN {
    public static void main(String[] args) throws IOException {
        new PrintN().solve();
    }

    void solve() throws IOException {
        int loops = iRead();
        for(int i=1;i<=loops;i++) {
            System.out.println(i);
        }
    }


    int iRead() throws IOException {
        return Integer.parseInt(readWord());
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
}
