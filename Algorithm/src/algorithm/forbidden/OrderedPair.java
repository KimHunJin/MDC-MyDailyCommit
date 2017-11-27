package algorithm.forbidden;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by HunJin on 2016-12-04.
 */
public class OrderedPair {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int loops = Integer.parseInt(br.readLine(),10);
        String s = br.readLine();
        StringTokenizer st = new StringTokenizer(s, " ");
        int numbers[] = new int[loops];
        for(int i=0;i<loops;i++) {
            numbers[i] = Integer.parseInt(st.nextToken(),10);
        }

        long sum = 0;
        for(int i=0;i<loops;i++) {
            for(int j=i+1;j<loops;j++) {
                sum += numbers[i] * numbers[j];
            }
        }
        System.out.println(sum);
    }
}
