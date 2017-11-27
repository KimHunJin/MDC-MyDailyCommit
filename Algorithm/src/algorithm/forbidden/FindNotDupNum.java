package algorithm.forbidden;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by HunJin on 2016-09-12.
 *
 * problem
 * loops duplicated num
 *    example aabbbcccdeeeff
 *
 * output
 *    d
 *
 */
public class FindNotDupNum {
    public static void main(String[] args) throws IOException{
        FindNotDupNum findNotDupNum = new FindNotDupNum();
        findNotDupNum.input();
        findNotDupNum.solve();
    }

    BufferedReader br;
    String s1;

    void input() throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        s1 = br.readLine();
    }

    void solve(){
        char c1 = s1.charAt(0);
        int count = 0;
        boolean check = false;
        for(int i=1;i<s1.length();i++) {
            if(c1 == s1.charAt(i)) {
                check = true;
                count = 0;
            } else {
                if(check==false && count==1) {
                    System.out.println(s1.charAt(i-1));
                    break;
                }
                check = false;
                count++;
                c1 = s1.charAt(i);
            }
        }
    }
}
