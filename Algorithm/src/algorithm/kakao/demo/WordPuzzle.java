package algorithm.kakao.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HunJin on 2017-08-31.
 */
public class WordPuzzle {
    public static void main(String[] args) {
        String[] strs = {"ba", "na", "n", "a"};
        String[] strs2 = {"app", "ap", "p", "l", "e", "ple", "pp"};
        String[] strs3 = {"ba", "an", "nan", "ban", "n"};


        System.out.println(new WordPuzzle().solution(strs2, "apple"));
    }


    public List<Integer> list = new ArrayList<>();

    public int solution(String[] strs, String t) {

        int max = t.length()+1;
        int[] wordLength = new int[t.length()];
        for (int i = 0; i < t.length(); i++) {
            char tChar = t.charAt(i);
            wordLength[i] = max;
            int strsLength = strs.length;
            int currentSubLength = i+1;
            for(int j=0;j<strsLength;j++) {
                String strJ = strs[j];
                int strJLength = strJ.length();
                char strJChar = strJ.charAt(strJLength-1);
                if(strJLength <= currentSubLength && tChar == strJChar) {
                    for(int k=strJLength-1;k>=0;k--) {

                    }
                }

            }
        }

        return 0;
    }
}
