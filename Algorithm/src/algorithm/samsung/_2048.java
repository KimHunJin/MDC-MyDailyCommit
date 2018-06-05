package algorithm.samsung;

import java.util.Scanner;

public class _2048 {
    public static void main(String[] args) {
        new _2048().solve();
    }

    private void solve() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] board = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        int[] x = {0, 1, 2, 3};
        int result = 0;
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x.length; j++) {
                for (int k = 0; k < x.length; k++) {
                    for (int s = 0; s < x.length; s++) {
                        for (int m = 0; m < x.length; m++) {
                            int[] xArray = new int[5];
                            xArray[0] = x[i];
                            xArray[1] = x[j];
                            xArray[2] = x[k];
                            xArray[3] = x[s];
                            xArray[4] = x[m];

                            int value = move(board, xArray);
                            result = result > value ? result : value;
                        }
                    }
                }
            }
        }

//        int[] test = {0, 0, 1, 1, 0};
//        int result = move(board, test);

        System.out.println(result);
    }

    /**
     * x    y
     * 1    0
     * 0    1
     */
    private int move(int[][] testBoard, int[] xArray) {

        int[][] board = new int[testBoard.length][testBoard.length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = testBoard[i][j];
            }
        }

        int n = board.length;

        for (int p = 0; p < xArray.length; p++) {
            if (xArray[p] == 1) {
                for (int i = 0; i < n; i++) {
                    for (int j = n - 1; j > 0; j--) {
                        if (board[i][j] != 0 && board[i][j] == board[i][j - 1]) {
                            board[i][j] = board[i][j] * 2;
                            for (int k = j - 1; k > 0; k--) {
                                board[i][k] = board[i][k - 1];
                            }
                            board[i][0] = 0;
                        } else if (board[i][j] == 0) {
                            while (board[i][j] != 0) {
                                for (int k = j; k > 0; k--) {
                                    board[i][k] = board[i][k - 1];
                                }
                                board[i][0] = 0;
                            }
                        }
                    }
                }
            } else if(xArray[p] == 0){
                for (int i = n - 1; i > 0; i--) {
                    for (int j = 0; j < n; j++) {
                        if (board[i][j] != 0 && board[i][j] == board[i - 1][j]) {
                            board[i][j] = board[i][j] * 2;
                            for (int k = i - 1; k > 0; k--) {
                                board[k][j] = board[k - 1][j];
                            }
                            board[0][j] = 0;
                        } else if (board[i][j] == 0) {
                            while (board[i][j] != 0) {
                                for (int k = i; k > 0; k--) {
                                    board[k][j] = board[k - 1][j];
                                }
                                board[0][j] = 0;
                            }
                        }
                    }
                }
            }
//            System.out.println(xArray[p]);
//            System.out.println("------------------");
//            print(board);
//            System.out.println();
        }

//        printA(xArray);
//        System.out.println("-------------");
//        print(board);

        int max = 0;
        for (int[] i : board) {
            for (int j : i) {
                max = max > j ? max : j;
            }
        }
        return max;
    }

    private void printA(int[] board) {
        for (int s : board) {
            System.out.print(s + " ");
        }
        System.out.println();
    }

    private void print(int[][] board) {
        for (int s[] : board) {
            for (int m : s) {
                System.out.print(m + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
