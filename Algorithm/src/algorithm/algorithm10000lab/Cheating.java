package algorithm.algorithm10000lab;

import java.util.Scanner;

public class Cheating {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());

        while (T-- > 0) {

            String[] dmp = sc.nextLine().split(" ");
            int row = Integer.parseInt(dmp[0]);
            int col = Integer.parseInt(dmp[1]);

            String[][] room = new String[row][col];
            for (int i = 0; i < row; i++) {
                String line = sc.nextLine();
                room[i] = line.split("");
            }

            int[][] values = new int[row][col];

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (room[i][j].equals(".")) {
                        values[i][j] = 1;
                        if(i<1) {
                            continue;
                        }
                        if(j<2) {
                            continue;
                        }
                        int max = values[i-1][j] > values[i][j-2] ? values[i-1][j] : values[i][j-2];
                        String top = room[i-1][j];
                        String left = room[i][j-2];
                        if(top.equals(".") && left.equals(".")) {

                        }
                    } else {
                        values[i][j] = 0;
                    }

                    values[i][j] = values[i - 1][j] + 1 > values[i][j - 1] ? values[i - 1][j] + 1 : values[i][j - 1];

                    if(j < 2) {
                        continue;
                    }

                    values[i][j] = values[i-1][j] +1 > values[i][j-2] + 1 ? values[i-1][j] + 1 : values[i][j-2] + 1;
                }
            }

            System.out.println(values[row-1][col-1]);
        }
    }
}
