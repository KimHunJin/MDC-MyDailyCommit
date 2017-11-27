package algorithm.midas_second;

import java.util.Scanner;

public class ProblemA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int k = Integer.parseInt(s[2]);

        int result = 0;

        int nCount = n / 2;
        int nMod = n % 2;
        int mCount = 0;

        if (nCount >= m) {
            result = m;
            nCount = nCount - m;
            nCount = 2 * nCount;
            nCount = nCount + nMod;
            mCount = 0;
        } else {
            result = nCount;
            mCount = m - nCount;
            nCount = nMod;
        }

        if (k > 0) {
            if (k > nCount + mCount) {
                k = k - (nCount + mCount);
                result = result - k / 3;
                if (k % 3 > 0) {
                    result--;
                }
            }
        }
        System.out.println(result);
    }
}
