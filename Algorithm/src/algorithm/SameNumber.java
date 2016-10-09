package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by HunJin on 2016-10-09.
 */
public class SameNumber {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        int count = 0;
        while (true) {
            String b = "";
            for(int i=a.length()-1;i>=0;i--) {
                b+=a.charAt(i);
            }
            int numberA = Integer.parseInt(a);
            int numberB = Integer.parseInt(b);
            if(numberA==numberB) {
                System.out.println(numberA);
                break;
            } else {
                a = numberA + numberB +"";
            }

            count++;
            if(count>2) {
                System.out.println(-1);
                break;
            }
        }
    }
}
