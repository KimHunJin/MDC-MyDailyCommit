package algorithm.algorithm10000lab;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by HunJin on 2017-07-08.
 */
public class BracketValue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        int[] value = new int[s.length() / 2 + 1];
        Stack<Character> stack = new Stack<>();
        int result = 0;
        boolean status = true;

        if(s.length()%2!=0) {
            System.out.println(result);
            return;
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(c);
                value[stack.size()] = 2;
                status = true;
            } else if (c == '[') {
                stack.push(c);
                value[stack.size()] = 3;
                status = true;
            } else if (c == ')') {
                if (!stack.isEmpty() && stack.peek() == '(') {
                    if (status == true) {
                        int sum = 1;
                        for (int j = 1; j <= stack.size(); j++) {
                            sum *= value[j];
                        }
                        result += sum;
                    }
                    value[stack.size()] = 0;
                    stack.pop();
                    status = false;
                } else {
                    result = 0;
                    break;
                }
            } else if (c == ']') {
                if (!stack.isEmpty() && stack.peek() == '[') {
                    if (status == true) {
                        int sum = 1;
                        for (int j = 1; j <= stack.size(); j++) {
                            sum *= value[j];
                        }
                        result += sum;
                    }
                    value[stack.size()] = 0;
                    stack.pop();
                    status = false;
                } else {
                    result = 0;
                    break;
                }
            }
        }

        System.out.println(result);

    }
}
