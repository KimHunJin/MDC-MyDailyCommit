package simple_project;

import java.util.Scanner;

/**
 * Created by HunJin on 2017-03-29.
 */
public class BinaryCode {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String context = sc.nextLine();

        for (int i = 0; i < context.length(); i++) {
            int number = (int) context.charAt(i);
            System.out.print(binary(number) + " ");
        }
    }

    static String binary(int number) {

        return Integer.toBinaryString(number);
    }
}
