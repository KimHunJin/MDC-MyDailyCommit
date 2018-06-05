package algorithm.woowahan2;

import java.util.Stack;

public class A {
    public static void main(String[] args) {
        int a = 0;
        String s = String.valueOf(a);
    }

    // you can also use imports, for example:
    class Solution {

        private Stack<String> stack;

        public int solution(String S) {
            // write your code in Java SE 8
            stack = new Stack();
            String[] split = S.split(" ");
            String[] op = {"DUP", "POP", "+", "-"};
            String result = "";
            boolean isOperate = true;
            for (int i = 0; i < split.length; i++) {
                String s = split[i];
                for (int j = 0; j < op.length; j++) {
                    if (s.equals(op[j])) {
                        isOperate = operate(op[j]);
                        break;
                    } else {
                        if (j == op.length - 1) {
                            stack.push(s);
                        }
                    }
                }
                if (!isOperate) {
                    break;
                }
            }
            if (isOperate) {
                result = stack.peek();
            } else {
                result = "-1";
            }
            return Integer.parseInt(result);
        }

        private boolean operate(String op) {
            boolean isOperate = true;
            switch (op) {
                case "DUP": {
                    String s = stack.peek();
                    stack.push(s);
                    break;
                }
                case "POP": {
                    stack.pop();
                    break;
                }
                case "+": {
                    if (stack.size() > 1) {
                        String s1 = stack.pop();
                        String s2 = stack.pop();
                        int result = Integer.parseInt(s1) + Integer.parseInt(s2);
                        stack.push(String.valueOf(result));
                    } else {
                        isOperate = false;
                    }
                    break;
                }
                case "-": {
                    if (stack.size() > 1) {
                        String s1 = stack.pop();
                        String s2 = stack.pop();
                        int result = Integer.parseInt(s1) - Integer.parseInt(s2);
                        stack.push(String.valueOf(result));
                    } else {
                        isOperate = false;
                    }
                    break;
                }
            }
            return isOperate;
        }
    }
}
