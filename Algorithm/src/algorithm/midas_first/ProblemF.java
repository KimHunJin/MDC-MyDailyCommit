package algorithm.midas_first;

import java.util.Scanner;

public class ProblemF {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine(), 10);
        String[] s = sc.nextLine().split(" ");

        int[] value = new int[n + 1];
        int[] result = new int[n + 1];
        for (int i = 1; i < value.length; i++) {
            value[i] = Integer.parseInt(s[i-1]);
            for (int j = i; j < result.length; j++) {
                int state = value[i] + result[j - i];
                if (result[j] > state) {
                    result[j] = result[j];
                } else {
                    result[j] = state;
                }
            }
        }
        System.out.println(result[n]);
    }
}
