package algorithm.woowahan3;

import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        new C().solve();
    }

    int[][] map = new int[10001][10001];
    int count = 0;

    private void solve() {
        try (Scanner s = new Scanner(System.in)) {
            int x1 = s.nextInt();
            int y1 = s.nextInt();
            int x2 = s.nextInt();
            int y2 = s.nextInt();
            int x3 = s.nextInt();
            int y3 = s.nextInt();
            int x4 = s.nextInt();
            int y4 = s.nextInt();
            int x5 = s.nextInt();
            int y5 = s.nextInt();
            int x6 = s.nextInt();
            int y6 = s.nextInt();

            makeMap(x1, y1, x2, y2);
            deleteMap(x3, y3, x4, y4);
            deleteMap(x5, y5, x6, y6);

            System.out.println(count);
        }
    }

    private void makeMap(int x1, int y1, int x2, int y2) {
        for (int i = x1; i < x2; i++) {
            for (int j = y1; j < y2; j++) {
                if (map[i][j] != 1) {
                    map[i][j] = 1;
                    count++;
                }
            }
        }
    }

    private void deleteMap(int x1, int y1, int x2, int y2) {
        for (int i = x1; i < x2; i++) {
            for (int j = y1; j < y2; j++) {
                if (map[i][j] == 1) {
                    map[i][j] = -1;
                    count--;
                }
            }
        }
    }

    private void test(Square a, Square b) {
        if (a.lb.x < b.lb.x) {

        }
    }

    class Square {

        Position lb;
        Position lt;
        Position rb;
        Position rt;

        Square(int x1, int y1, int x2, int y2) {
            this.lb = new Position(x1, y1);
            this.lt = new Position(x1, y2);
            this.rb = new Position(x2, y1);
            this.rt = new Position(x2, y2);
        }
    }

    class Position {
        int x;
        int y;

        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

    private void check() {

    }
}
