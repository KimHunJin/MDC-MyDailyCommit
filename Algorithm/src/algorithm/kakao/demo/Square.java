package algorithm.kakao.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by HunJin on 2017-08-31.
 */
public class Square {

    public static void main(String[] args) {
        int[][] v = new int[][]{{1, 4}, {3, 4}, {3, 10}};
        new Square().solution(v);
    }

    public int[] solution(int[][] v) {
        int[] answer = new int[2];

        List<String> x = new ArrayList<>();
        List<String> y = new ArrayList<>();

        for (int i = 0; i < v.length; i++) {
            if(x.contains(v[i][0]+"")) {
                x.remove(v[i][0]+"");
            } else {
                x.add(v[i][0]+"");
            }
            if(y.contains(v[i][1]+"")) {
                y.remove(v[i][1]+"");
            } else {
                y.add(v[i][1]+"");
            }
        }

        answer[0] = Integer.parseInt(x.get(0));
        answer[1] = Integer.parseInt(y.get(0));

        return answer;
    }

}
