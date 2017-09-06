package algorithm.algorithm10000lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by HunJin on 2017-07-15.
 */
public class DecreasingNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = Integer.parseInt(sc.nextLine());
//        solution(number);
        try {
//            for(int i=0;i<1024;i++) {
                refactoring(number);
//            }
        } catch (IOException ie) {

        }
    }


    static void refactoring(int number) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        long[] arr=new long[1024];
        int count=0;
        for(int i=0;i<arr.length;i++){
            count=i;
            for(int j=9;j>=0;j--){
                if(count%2==1){
                    arr[i]=arr[i]*10+j;
                }
                count/=2;
            }
        }

        for (long l : arr) {
            System.out.println(l);
        }

    }

    static void solution(int number) {
        if (number < 10) {
            System.out.println(number);
        }
        if (number == 1022) {
            System.out.println("9876543210");
        } else if (number > 1022) {
            System.out.println(-1);
        } else {
            int count = 9;
            for (int i = 1; i <= 9; i++) {
                for (int j = i; j <= 9; j++) {
                    int value = calculator(j, i);
                    count = count + value;
                    if (count >= number) {
                        // TODO: 2017-07-15 find
                        count = count - value;
                        long startNumber = j * (int) Math.pow(10, i);
                        long lastNumber = (j + 1) * (int) Math.pow(10, i) - 1;
                        for (long k = startNumber; k <= lastNumber; k++) {
                            if (isDecreasing(k)) {
                                count++;
                                if (count == number) {
                                    System.out.print(k + " : ");
                                    System.out.println(count);
                                    return;
                                }
                            }
                        }
                        return;
                    }
                }
            }
        }

    }

    static boolean isDecreasing(long number) {

        String s = number + "";
        int charNum = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            if (charNum > s.charAt(i)) {
                charNum = s.charAt(i);
                if (i == s.length() - 1) {
                    return true;
                }
            } else {
                return false;
            }
        }

        return false;
    }

    static int calculator(int n, int p) {


        int top = 1;
        int down = 1;
        for (int i = n, j = p; j >= 1; j--, i--) {
            top *= i;
            down *= j;
        }
        return top / down;
    }
}
