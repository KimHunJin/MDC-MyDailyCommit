package algorithm.forbidden;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by HunJin on 2016-10-08.
 */
public class Studing {
    BufferedReader in;
    int[] write;
    int[] charSize;
    int line;
    int possible;
    int[][] characters;

    public static void main(String[] args) throws IOException {
        new Studing().solve();
    }

    void solve() throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        String[] dump = in.readLine().split(" ");

        line = Integer.parseInt(dump[0]);
        possible = Integer.parseInt(dump[1]);

        write = new int[26];
        charSize = new int[line];

        characters = new int[line][26];

        if(possible < 5) {
            System.out.println(0);
        } else {
            possible -= 5;
            // 필요한 문자 구하기
            for (int i = 0; i < line; i++) {
                String foo = in.readLine();
                for (int j = 0; j < foo.length(); j++) {
                    if(foo.charAt(j)!='a' && foo.charAt(j)!='n' && foo.charAt(j)!='t' && foo.charAt(j)!='i' && foo.charAt(j)!='c') {
                        characters[i][(int) foo.charAt(j) - 97]++;
                    }
                }
            }

            // 필요한 문자 수 구하기
            for (int i = 0; i < characters.length; i++) {
                for (int j = 0; j < characters[i].length; j++) {
                    if (characters[i][j] != 0) {
//                        System.out.print((char) (j + 97) + " : " + characters[i][j] + " ");
                        charSize[i]++;
                    }
                }
//                System.out.println();
            }

            // 최적의 문자 찾기
            int max = 0;
            for(int i=0;i<charSize.length;i++) {
                if(charSize[i]<=possible) {
                    if(charSize[max] < charSize[i]) {
                        max = i;
                    }
                }
            }
        }
    }
}
