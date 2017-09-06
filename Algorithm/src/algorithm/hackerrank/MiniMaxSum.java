package algorithm.hackerrank;

/**
 * Created by HunJin on 2017-08-31.
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class MiniMaxSum {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] arr = new int[5];
        long min = 0;
        long max = 0;
        for(int arr_i=0; arr_i < 5; arr_i++){
            arr[arr_i] = in.nextInt();
        }

        Arrays.sort(arr);
        for(int i=0;i<4;i++) {
            min += arr[i];
            max += arr[i+1];
        }

        System.out.println(min + " " + max);
    }
}
