package algorithm.midaschallange;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by HunJin on 2017-05-13.
 */
public class TrumpCard {
    public static void main(String[] args) {
        new TrumpCard().solve();
    }

    void solve() {
        String[] beforeCard = new String[13];
        String[] afterCard = new String[13];

        int[] order = new int[13];

        for(int i=0;i<beforeCard.length;i++) {
            beforeCard[i] = readWord();
        }
        for(int i=0;i<afterCard.length;i++) {
            afterCard[i] = readWord();
        }

        for(int i=0;i<afterCard.length;i++) {
            for(int j=0;j<beforeCard.length;j++) {
                if(afterCard[i].equals(beforeCard[j])) {
                    order[i] = (j+1);
                    break;
                }
            }
        }

        int[] dis = new int[13];
        for(int i=0;i<order.length;i++) {
            dis[i] = 1;
            for(int j=0; j<i;j++) {
                if (order[j] < order[i] && dis[i] < dis[j]+1) {
                    dis[i] = dis[j]+1;
                }
            }
        }

        int ans = dis[0];
        for (int i=0; i<13; i++) {
            if (ans < dis[i]) {
                ans = dis[i];
            }
        }
        System.out.println(ans);
    }

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder b;

    String readWord() {

        b = new StringBuilder();
        try {
            int c;
            c = br.read();
            while (c >= 0 && c <= ' ')
                c = br.read();
            if (c < 0)
                return "";
            while (c > ' ') {
                b.append((char) c);
                c = br.read();
            }
        } catch (IOException ie) {
            ie.printStackTrace();
        }
        return b.toString();
    }

    int iRead() {
        return Integer.parseInt(readWord());
    }

}
