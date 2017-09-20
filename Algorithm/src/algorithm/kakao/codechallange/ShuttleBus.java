package algorithm.kakao.codechallange;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class ShuttleBus {

    public static void main(String[] args) {
        int n = 1;
        int t = 1;
        int m = 5;
        String[] timeTable = {"09:10", "09:09", "08:00"};
        System.out.println(new ShuttleBus().solution(n, t, m, timeTable));
    }

    public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        if (m > timetable.length) {
            return latestTime(n, t);
        } else {
            Arrays.sort(timetable);
            System.out.println(convertTImeToInt(timetable[0]));
        }

        return answer;
    }

    public int convertTImeToInt(String s) {
        String[] sp = s.split(":");
        int si = Integer.parseInt(sp[0]);
        int bun = Integer.parseInt(sp[1]);

        return si * 60 + bun;
    }


    public String latestTime(int n, int t) {
        String answer = "";
        int si = 9;
        int bun = n - 1 * t;
        if (bun > 60) {
            si = si + bun / 60;
            bun = bun % 60;
        }

        if (si < 10) {
            answer = "0" + si + ":";
        } else {
            answer = si + ":";
        }
        if (bun < 10) {
            answer += 0 + "" + bun;
        } else {
            answer += bun;
        }
        return answer;
    }
}
