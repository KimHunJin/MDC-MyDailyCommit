package algorithm.forbidden;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by HunJin on 2016-10-02.
 *
 * 첫째 줄에 (A+B)%C,
 * 둘째 줄에 (A%C + B%C)%C,
 * 셋째 줄에 (A×B)%C,
 * 넷째 줄에 (A%C × B%C)%C를 출력한다.
 *
 * INPUT        OUTPUT
 * 5 8 4        1
 *              1
 *              0
 *              0
 */
public class Remainder {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] a = br.readLine().split(" ");
        int[] b = new int[a.length];
        for(int i=0;i<a.length;i++) {
            b[i] = Integer.parseInt(a[i]);
        }

        System.out.println((b[0]+b[1])%b[2]);
        System.out.println((b[0]%b[2] + b[1]%b[2])%b[2]);
        System.out.println((b[0]*b[1])%b[2]);
        System.out.println((b[0]%b[2] * b[1]%b[2])%b[2]);
    }
}
