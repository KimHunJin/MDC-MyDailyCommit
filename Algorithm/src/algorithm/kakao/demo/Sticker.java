package algorithm.kakao.demo;

/**
 * Created by HunJin on 2017-08-31.
 */
public class Sticker {
    public static void main(String[] args) {
        int[] sticker = new int[]{14, 6, 5, 11, 3, 9, 2, 10};
        int[] sticker2 = new int[]{1, 3, 2, 5, 4};
        System.out.println(new Sticker().solution(sticker2));
    }

    public int solution(int sticker[]) {
        int answer = 0;

        if (sticker.length < 2) {
            return sticker[0];
        } else if (sticker.length < 3) {
            return max(sticker[0], sticker[1]);
        }

        int s[] = new int[sticker.length + 1];
        s[1] = sticker[0];
        s[2] = sticker[1];

        int t[] = new int[sticker.length + 1];

        for (int i = 3; i < sticker.length; i++) {
            s[i] = max(sticker[i - 1] + s[i - 2], sticker[i - 1] + s[i - 3]);
            answer = answer > s[i] ? answer : s[i];
        }

        t[1] = sticker[1];
        t[2] = sticker[2];


        for (int i = 3; i < sticker.length; i++) {
            t[i] = max(sticker[i] + t[i - 2], sticker[i] + t[i - 3]);
            answer = answer > t[i] ? answer : t[i];
        }

        return answer;
    }

    public int max(int a, int b) {
        return a > b ? a : b;
    }
}
