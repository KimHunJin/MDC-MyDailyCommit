package algorithm.midaschallange;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by HunJin on 2017-05-12.
 */
public class AppleSet {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int loop = Integer.parseInt(br.readLine());
            int[] box = new int[loop+1];
            String[] dump = br.readLine().split(" ");
            for(int i=1;i<=loop;i++) {
                box[i] = Integer.parseInt(dump[i-1]);
            }

            int[] cost = new int[loop+1];
            for(int i=1;i<=loop;i++) {
                for(int j=1;j<=i;j++) {
                    if(cost[i] < cost[i-j] + box[j]) {
                        cost[i] = cost[i-j] + box[j];
                    }
                }
            }
            System.out.println(cost[loop]);

        } catch(IOException ie) {
            ie.printStackTrace();
        }
    }
}
