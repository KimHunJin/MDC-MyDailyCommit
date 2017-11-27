package algorithm.forbidden;

import notes.ReadWord;

import java.io.IOException;

/**
 * Created by HunJin on 2016-11-05.
 */
public class StarBattle {
    ReadWord readWord = new ReadWord();
    int[][] battles;

    public static void main(String[] args) throws IOException {
        new StarBattle().solve();
    }

    void solve() throws IOException {
        int jimin = readWord.iRead();
        int hansu = readWord.iRead();
        battles = new int[jimin][hansu];

        for (int[] battle : battles) {
            for(int i : battle) {
                System.out.println(i);
            }
        }

    }
}
