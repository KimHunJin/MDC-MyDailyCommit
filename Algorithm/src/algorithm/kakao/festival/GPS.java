package algorithm.kakao.festival;

public class GPS {
    public static void main(String[] args) {
        int n = 7;
        int m = 10;
        int[][] edge_list = {
                {1, 2},
                {1, 3},
                {2, 3},
                {2, 4},
                {3, 4},
                {3, 5},
                {4, 6},
                {5, 6},
                {5, 7},
                {6, 7}
        };
        int k = 2;
//        int[] gps_log = {1, 2, 1, 1, 1, 1, 7};
//        int[] gps_log = {1, 2, 3, 3, 6, 7};
        int[] gps_log = {1, 7};


//        solution(n, m, edge_list, k, gps_log);
        System.out.println(solution(n, m, edge_list, k, gps_log));
    }


    /**
     * @param n         : 거점 개수
     * @param m         : 도로 개수
     * @param edge_list : 도로 정보
     * @param k         : 거점 총 개수
     * @param gps_log   : 거점 정보
     * @return
     */
    public static int solution(int n, int m, int[][] edge_list, int k, int[] gps_log) {
        int answer = 0;

        int[][] tile = new int[n + 1][n + 1];

        for (int i = 0; i < edge_list.length; i++) {
            int start = edge_list[i][0];
            int destination = edge_list[i][1];

            tile[start][destination] = 1;
            tile[destination][start] = 1;
        }
        for (int i = 1; i < tile.length; i++) {
            tile[i][i] = 1;
        }

        for (int a[] : tile) {
            for (int b : a) {
                System.out.print(b + " ");
            }
            System.out.println();
        }

        System.out.println();

        for (int a : gps_log) {
            System.out.print(a + " ");
        }

        System.out.println();

        answer = check(tile, gps_log, k);


        return answer;
    }


    static int check(int[][] tile, int[] gps_log, int k) {
        int[][] value = new int[k + 1][tile.length];
        for (int i = 1; i < value[1].length; i++) {
            if (i == gps_log[0]) {
                value[1][i] = 0;
            } else {
                value[1][i] = -1;
            }
        }

        for (int i = 2; i < value.length; i++) {
            for (int j = 1; j < value[i].length; j++) {
                int min = Integer.MAX_VALUE;
                for (int m = 1; m < tile[j].length; m++) {
                    if (tile[j][m] == 1) {
                        if (value[i - 1][m] == -1) {
                            continue;
                        } else {
                            min = Math.min(min, value[i - 1][m]);
                        }
                    }
                }
                if (gps_log[i - 1] == j) {
                    if (min == Integer.MAX_VALUE) {
                        min = -1;
                    }
                    value[i][j] = min;
                } else if (min == Integer.MAX_VALUE) {
                    value[i][j] = -1;
                } else {
                    value[i][j] = min + 1;
                }
            }
        }

        System.out.println();

        for (int a[] : value) {
            print(a);
            System.out.println();

        }
        System.out.println();

        return value[value.length - 1][gps_log[gps_log.length - 1]];
    }

    static void print(int[] gps_log) {
        for (int i : gps_log) {
            System.out.print(i + " ");
        }
    }
}
