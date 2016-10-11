package notes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by HunJin on 2016-10-11.
 * <p>
 * read console's input for int, long, double
 */
public class ReadWord {

    public int iRead() throws IOException {
        return Integer.parseInt(readWord());
    }

    public long lRead() throws IOException {
        return Long.parseLong(readWord());
    }

    public double dRead() throws IOException {
        return Double.parseDouble(readWord());
    }

    BufferedReader br;

    public String readWord() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
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
