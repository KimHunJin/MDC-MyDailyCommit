package algorithm.forbidden;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by HunJin on 2016-12-04.
 */
public class NSeconds {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int loops = Integer.parseInt(br.readLine(),10);
        if(loops>10) {
            loops = 10;
        }
        long sum = 0;
        for(int i=0;i<loops;i++) {
            sum += Long.parseLong(br.readLine(), 10);
        }

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(loops+"\n");
        stringBuilder.append(sum);
        System.out.println(stringBuilder.toString());

    }
}
