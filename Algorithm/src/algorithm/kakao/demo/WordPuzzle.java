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

        System.out.println(new WordPuzzle().solution(strs2, "banana"));
    }


    public List<Integer> list = new ArrayList<>();

    public int solution(String[] strs, String t) {
        int answer = 1000000;

        for (int i = 0; i < strs.length; i++) {
            if (strs[i].length() <= t.length()) {
                if (strs[i].equals(t.substring(0, strs[i].length()))) {
                    puzzle(strs, t.substring(strs[i].length()), 0);
                }
            }
        }

        for (int i = 0; i < list.size(); i++) {
            answer = answer < list.get(i) ? answer : list.get(i);
        }

        if (list.size() == 0) {
            answer = -1;
        }

        return answer;
    }

    void puzzle(String[] strs, String t, int count) {
        count++;
        if (t.isEmpty()) {
            list.add(count);
        }
        for (int i = 0; i < strs.length; i++) {
            if (t.length() >= strs[i].length()) {
                if (strs[i].equals(t.substring(0, strs[i].length()))) {
                    puzzle(strs, t.substring(strs[i].length()), count);
                }
            }
        }
    }
}
