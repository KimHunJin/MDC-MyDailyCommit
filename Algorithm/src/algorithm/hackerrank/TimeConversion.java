package algorithm.hackerrank;

import java.util.Scanner;

/**
 * Created by HunJin on 2017-09-01.
 */
public class TimeConversion {
    static String timeConversion(String s) {
        // Complete this function
        String[] k = s.split(":");
        if(k[2].substring(k[2].length()-2).equals("PM")) {
            if(Integer.parseInt(k[0]) < 12) {
                k[0] = Integer.parseInt(k[0]) + 12 + "";
            }
        } else {
            if(Integer.parseInt(k[0]) > 11) {
                k[0] = "00";
            }
        }
        k[2] = k[2].substring(0,2);
        String result = k[0] + ":" + k[1] + ":" + k[2];
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String result = timeConversion(s);
        System.out.println(result);
    }
}
