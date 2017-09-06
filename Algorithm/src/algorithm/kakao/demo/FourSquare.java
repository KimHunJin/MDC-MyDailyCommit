package algorithm.kakao.demo;

/**
 * Created by HunJin on 2017-08-31.
 */
public class FourSquare {
    public static void main(String[] args) {

        int[][] board = new int[][]{{0, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}, {0, 0, 1, 0}};
        int[][] board2 = new int[][]{{0, 0, 1, 1}, {1, 1, 1, 1}};
        System.out.println(new FourSquare().solution(board));

    }

    public int solution(int[][] board) {
        int answer = 0;

        int[][] s = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 1) {
                    if (i - 1 < 0 || j - 1 < 0) {
                        s[i][j] = 1;
                    } else {
                        s[i][j] = min(s[i - 1][j - 1], s[i - 1][j], s[i][j - 1]) + 1;
                    }
                    answer = answer > s[i][j] ? answer : s[i][j];
                }
            }
        }
        return answer * answer;
    }

    public int min(int a, int b, int c) {
        a = a < b ? a : b;
        return a < c ? a : c;
    }

}
