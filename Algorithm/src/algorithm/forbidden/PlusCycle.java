package algorithm.forbidden;

import java.util.Scanner;

/**
 * Created by HunJin on 2016-12-21.
 */
public class PlusCycle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int sum = (number%10*10) + ((number / 10 + number % 10)%10);
        int count = 0;
        while (true) {
            count++;
            if(sum == number) {
                break;
            } else {
                sum = (sum%10*10) +((sum /10 + sum % 10)%10);
            }
        }
        System.out.println(count);
    }
}
