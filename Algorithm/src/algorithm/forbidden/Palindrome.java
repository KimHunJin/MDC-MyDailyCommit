package algorithm.forbidden;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Palindrome {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println(new Palindrome().solve(br.readLine().toString().trim()));
    }

    int solve(String str) {

        int length = str.length();
        int[] arr = new int[length + 1];
        arr[length] = length;
        arr[length - 1] = length;
        for (int i = length - 2; i >= 0; i--) {
            char c = str.charAt(i);
            int j = arr[i + 1];
            while (true) {
                if (c == str.charAt(j - 1)) {
                    arr[i] = j - 1;
                    break;
                }
                if (j == length) {
                    arr[i] = length;
                    break;
                }
                j = arr[j];
            }
        }
        int j = length;
        for (int i = 0; i < length; i++) {
            char c = str.charAt(i);
            if (c == str.charAt(j - 1)) {
                j--;
            } else {
                while (j < length) {
                    j = arr[j];
                    if(j>length) {
                        break;
                    }
                    if (c == str.charAt(j - 1)) {
                        j--;
                        break;
                    }
                }
            }
        }

        return str.length() + j;
    }
}
