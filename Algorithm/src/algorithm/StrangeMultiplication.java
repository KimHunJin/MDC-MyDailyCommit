package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by HunJin on 2016-12-04.
 */
public class StrangeMultiplication {
    public static void main(String[] args) throws IOException{
        System.out.println(new StrangeMultiplication().input());
    }

    long solve(String[] value) {
        long sum = 0;
        for(int i=0;i<value[0].length();i++) {
            int number1 = Integer.parseInt(value[0].charAt(i)+"", 10);
            for(int j=0;j<value[1].length();j++) {
                int number2 = Integer.parseInt(value[1].charAt(j)+"",10);
                sum += number1 * number2;
            }
        }
        return sum;
    }

    long input() throws IOException{
        String[] value = readString();
        return solve(value);
    }

    private String[] readString() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        return br.readLine().split(" ");
    }
}
