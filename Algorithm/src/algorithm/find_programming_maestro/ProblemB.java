package algorithm.find_programming_maestro;

import java.util.LinkedList;
import java.util.Queue;

public class ProblemB {
    public static void main(String[] args) {
        new ProblemB().solve();
    }

    void solve() {
        int map[][] = {
                {1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 0, 1},
                {0, 0, 0, 0, 1}
        };

        int map2[][] = {
                {1,0,1,1,1},
                {1,0,1,0,1},
                {1,0,1,1,1},
                {1,1,1,0,0},
                {0,0,0,0,1}
        };

        System.out.println(solution(map));
    }

    public int solution(int[][] maps) {
        int answer = 0;
        int mapSizeX = maps.length;
        int mapSizeY = maps[0].length;
        int size;
        int tmp;

        boolean isFind = false;
        int[] width = {0, 0, 1, -1};
        int[] height = {1, -1, 0, 0};

        int r;
        int h;

        boolean[][] check = new boolean[maps.length][maps[0].length];

        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[i].length; j++) {
                check[i][j] = false;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);

        while (!isFind) {
            size = queue.size();
            for (int i = 0; i < size; i++) {
                tmp = queue.poll();
                r = tmp / 100;
                h = tmp % 100;

                if (r == maps.length - 1 && h == maps[0].length - 1) {
                    answer++;
                    isFind = true;
                }

                for (int j = 0; j < 4; j++) {
                    int rr = r + width[j];
                    int hh = h + height[j];

                    if (rr >= mapSizeX || rr < 0 || hh >= mapSizeY || hh < 0) {
                        continue;
                    }

                    if (maps[rr][hh] == 0) {
                        continue;
                    }

                    if (check[rr][hh]) {
                        continue;
                    }

                    check[rr][hh] = true;
                    queue.offer(rr * 100 + hh);

                }
            }
            if (!isFind) {
                answer++;
            }

            if(answer > mapSizeX * mapSizeY) {
                answer = -1;
                isFind = true;
            }
        }

        return answer;
    }

}
