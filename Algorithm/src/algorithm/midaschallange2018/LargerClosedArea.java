package algorithm.midaschallange2018;

import java.util.Scanner;

public class LargerClosedArea {
    public static void main(String[] args) {
        new LargerClosedArea().solve();
    }

    private static final int SIZE = 101;

    private int[][] map = new int[SIZE][SIZE];
    private boolean[][] isVisit = new boolean[SIZE][SIZE];

    private int[] dx = {0, 0, 1, -1};
    private int[] dy = {1, -1, 0, 0};

    private void solve() {
        init();
        find();
        print();
        System.out.println(max);
    }

    private int max = Integer.MIN_VALUE;

    private void find() {
        for (int i = 0; i < 101; i++) {
            for (int j = 0; j < 101; j++) {
                if (map[i][j] == -1 && !isVisit[i][j]) {
                    int v = dfs(i, j);
                    max = max > v ? max : v;
                }
            }
        }
    }

    private int dfs(int x, int y) {
        int result;
        if (map[x][y] == -1 && !isVisit[x][y]) {
            isVisit[x][y] = true;
            result = 1;
            for (int i = 0; i < 4; i++) {
                result += dfs(x + dx[i], y + dy[i]);
            }
        } else {
            return 0;
        }
        return result;
    }

    private void print() {
        for (int a[] : map) {
            for (int b : a) {
                System.out.print(b + " ");
            }
            System.out.println();
        }
    }

    private void init() {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 1; i <= n; i++) {
            String[] s = sc.nextLine().split(",");
            int x1 = Integer.parseInt(s[0]);
            int y1 = Integer.parseInt(s[1]);
            int x2 = Integer.parseInt(s[2]);
            int y2 = Integer.parseInt(s[3]);

            for (int j = x1; j <= x2; j++) {
                map[j][y1] = i;
                map[j][y2] = i;
            }
            for (int j = y1; j <= y2; j++) {
                map[x1][j] = i;
                map[x2][j] = i;
            }
            for (int j = x1 + 1; j <= x2 - 1; j++) {
                for (int k = y1 + 1; k <= y2 - 1; k++) {
                    if (map[j][k] == 0) {
                        map[j][k] = -1;
                    }
                }
            }
        }
    }
}
