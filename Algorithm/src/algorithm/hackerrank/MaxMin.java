package algorithm.hackerrank;

import java.util.Arrays;
import java.util.Scanner;

public class MaxMin {

    static int angryChildren(int k, int[] arr) {
        // Complete this function
        Arrays.sort(arr);

        int min = Integer.MAX_VALUE;
        k = k-1;
        for(int i=0;i<arr.length-k;i++) {
            int s = arr[i+k] - arr[i];
            if(s < min) min = s;
        }

        return min;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        int result = angryChildren(k, arr);
        System.out.println(result);
        in.close();
    }
}
