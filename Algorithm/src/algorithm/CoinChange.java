package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by HunJin on 2017-01-07.
 */
public class CoinChange {
    public static void main(String[] args) {
        new CoinChange().solve();
    }

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    void solve() {
        int loop = iRead();
        while (loop-- >0) {
            input();
        }
    }

    void input() {
        try {
            String[] moneys = br.readLine().split(" ");
            int money = iRead(moneys[0]);
//            int moneyCount = iRead(moneys[1]);
            String[] coins = br.readLine().split(" ");
            int[] coinType = new int[coins.length];
            for(int i=0;i<coins.length;i++) {
                coinType[i] = iRead(coins[i]);
            }
            System.out.println(count(coinType,money));

        } catch (IOException ie) {
            ie.printStackTrace();
        }
    }

    long count(int[] coinType, int money) {
        long[] count = new long[(int)money+1];
        count[0] = 1;
        for(int i=0;i<coinType.length;i++) {
            for(int j=0;j<=money;j++) {
                if(j-coinType[i]>=0) {
                    count[j]+=count[j-coinType[i]];
                }
            }
        }
        if(count[money]>1000000007) {
            return count[money]%1000000007;
        } else {
            return count[money];
        }
    }

    String readWord() throws IOException {
        return br.readLine();
    }

    int iRead() {
        int result = 0;
        try {
            result = Integer.parseInt(readWord(),10);
        } catch (IOException ie) {
            ie.printStackTrace();
        }
        return result;
    }

    int iRead(String number) {
        return Integer.parseInt(number,10);
    }
}
