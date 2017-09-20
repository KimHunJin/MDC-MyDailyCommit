package algorithm.kakao.codechallange;

public class Friends {
    public static void main(String[] args) {

        String[] boards = {"CCBDE", "AAADE", "AAABF", "CCBBF"};

        new Friends().solution(4, 5, boards);
    }

    public int solution(int m, int n, String[] board) {
        int answer = 0;
        int[][] pan = new int[m][n];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length(); j++) {
                pan[i][j] = (int) board[i].charAt(j) - 64;
            }
        }

        for (int i = m - 1; i >= 1; i--) {
            for (int j = n - 1; j >= 1; j--) {
                int k = pan[i][j];
                if (k == pan[i - 1][j - 1] && k == pan[i - 1][j] && k == pan[i][j - 1]) {

                }
            }
        }

        for (int[] ints : pan) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }

        return answer;
    }
}
