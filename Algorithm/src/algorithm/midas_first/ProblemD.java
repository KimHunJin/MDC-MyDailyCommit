package algorithm.midas_first;

import java.util.Arrays;
import java.util.Scanner;

public class ProblemD {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int loop = Integer.parseInt(sc.nextLine(), 10);
        int[] list = new int[loop];
        int min = 100000;
        for (int i = 0; i < loop; i++) {
            list[i] = Integer.parseInt(sc.nextLine(), 10);
            if (i > 0) {
                int value = list[i] - list[i - 1];
                if (min > value) {
                    min = value;
                }
            }
        }
        Arrays.sort(list);
        int result = 0;
        for (int i = loop - 1; i > 0; i--) {
            result += ((list[i] - list[i - 1]) / min) - 1;
        }

        System.out.println(result);
    }
}
