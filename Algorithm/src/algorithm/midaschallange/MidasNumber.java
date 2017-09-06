package algorithm.midaschallange;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by HunJin on 2017-05-13.
 */
public class MidasNumber {
    public static void main(String[] args) {
        new MidasNumber().solve();
    }

    void solve() {
        int loop = iRead();
        int midas = iRead();


        int count = 0;

        System.out.println(loop);

        if(loop<4) {

        }

        for(int k=4;k<=loop;k++) {
            int n = k;
            boolean isEnd = false;
            int number = 0;
            int max = 0;
            System.out.println(k);
            while (n > 0 && isEnd == false) {
                number = (int) Math.sqrt(n);     // 확인할 수의 제곱근

                for (int i = 2; i <= number; i++) {     // 확인할 수의 제곱근까지 반복
                    if (n % i == 0) {                 // 소수로 나누어지면
                        max = i;
                        n /= i;                  // 나눈 몫을 다시 확인할 수로 대입한다.
                        break;
                    }
                    if (i == number) {                // 끝까지 나누어지는 수가 없을때
                        max = n;
                        isEnd = true;
                        break;
                    }
                }
            }
            if(max > midas) {
                count++;
            }
        }


        System.out.println(loop-1-count);
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
