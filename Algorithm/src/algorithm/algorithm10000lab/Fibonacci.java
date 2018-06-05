package algorithm.algorithm10000lab;

import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] zero = new int[41];
        int[] one = new int[41];

        zero[0] = 1;
        zero[1] = 0;
        one[0] = 0;
        one[1] = 1;
        int[] input = new int[n];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int k = sc.nextInt();
            input[i] = k;
            if (max < k) {
                max = k;
            }
        }

        for (int i = 2; i <= max; i++) {
            zero[i] = zero[i - 1] + zero[i - 2];
            one[i] = one[i - 1] + one[i - 2];
        }

        for (int i = 0; i < n; i++) {
            int k = input[i];
            System.out.println(zero[k] + " " + one[k]);
        }
    }
}
