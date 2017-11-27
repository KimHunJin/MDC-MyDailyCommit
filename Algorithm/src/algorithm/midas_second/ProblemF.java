package algorithm.midas_second;

import java.util.ArrayList;
import java.util.Scanner;

public class ProblemF {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().trim().split(" ");

        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

        int[][] map = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] k = sc.nextLine().trim().split(" ");
            int loop = Integer.parseInt(k[0]);
            for (int j = 1; j <= loop; j++) {
                int room = Integer.parseInt(k[j]);
                map[i][room - 1] = 1;
            }
        }

        ArrayList<Integer> check = new ArrayList<>();

        int max = 0;


        for (int j = 0; j < map[0].length; j++) {
            int value = 0;
            if (map[0][j] == 1) {
                check = new ArrayList<>();
                check.add(j);
                value = re(map, check, 1);
            } else {
                check = new ArrayList<>();
                value = re(map, check, 1);
            }

            if (value > max) {
                max = value;
            }
        }

        System.out.println(max);

    }

    static int re(int[][] map, ArrayList<Integer> check, int x) {
        if (x > map.length - 1) {
            return check.size();
        } else {
            for (int i = 0; i < map[x].length; i++) {
                if (map[x][i] == 1 && !check.contains(i)) {
                    int test = i;
                    check.add(i);
                    return re(map, check, x + 1);
                }
            }
            return re(map, check, x + 1);
        }
    }
}
