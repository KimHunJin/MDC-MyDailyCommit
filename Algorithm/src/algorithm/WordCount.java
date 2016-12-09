package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by HunJin on 2016-12-04.
 */
public class WordCount {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)==' ') {
                count++;
            }
        }
        if(s.charAt(0)== ' ') count--;
        if(s.charAt(s.length()-1)== ' ') count--;
        System.out.println(count+1);
    }
}
