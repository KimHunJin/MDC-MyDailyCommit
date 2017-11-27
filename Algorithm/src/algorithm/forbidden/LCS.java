package algorithm.forbidden;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by HunJin on 2016-10-07.
 */
public class LCS {
    static int[][] lcs;
    static int[] a;
    static String A, B;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        A = in.readLine();
        B = in.readLine();

        lcs = new int[A.length()][B.length()];

        a = new int[A.length()];

        for (int i = 0; i < A.length(); i++) {
            make(i);
        }

        for (int i = 0; i < lcs.length; i++) {
            for (int j = 0; j < lcs[i].length; j++) {
                System.out.print(lcs[i][j]);
            }
            System.out.println();
        }
    }

    static void make(int num) {

        for (int i = num; i < B.length(); i++) {
            if (A.charAt(num) == B.charAt(i)) {
                char f = B.charAt(i);
                for (int j = i; j < lcs[i].length; j++) {
                    a[j]++;
                }
            }
        }

        for (int i = 0; i < a.length; i++) {
            lcs[num][i] = a[i];
        }
    }
}
