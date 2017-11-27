package algorithm.nhn;

import java.util.Scanner;

public class NHNC {

    static int[][] result;
    static int b = 16;
    static int g = 96;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine(), 10);
        String[][] map = new String[n][n];


        for (int i = 0; i < map.length; i++) {
            map[i] = sc.nextLine().split(" ");
        }
        result = new int[n][n];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (!map[i][j].equals("0")) {
                    String k = map[i][j];
                    if (i - 1 >= 0 && j - 1 >= 0 && map[i][j - 1].equals(k) && map[i - 1][j].equals(k) && map[i + 1][j].equals(k) && map[i][j + 1].equals(k)) {
                        makeMap(k, 15, i, j);
                    } else if(i - 1 >= 0 && j - 1 >= 0 && !map[i][j - 1].equals(k) && !map[i - 1][j].equals(k) && !map[i + 1][j].equals(k) && !map[i][j + 1].equals(k)) {
                        makeMap(k, 0, i, j);
                    }
                }
            }
        }
    }


    static void makeMap(String map, int value, int i, int j) {
        if (map.equals("A")) {
            result[i][j] = value;
        } else if (map.equals("B")) {
            result[i][j] = value + b;
        } else if (map.equals("G")) {
            result[i][j] = value + g;
        }
    }
}
