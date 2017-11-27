package algorithm.forbidden;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by HunJin on 2017-02-08.
 */
public class Reverse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String message = sc.nextLine();
        Stack s = new Stack();
        s.setSize(80);
        while (!message.equals("***")) {
            s.clear();
            for (int i = 0; i < message.length(); i++) {
                s.push(message.charAt(i));
            }
            String reverse = "";
            while (!s.isEmpty()) {
                reverse+=s.pop();
            }
            System.out.println(reverse);
            message = sc.nextLine();
        }
    }
}
