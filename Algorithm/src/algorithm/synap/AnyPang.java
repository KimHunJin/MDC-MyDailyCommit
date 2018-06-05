package algorithm.synap;

import java.util.Scanner;

public class AnyPang {
    private int correct;
    private int temp;

    public boolean checkSameNumber(int[][] board, int [][] checkBoard){
        int check = 0;

        //가로 검사.
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length - 1; j++) {
                if (correct >= 2 ? temp == board[i][j + 1] : board[i][j] == board[i][j + 1] && board[i][j] != 0) {
                    correct++;
                    temp = board[i][j + 1];

                    if (correct == 2) {
                        for (int k = 0; k < 3; k++) checkBoard[i][j + 1 - k] = board[i][j + 1 - k];
                        check++;
                    } else if (correct == 3) {
                        checkBoard[i][j + 1] = board[i][j + 1];
                    } else if (correct == 4) {
                        checkBoard[i][j + 1] = board[i][j + 1];
                    }
                }
                else {
                    correct = 0;
                }
            }
            correct = 0;
        }

        // 세로 검사.
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length - 1; j++) {
                if (correct >= 2 ? temp == board[j + 1][i] : board[j][i] == board[j + 1][i] && board[j][i] != 0) {
                    correct++;
                    temp = board[j + 1][i];

                    if (correct == 2) {
                        for (int k = 0; k < 3; k++) checkBoard[j + 1 - k][i] = board[j + 1 - k][i];
                        check++;
                    } else if (correct == 3) {
                        checkBoard[j + 1][i] = board[j + 1][i];
                    } else if (correct == 4) {
                        checkBoard[j + 1][i] = board[j + 1][i];
                    }
                }
                else {
                    correct = 0;
                }
            }
            correct = 0;
        }

        if(check > 0) return true;
        else return false;
    }

    public void pung(int[][] board, int[][] checkBoard){
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board.length; j++){
                if(board[i][j] == checkBoard[i][j])
                    board[i][j] = 0;
            }
        }
    }

    public void checkBoardClean(int[][] checkBoard){
        for(int i=0; i<checkBoard.length; i++){
            for(int j=0; j<checkBoard.length; j++){
                checkBoard[i][j] = 0;
            }
        }
    }

    public void numberSliding(int[][] board){
        for(int i=0; i<board.length; i++){
            for(int j=board.length-1; j>=0; j--){
                if(board[j][i] == 0){
                    int zero = j;
                    for(int k=j; k>=0; k--){
                        if(board[k][i] != 0){
                            int swap = board[zero][i];
                            board[zero][i] = board[k][i];
                            board[k][i] = swap;
                            break;
                        }
                    }
                }
            }
        }
    }

    public void printBoard(int[][] board) {
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board.length; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scan = new Scanner(System.in);
        AnyPang anyPang = new AnyPang();

        int[][] board = new int[5][5];
        int[][] checkBoard = new int[5][5];
        int stage = 1;

        //랜덤생성(표준입력으로 바꿔야함)
        System.out.println("5x5 행렬에 1~4까지의 값을 입력하시오.");

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = scan.nextInt();
            }
        }

        System.out.println();
        System.out.println("—start—");

        // 가로 교체

        int[][] widthBoard = board;

        for(int i=0;i<widthBoard.length;i++) {
            for(int j=0;j<widthBoard.length-1;j++) {
                int temp = widthBoard[i][j];
                widthBoard[i][j] = widthBoard[i][j+1];
                widthBoard[i][j+1] = temp;

                boolean trial = anyPang.checkSameNumber(widthBoard, checkBoard);
                while (trial) {
                    anyPang.checkSameNumber(widthBoard, checkBoard);
                    anyPang.pung(widthBoard, checkBoard);
                    anyPang.checkBoardClean(checkBoard);
                    anyPang.numberSliding(widthBoard);
                    anyPang.printBoard(widthBoard);

                    trial = anyPang.checkSameNumber(widthBoard, checkBoard);

                    stage++;

                    System.out.println();
                }
                anyPang.checkBoardClean(checkBoard);
                temp = widthBoard[i][j];
                widthBoard[i][j] = widthBoard[i][j+1];
                widthBoard[i][j+1] = temp;


            }

        }

//        boolean trial = anyPang.checkSameNumber(board, checkBoard);
//        if(trial == false) System.out.println("3개 이상 연속된 값이 없습니다.");
//
//        while(trial) {
//            System.out.println("stage" + stage);
//
//            anyPang.checkSameNumber(board, checkBoard);
//            anyPang.pung(board, checkBoard);
//            anyPang.checkBoardClean(checkBoard);
//            anyPang.numberSliding(board);
//            anyPang.printBoard(board);
//
//            trial = anyPang.checkSameNumber(board, checkBoard);
//            if(trial == true) System.out.println();
//
//            stage++;
//        }

//        if(trial == false) System.out.println("—end—");
    }
}
