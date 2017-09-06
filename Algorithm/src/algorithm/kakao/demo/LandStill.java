package algorithm.kakao.demo;

/**
 * Created by HunJin on 2017-08-31.
 */
public class LandStill {
    public static void main(String[] args) {
        int[][] land = new int[][]{{1, 2, 3, 5}, {5, 6, 7, 8}, {4, 3, 2, 1}};
        int[][] land2 = new int[][]{
                {2, 4, 6, 8},
                {9, 6, 7, 1},
                {10, 2, 7, 9},
                {13, 6, 2, 10}};

        System.out.println(new LandStill().solution(land));
    }

    int solution(int[][] land) {
        int answer = 0;

        int[][] s = new int[land.length][land[0].length];

        s[0][0] = land[0][0];
        s[0][1] = land[0][1];
        s[0][2] = land[0][2];
        s[0][3] = land[0][3];


        for (int i = 1; i < land.length; i++) {
            s[i][0] = land[i][0] + max(s[i - 1][1], s[i - 1][2], s[i - 1][3]);
            s[i][1] = land[i][1] + max(s[i - 1][0], s[i - 1][2], s[i - 1][3]);
            s[i][2] = land[i][2] + max(s[i - 1][0], s[i - 1][1], s[i - 1][3]);
            s[i][3] = land[i][3] + max(s[i - 1][0], s[i - 1][1], s[i - 1][2]);
        }

        int v = max(s[s.length - 1][1], s[s.length - 1][2], s[s.length - 1][3]);
        answer = s[s.length - 1][0] > v ? s[s.length - 1][0] : v;

        return answer;
    }

    int max(int a, int b, int c) {
        a = a > b ? a : b;
        return a > c ? a : c;
    }
}
