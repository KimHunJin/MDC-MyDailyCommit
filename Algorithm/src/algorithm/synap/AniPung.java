package algorithm.synap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AniPung {

    private static final int CHECK_BOOM = 100; // 터질 타일인지 체크하기 위해 더할 수

    private static final int MINIMUM_TILE = 3; // 터지기 위한 타일의 최소 개수
    private static final int REMOVE_TILE = 0; // 터진 타일의 값

    private int[][] tile;

    public static void main(String[] args) {
        new AniPung().solve();
    }

    private void solve() {
//        tile = new TestCase(5).getTile(); // test case 만들기
        tile = new TextRead().getTile(); // text로 입력 받기
        boom();
        print();
    }

    private void boom() {
        while (isCheckBoom()) {
            remove();
            down();
        }
    }

    private void remove() {
        int row = tile.length;
        int col = tile[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (tile[i][j] > CHECK_BOOM) {
                    tile[i][j] = REMOVE_TILE;
                }
            }
        }
    }

    private void down() {
        int row = tile.length;
        int col = tile[0].length;
        for (int i = row - 1; i >= 0; i--) {
            for (int j = 0; j < col; j++) {
                if (tile[i][j] == 0) {
                    for (int r = i; r > 0; r--) {
                        tile[r][j] = tile[r - 1][j];
                    }
                    tile[0][j] = CHECK_BOOM;
                    j--;
                }
            }
        }
    }

    private boolean isCheckBoom() {

        int row = tile.length;
        int col = tile[0].length;

        boolean isCheck = false;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int temp = tile[i][j] % CHECK_BOOM;
                if (temp == REMOVE_TILE) {
                    continue;
                }
                int width = checkWidth(temp, i + 1, j, 1);
                int height = checkHeight(temp, i, j + 1, 1);

                if (width >= MINIMUM_TILE) {
                    isCheck = true;
                    for (int k = i; k < i + width; k++) {
                        tile[k][j] += CHECK_BOOM;
                    }
                }
                if (height >= MINIMUM_TILE) {
                    isCheck = true;
                    for (int k = j; k < j + height; k++) {
                        tile[i][k] += CHECK_BOOM;
                    }
                }
            }
        }

        return isCheck;
    }

    private int checkWidth(int value, int row, int col, int width) {
        if (row < tile.length && (tile[row][col]) % CHECK_BOOM == value) {
            return checkWidth(value, row + 1, col, width + 1);
        } else {
            return width;
        }
    }

    private int checkHeight(int value, int row, int col, int height) {
        if (col < tile[0].length && (tile[row][col]) % CHECK_BOOM == value) {
            return checkHeight(value, row, col + 1, height + 1);
        } else {
            return height;
        }
    }

    private int checkSlash(int value, int row, int col, int slash) {
        if (row < tile.length && col < tile[0].length && (tile[row][col] % CHECK_BOOM == value)) {
            return checkSlash(value, row + 1, col + 1, slash + 1);
        } else {
            return slash;
        }
    }

    private int checkReverseSlash(int value, int row, int col, int reverseSlash) {
        if (row >= 0 && col < tile[0].length && (tile[row][col] % CHECK_BOOM == value)) {
            return checkReverseSlash(value, row - 1, col + 1, reverseSlash + 1);
        } else {
            return reverseSlash;
        }
    }

    private int checkReverseWidth(int value, int row, int col, int width) {
        if (row >= 0 && tile[row][col] % CHECK_BOOM == value) {
            return checkReverseWidth(value, row - 1, col, width + 1);
        } else {
            return width;
        }
    }

    private int checkReverseHeight(int value, int row, int col, int height) {
        if (col >= 0 && tile[row][col] % CHECK_BOOM == value) {
            return checkReverseHeight(value, row, col - 1, height + 1);
        } else {
            return height;
        }
    }
/*

    private int checkPlus(int value, int row, int col, int plus) {
        int width = checkWidth(value, row, col, plus) + checkReverseWidth(value, row, col, plus) - 1;
        int height = checkHeight(value, row, col, plus) + checkReverseHeight(value, row, col, plus) - 1;
        if(width >= 3 && height >=3) {
            return
        }
    }

*/
    private void print() {
        for (int row[] : tile) {
            for (int col : row) {
                System.out.print(col % CHECK_BOOM + " ");
            }
            System.out.println();
        }
    }
}


/**
 * 하나의 텍스트 파일로 제출하기 위해 클래스 파일을 나누지 않음.
 */
class TestCase {

    private int size;

    TestCase(int size) {
        this.size = size;
    }

    int[][] getTile() {
        return makeTile();
    }

    private int[][] makeTile() {
        int tile[][] = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                tile[i][j] = (int) (Math.random() * 4) + 1;
            }
        }
        return tile;
    }
}

class TextRead {

    private int size = 5;

    // 크기 조율 가능
    public TextRead(int size) {
        this.size = size;
    }

    TextRead() {
        this.size = 5;
    }

    int[][] getTile() {
        return makeTile();
    }

    private int[][] makeTile() {
        String[] line;
        int[][] tile = new int[size][];
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            for (int i = 0; i < size; i++) {
                line = br.readLine().split(" ");
                tile[i] = readLine(line);
            }
        } catch (IOException ie) {
            ie.printStackTrace();
        }
        return tile;
    }

    private int[] readLine(String[] line) {
        int[] row = new int[size];
        for (int i = 0; i < size; i++) {
            row[i] = changeInteger(line[i]);
        }
        return row;
    }

    private int changeInteger(String word) {
        return Integer.parseInt(word);
    }
}