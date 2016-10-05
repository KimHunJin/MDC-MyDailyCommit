package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by HunJin on 2016-09-26.
 *
 * algorithm.Fibonacci
 * 1 1 2 3 5 8 13 21 34 55
 */
public class Fibonacci {
    public static void main(String[] args) throws IOException{
        new Fibonacci().solve();
    }

    void solve() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        for(int i=1;i<=a;i++) {
            System.out.print(fibonacci(i) + " ");
        }
    }

    /**
     * using recursion
     * @param number
     * @return fibonacci(n-1) + fibonacci(n-2)
     */
    int fibonacci(int number) {
        if(number == 1) {
            return 1;
        } else if (number == 2) {
            return 1;
        } else {
            return fibonacci(number-1) + fibonacci(number-2);
        }
    }

}
