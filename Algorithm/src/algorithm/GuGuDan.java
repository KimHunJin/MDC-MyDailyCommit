package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by HunJin on 2016-12-04.
 */
public class GuGuDan {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long dan = Long.parseLong(br.readLine(),10);
        for(int i=1;i<10;i++) {
            long result = dan * i;
            System.out.println(dan + " * " + i + " = " + result);
        }
    }
}
