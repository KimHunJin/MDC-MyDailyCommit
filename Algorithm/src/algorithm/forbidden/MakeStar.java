package algorithm.forbidden;

import java.util.Scanner;

/**
 * Created by HunJin on 2016-12-09.
 */
public class MakeStar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        for(int i=1;i<=number;i++) {
            for(int j=0;j<i;j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
