package algorithm.midas_first;

import java.util.Arrays;
import java.util.Scanner;

public class ProblemC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int loop = Integer.parseInt(sc.nextLine());
        int[] w = new int[loop];
        String[] s = sc.nextLine().split(" ");
        for (int i = 0; i < w.length; i++) {
            w[i] = Integer.parseInt(s[i]);
        }

        Arrays.sort(w);

        int count = -1;
        int result = 0;
        for (int i = 0; i < w.length; i++) {
            if (count < w[i]) {
                result++;
                count = w[i] + 4;
            }
        }
        System.out.println(result);

    }
}
