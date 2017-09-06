package algorithm.hackerrank;

import java.util.Scanner;

public class Equal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int loop = 0; loop < T; loop++) {
            int n = sc.nextInt();
            int[] v = new int[n];
            int max = 0;
            int maxN = 0;
            for (int i = 0; i < n; i++) {
                int k = sc.nextInt();
                v[i] = k;
                if (max < k) {
                    max = k;
                    maxN = i;
                }
            }

            int count = 0;
            while (true) {
                count++;
                int checkCount = 0;
                for (int i = 0; i < n; i++) {

                    if (i != maxN) {
                        v[i]++;
                    }
                    if (max == v[i]) {
                        checkCount++;
                    }
                }

                if (checkCount == n) {
                    break;
                }

                for (int i = 0; i < n; i++) {
                    if (max < v[i]) {
                        max = v[i];
                        maxN = i;
                    }
                }
            }

            System.out.println("count : " + count);

            int loopN = 0;
            while (count > 0) {
                loopN++;
                if (count - 5 >= 0) {
                    count -= 5;
                } else if (count - 2 >= 0) {
                    count -= 2;
                } else if (count - 1 >= 0) {
                    count--;
                }
            }

            System.out.println("result : " + loopN);

            for (int i : v) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
