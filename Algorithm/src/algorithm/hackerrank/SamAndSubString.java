package algorithm.hackerrank;

import java.util.Scanner;

public class SamAndSubString {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String balls = in.next();
        int result = substrings(balls);
        System.out.println(result);
        in.close();
    }

    static int substrings(String balls) {
        // Complete this function

        int mod = (int) (Math.pow(10, 9) + 7);
        int size = balls.length();
        int dump = 1;

        long sum = 0;
        for (int i = size - 1; i >= 0; i--) {
            sum += ((balls.charAt(i) - 48) * dump * (i + 1)) % mod;
            dump = (dump * 10 + 1) % mod;
        }
        int result = (int) (sum % mod);
        return result;
    }

    static int yong(String balls) {
        // Complete this function

        int result = 0;


        for (int i = 0; i < balls.length(); i++) {
            int value = balls.charAt(i) - 48;
            result += value * (i + 1) * inputValue(balls.length() - i);
        }

        return result;
    }

    static int inputValue(int value) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < value; i++) sb.append(1);

        return Integer.parseInt(sb.toString());
    }
}
