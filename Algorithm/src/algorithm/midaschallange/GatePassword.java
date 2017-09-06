package algorithm.midaschallange;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by HunJin on 2017-05-13.
 */
public class GatePassword {
    public static void main(String[] args) {
        new GatePassword().solve();
    }

    void solve() {
        int passwordLength = iRead();  // 비밀번호 길이
        int availableNumber = iRead();  // 사용가능 숫자

        boolean evanNumber = false;
        boolean oddNumber = false;

        for (int i = 0; i < availableNumber; i++) {
            int number = iRead();
            if (number % 2 == 0) {
                evanNumber = true;
            } else {
                oddNumber = true;
            }
        }

        if (evanNumber == true && oddNumber == true) {
            availableNumber -= 1;
            passwordLength -= 1;

            if (availableNumber - passwordLength < passwordLength) {
                passwordLength = availableNumber - passwordLength;
            }

            int k = 1; // 유효범위 곲
            int t = 1; // 비번 수 곲
            int loop = passwordLength;
            for (int i = 0; i < loop; i++) {
                k *= availableNumber;
                t *= passwordLength;
                availableNumber--;
                passwordLength--;
            }
            System.out.println(k / t);
        } else {
            System.out.println(0);
        }
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
