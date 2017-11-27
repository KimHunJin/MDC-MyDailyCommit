package algorithm.forbidden;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * Created by HunJin on 2016-12-08.
 */
public class MismatchedBrackets {

    public static void main(String[] args) throws IOException {
        new MismatchedBrackets().solve();
    }

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    Stack s;

    char[] open = {
            '[',
            '{',
            '('
    };

    char[] close = {
            ']',
            '}',
            ')'
    };

    void solve() throws IOException {
        int number = loops();
        while (number-- > 0) {
            s = new Stack();
            if (result()) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    boolean result() throws IOException {
        String string = br.readLine();
        for (int i = 0; i < string.length(); i++) {
            char t = string.charAt(i);
            for (int j = 0; j < open.length; j++) {
                if (t == open[j]) {
                    s.push(t);
                }
            }
            for (int j = 0; j < close.length; j++) {
                if (t == close[j]) {
                    if (!s.isEmpty()) {
                        if ((char) s.pop() == open[j]) {
                            continue;
                        } else {
                            return false;
                        }
                    } else {
                        return false;
                    }
                }
            }
        }
        if (s.isEmpty()) {
            return true;
        } else {
            return false;
        }

    }

    int loops() throws IOException {
        return Integer.parseInt(br.readLine(), 10);
    }
}
