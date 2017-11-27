package algorithm.forbidden;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by HunJin on 2016-12-19.
 */
public class ReverseWord {
    public static void main(String[] args) {
        new ReverseWord().solve();
    }

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    void solve() {
        try {
            int loops = Integer.parseInt(br.readLine(), 10);
            while (loops-- > 0) {
                String result = "";
                StringTokenizer st = new StringTokenizer(br.readLine()," ");
                if(st.hasMoreTokens()) {
                    result += st.nextToken();
                }
                while (st.hasMoreTokens()) {
                    result = st.nextToken() + " " + result;
                }
                System.out.println(result);
            }
        } catch (IOException ie) {
            ie.printStackTrace();
        }
    }

    String readWrod() throws IOException {
        StringBuilder sb = new StringBuilder();
        int c = br.read();
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
        return sb.toString();
    }
}
