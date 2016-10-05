package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by HunJin on 2016-09-30.
 */
public class Stick {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());
        int count = 0;
        int i = 7;
        while (number > 0 || i >= 0) {
            if(number >= (int)Math.pow(2,i)) {
                number = number - (int)Math.pow(2,i);
                count ++;
            }
            i--;
        }
        System.out.println(count);
    }
}
