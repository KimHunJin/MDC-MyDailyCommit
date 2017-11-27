package algorithm.midas_second;

import java.util.Scanner;

public class ProblemC {

    public static boolean[][] isCheck = null;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine(), 10);

        String[][] dot = new String[n][n];

        isCheck = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            dot[i] = sc.nextLine().split(" ");
        }

        int result = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (dot[i][j].equals("1")) {
                    int value = check(i, j, dot);
                    if (value > 0) {
                        result++;
                    }
                }
            }
        }

        System.out.println(result);
    }


    static int check(int x, int y, String[][] dot) {

        if (x < 0 || x > dot.length - 1 || y < 0 || y > dot[0].length - 1 || dot[x][y].equals("0") || isCheck[x][y] == true) {
            return 0;
        } else {
            isCheck[x][y] = true;
            int a = check(x - 1, y, dot);
            int b = check(x + 1, y, dot);
            int c = check(x, y - 1, dot);
            int d = check(x, y + 1, dot);
            return a + b + c + d + 1;
        }
    }
}
