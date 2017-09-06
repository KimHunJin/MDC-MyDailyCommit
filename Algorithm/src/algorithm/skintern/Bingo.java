package algorithm.skintern;

/**
 * Created by HunJin on 2017-06-17.
 */
public class Bingo {
    public static void main(String[] args) {

        int[][] boards = new int[][]{{6, 15, 17, 14, 23}, {5, 12, 16, 13, 25}, {21, 4, 2, 1, 22}, {10, 20, 3, 18, 8}, {11, 9, 19, 24, 7}};
        int[][] boards2 = {{11, 13, 15, 16}, {12, 1, 4, 3}, {10, 2, 7, 8}, {5, 14, 6, 9}};
        int[] numbs = new int[]{15, 7, 2, 25, 9, 16, 12, 18, 5, 4, 10, 13, 20};
        int[] numbs2 = {14, 3, 2, 4, 13, 1, 16, 11, 5, 15};

        new Bingo().solution(boards2, numbs2);

    }

    void solution(int[][] board, int[] nums) {

        int answer = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < board.length; j++) {
                for (int k = 0; k < board[j].length; k++) {
                    if (nums[i] == board[j][k]) {
                        board[j][k] = -1;
                    }
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (board[0][i] == nums[j]) {
                    int k = 0;
                    l : while (true) {
                        int count = 0;
                        for (int m = 0; m < nums.length; m++) {
                            if (board[k][i] == nums[m]) {
                                count++;
                                break;
                            } else {
                                if(m==nums.length-1) {
                                    break l;
                                }
                            }
                        }
                        k++;
                        if (k == board.length) {
                            if (count == board.length) {
                                answer++;
                            }
                            break;
                        }
                    }
                }
                if (board[i][0] == nums[j]) {
                    int k = 0;
                    l : while (true) {
                        int count = 0;
                        for (int m = 0; m < nums.length; m++) {
                            if (board[i][k] == nums[m]) {
                                count++;
                                break;
                            } else {
                                if(m==nums.length-1) {
                                    break l;
                                }
                            }
                        }
                        k++;
                        if (k == board.length) {
                            if (count == board.length) {
                                answer++;
                            }
                            break;
                        }
                    }
                }

                if(board[0][0] == nums[j]) {
                    int a = 0;
                    int b = 0;
                    l : while (true) {
                        int count = 0;
                        for(int m =0;m<nums.length;m++) {
                            if(board[a][b] == nums[m]) {
                                count++;
                                break;
                            }else {
                                if(m==nums.length-1) {
                                    break l;
                                }
                            }
                        }
                        a++;
                        b++;
                        if(a == board.length) {
                            if(count == board.length) {
                                answer++;
                            }
                            break;
                        }
                    }
                }
                if(board[board.length-1][0] == nums[j]) {
                    int a= board.length-1;
                    int b= 0 ;
                    l : while (true) {
                        int count = 0;
                        for(int m=0;m<nums.length;m++) {
                            if(board[a][b] == nums[m]) {
                                count++;
                                break;
                            } else {
                                if(m==nums.length-1) {
                                    break l;
                                }
                            }
                        }
                        a--;
                        b++;
                        if(b==board.length) {
                            if(count == board.length) {
                                answer++;
                            }
                            break;
                        }
                    }
                }
            }
        }


        System.out.println(answer);
    }

    void method(int[][] board) {
        int answer = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }

        for (int i = 0; i < board.length; i++) {
            if (board[0][i] == -1) {
                int j = 0;
                int count = 0;
                while (j < board.length && board[j][i] < 0) {
                    count++;
                    j++;
                }
                if (count == board.length) {
                    answer++;
                }
            }
            if (board[i][0] == -1) {
                int j = 0;
                int count = 0;
                while (j < board.length && board[i][j] < 0) {
                    count++;
                    j++;
                }
                if (count == board.length) {
                    answer++;
                }
            }
        }
        if (board[0][0] == -1) {
            int count = 0;
            for (int j = 0; j < board.length; j++) {
                if (board[j][j] == -1) {
                    count++;
                }
            }
            if (count == board.length) {
                answer++;
            }
        }

        if (board[board.length - 1][0] == -1) {
            int count = 0;
            for (int j = board.length - 1, i = 0; j >= 0; j--, i++) {
                if (board[j][i] == -1) {
                    count++;
                }
            }
            if (count == board.length) {
                answer++;
            }
        }

    }
}
