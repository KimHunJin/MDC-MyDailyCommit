package algorithm.midas_second;

import java.util.Scanner;

public class ProblemD {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");

        String x = s[0];
        String y = s[1];

        if (x.length() > y.length()) {
            solution(x, y);
        } else if (x.length() < y.length()) {
            solution(y, x);
        } else {
            solution(x, y);
        }
    }

    //  a.length > b.length
    public static void solution(String a, String b) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= a.length() - b.length(); i++) {
            int count = 0;
            for (int j = 0; j < b.length(); j++) {
                if (a.charAt(i + j) != b.charAt(j)) {
                    count++;
                }
            }
            if (min > count) {
                min = count;
            }
        }
        System.out.println(min);
    }
}
