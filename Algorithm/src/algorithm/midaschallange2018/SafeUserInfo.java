package algorithm.midaschallange2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SafeUserInfo {
    public static void main(String[] args) {
        new SafeUserInfo().solve();
    }

    private void solve() {
        String id = readWord();
        String pw = readWord();

        boolean isId = idCheck(id);
        boolean isPw = pwCheck(pw);

        if (isId && isPw) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }

    private boolean pwCheck(String pw) {
        boolean isAlphabet = false;
        boolean isNumber = false;

        int size = pw.length();

        if(size < 8 || size > 16) {
            return false;
        }

        int count = 0;
        char beforeCharacter = 0;

        for (int i = 0; i < size; i++) {
            char c = pw.charAt(i);
            if (c >= 'a' && c <= 'z') {
                isAlphabet = true;
            } else if (c >= '0' && c <= '9') {
                isNumber = true;
            } else {
                isAlphabet = false;
                isNumber = false;
                break;
            }
            if (beforeCharacter == c && count >= 2) {
                count++;
                break;
            } else if (beforeCharacter == c) {
                beforeCharacter = c;
                count++;
            } else {
                beforeCharacter = c;
                count = 1;
            }
        }

        if (isAlphabet && isNumber && count < 3) {
            return true;
        } else {
            return false;
        }
    }

    private boolean idCheck(String id) {

        boolean isAlphabet = false;
        boolean isNumber = false;

        int size = id.length();

        if(size < 6 || size > 12) {
            return false;
        }

        for (int i = 0; i < size; i++) {
            char c = id.charAt(i);
            if (c >= 'a' && c <= 'z') {
                isAlphabet = true;
            } else if (c >= '0' && c <= '9') {
                isNumber = true;
            } else {
                isAlphabet = false;
                isNumber = false;
                break;
            }
        }

        if (isAlphabet && isNumber) {
            return true;
        } else {
            return false;
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
}
