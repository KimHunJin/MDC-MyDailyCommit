package algorithm.forbidden;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by HunJin on 2016-11-21.
 */
public class PerfectCrime {
    // 0 - can
    // 1 - now
    // 3 - don't
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] size = new int[Integer.parseInt(st.nextToken(), 10)+1];
        int start = Integer.parseInt(st.nextToken(), 10);
        int last = Integer.parseInt(st.nextToken(), 10);
        int jump = Integer.parseInt(st.nextToken(), 10);
        int back = Integer.parseInt(st.nextToken(), 10);
        int polices = Integer.parseInt(st.nextToken(), 10);

        size[0] = 3;
        st = new StringTokenizer(br.readLine(), " ");
        while (st.hasMoreTokens()) {
            size[Integer.parseInt(st.nextToken(),10)] = 3;
        }
        size[start] = 1;

    }
}
