package algorithm.algorithm10000lab;

import java.util.Scanner;

public class MinimumDifference {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();

        int sum = 0;

        int[] original = new int[n];
        int[] after = new int[n];
        for (int i = 0; i < n; i++) {
            int number = sc.nextInt();
            original[i] = number;
            sum += number;
        }

        int min = (sum - t) / n;
        int addOne = (sum - t) - (min * n);

        int maxDif = 0;
        for (int i = 0; i < n; i++) {
            if (original[i] < min) {
                after[i] = original[i];
                addOne += (min - original[i]);
                if (i > 0) {
                    int df = Math.abs(after[i] - after[i - 1]);
                    if (maxDif < df) {
                        maxDif = df;
                    }
                }
                if (i < n - 1) {
                    int df = Math.abs(after[i] - after[i + 1]);
                    if (maxDif < df) {
                        maxDif = df;
                    }
                }
            } else {
                after[i] = min;
            }
        }

        while (addOne > 0) {
            for (int i = 0; i < n; i++) {

            }
        }
        print(after);
        System.out.println(addOne);
    }


    static void print(int[] arr) {
        for (int n : arr) {
            System.out.print(n + " ");
        }
        System.out.println();
    }
}
