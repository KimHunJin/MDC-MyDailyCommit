package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by HunJin on 2016-12-09.
 */
public class PrimeNumber {
    public static void main(String[] args) {
        new PrimeNumber().solve();
    }

    void solve() {
        int start = startNumber();
        int last = lastNumber();

        print(start, last);


    }

    void print(int start, int last) {

        for (int i = start; i <= last; i++) {
            if(i == 1) {
                continue;
            }
            boolean isPrime = true;
            for (int j = 2; j * j <= i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime == true) {
                System.out.println(i);
            }
        }
    }

    int startNumber() {
        return iRead();
    }

    int lastNumber() {
        return iRead();
    }

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder b;

    String readWord() {

        b = new StringBuilder();
        try {
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
        } catch (IOException ie) {
            ie.printStackTrace();
        }
        return b.toString();
    }

    int iRead() {
        return Integer.parseInt(readWord());
    }
}
