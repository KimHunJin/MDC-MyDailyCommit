package algorithm.forbidden;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by HunJin on 2016-11-23.
 */
public class URI {
    public static void main(String[] args) throws IOException {
        String[] trans = {" ", "!", "$", "%", "(", ")", "*"};
        String[] encode = {"%20", "%21", "%24", "%25", "%28", "%29", "%2a"};

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine(), 10);
        for(int i=0;i<number;i++) {
            String s = br.readLine();
            String result = "";
            for(int j=0;j<s.length();j++) {
                if(s.charAt(j)=='%') {
                    for(int k=0;k<trans.length;k++) {
                        if(s.substring(j,j+3).equals(encode[k])) {
                            result+=trans[k];
                            j+=2;
                            break;
                        }
                    }
                } else {
                    result += s.charAt(j);
                }
            }
            System.out.println(result);
        }

    }
}
