package algorithm;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by HunJin on 2016-11-21.
 */
public class DeDuplicateNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        boolean[] arr = new boolean[40000000];
        try {
            StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), " ");
            StringBuilder sb = new StringBuilder();
            while (stringTokenizer.hasMoreTokens()) {

                int value = Integer.parseInt(stringTokenizer.nextToken());
                if (arr[value] == false) {
                    sb.append(value).append(" ");
                    arr[value] = true;
                }
            }
            bw.write(sb.toString());
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}