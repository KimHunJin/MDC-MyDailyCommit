package algorithm.hackerrank;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by HunJin on 2017-09-06.
 */
public class CoinChange {

    static long getWays(long n, long[] c){
        // Complete this function

        long[] s = new long[(int) n+1];

        s[0] = 1;
        for(int i=0;i<c.length;i++) {
            for(int j=0;j<=n;j++) {
                if(j-c[i] >= 0) {
                    s[j] += s[(int) (j-c[i])];
                }
            }
        }

        System.out.println();

        return s[(int) n];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        long[] c = new long[m];
        for(int c_i=0; c_i < m; c_i++){
            c[c_i] = in.nextLong();
        }
        // Print the number of ways of making change for 'n' units using coins having the values given by 'c'
        long ways = getWays(n, c);
        System.out.println(ways);
    }
}
