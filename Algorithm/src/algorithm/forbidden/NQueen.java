package algorithm.forbidden;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by HunJin on 2016-12-10.
 */
public class NQueen {
    public static void main(String[] args) {
        new NQueen().input();
    }

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder b;
    int count;

    void input() {
        int loops = iRead();
        for (int i = 0; i < loops; i++) {
            solve();
            System.out.println(count);
        }
    }

    void solve() {
        count = 0;
        int mapSize = iRead();
        int[] map = new int[mapSize];
        putQueen(map, 0);
    }

    void putQueen(int[] map, int row) {
        int lastRow = map.length;
        if (row == lastRow) {
            count++;
        } else {
            for (int i = 0; i < lastRow; i++) {
                map[row] = i;
                if (isCheckQueen(map, row)) {
                    putQueen(map, row + 1);
                }
            }
        }
    }

    boolean isCheckQueen(int[] map, int row) {
        for (int i = 0; i < row; i++) {
            if (map[i] == map[row]) {
                return false;
            }
            if (Math.abs(map[i] - map[row]) == Math.abs(i - row)) {
                return false;
            }
        }
        return true;
    }

    int iRead() {
        return Integer.parseInt(readWrod());
    }

    String readWrod() {
        b = new StringBuilder();
        try {
            int c = br.read();
            while (c >= 0 && c <= ' ') {
                c = br.read();
            }
            if (c == 0) {
                return "";
            }
            while (c > ' ') {
                b.append((char) c);
                c = br.read();
            }
        } catch (IOException ie) {
            ie.printStackTrace();
        }
        return b.toString();
    }
}
