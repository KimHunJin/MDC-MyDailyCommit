package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by HunJin on 2016-12-04.
 */
public class ExamScore {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int score = Integer.parseInt(br.readLine(),10);
        score = score / 10;
        if(score>=9) {
            System.out.println("A");
        } else if(score >= 8) {
            System.out.println("B");
        } else if(score>=7) {
            System.out.println("C");
        } else if (score >=6) {
            System.out.println("D");
        } else {
            System.out.println("F");
        }
    }
}
