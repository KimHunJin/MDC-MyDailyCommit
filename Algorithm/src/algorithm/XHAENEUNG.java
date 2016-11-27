package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by HunJin on 2016-11-23.
 */
public class XHAENEUNG {
    public static void main(String[] args) throws IOException {
        String[] numbers = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten"};
        String[] oper = {"*", "+", "-"};
        int operCase = 0;
        int result = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int loops = Integer.parseInt(br.readLine(), 10);
        int number1 = 0, number2 = 0;

        for (int loop = 0; loop < loops; loop++) {
            String[] st = br.readLine().split(" ");
            for (int i = 0; i < numbers.length; i++) {
                if (st[0].equals(numbers[i])) {
                    number1 = i;
                    break;
                }
            }
            for (int i = 0; i < oper.length; i++) {
                if (st[1].equals(oper[i])) {
                    operCase = i;
                    break;
                }
            }
            for (int i = 0; i < numbers.length; i++) {
                if (st[2].equals(numbers[i])) {
                    number2 = i;
                }
            }

            switch (operCase) {
                case 0: {
                    result = number1 * number2;
                    break;
                }
                case 1: {
                    result = number1 + number2;
                    break;
                }
                case 2: {
                    result = number1 - number2;
                    break;
                }
            }

            if (result > 10 || result < 0) {
                System.out.println("No");
            } else {
                String value = st[4];
                if (numbers[result].length() == value.length()) {
                    int count = 0;

                    for (int i = 0; i < numbers[result].length(); i++) {
                        for (int j = 0; j < value.length(); j++) {
                            if (numbers[result].charAt(i) == value.charAt(j)) {
                                count++;
                                break;
                            }
                        }
                    }
                    if (count == numbers[result].length()) {
                        System.out.println("Yes");
                    } else {
                        System.out.println("No");
                    }
                } else {
                    System.out.println("No");
                }
            }
        }
    }
}
