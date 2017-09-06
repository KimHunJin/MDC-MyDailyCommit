package algorithm.algorithm10000lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by HunJin on 2017-06-03.
 */
public class RandomNumberGenerator {
    public static void main(String[] args) {
        new RandomNumberGenerator().init();
    }

    BufferedReader br;

    long m, a, c, x, n, g;

    void init() {
        br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String[] dump = br.readLine().split(" ");
            m = lRead(dump[0]);
            a = lRead(dump[1]);
            c = lRead(dump[2]);
            x = lRead(dump[3]);
            n = lRead(dump[4]);
            g = lRead(dump[5]);
        } catch (IOException ie) {
            ie.printStackTrace();
        }


//        solve();
        solution2();
//        solution3();
    }

    void solve() {

        if (n > 0) {
            long t = ((long) (Math.pow(a, n) * x) + (long) (Math.pow(a, n - 1) * c));
            t = t % ((long) (Math.pow(a, n - 1) * m));
            for (long i = n - 2; i >= 0; i--) {
                t = t + (long) (Math.pow(a, i) * c);
                t = t % (long) (Math.pow(a, i) * m);
            }
            System.out.println("solve : " + (t % g));
        } else {
            System.out.println("solve : " + (x % g));
        }

    }

    long lRead(String str) {
        return Long.parseLong(str);
    }

    void solution2() {

        for (int i = 1; i <= n; i++) {
            long k = x;
            for (int j = 0; j < i; j++) {
                k = (a * k + c) % m;
            }
            System.out.print(k + " ");
        }


//        System.out.println("solution : " + (x % g));

    }

    void solution3() {
        List<Long> arr = new ArrayList<>();
        x = (a * x + c) % m;
        arr.add(x);
        for (int i = 1; i < n; i++) {
            x = (a * x + c) % m;
            if (x == arr.get(0)) {
                break;
            } else {
                arr.add(x);
            }
        }

        n = n % arr.size();
        if (n == 0) {
            x = arr.get(arr.size() - 1);
        } else {

        }

        System.out.println(x % g);
    }
}
