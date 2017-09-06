package algorithm.midaschallange;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by HunJin on 2017-05-12.
 */
public class NumberCompare {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String[] xy = br.readLine().split(" ");
            int count = 0;
            int dis = xy[1].length() - xy[0].length();
            if(dis==0) {
                for(int i=0;i<xy[0].length();i++) {
                    if(xy[0].charAt(i) != xy[1].charAt(i)) {
                        count++;
                    }
                }
            } else {
                int min = 14;
                for(int i=0;i<=dis;i++) {
                    count = 0;
                    for(int j=0;j<xy[0].length();j++) {
                        if(xy[0].charAt(j) != xy[1].charAt(j+i)) {
                            count++;
                        }
                    }
                    if(count < min) {
                        min = count;
                    }
                }
                count = min;
            }
            System.out.println(count);
        } catch (IOException ie) {
            ie.printStackTrace();
        }
    }
}
