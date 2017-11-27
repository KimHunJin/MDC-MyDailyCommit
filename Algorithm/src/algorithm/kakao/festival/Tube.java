package algorithm.kakao.festival;

public class Tube {
    public static void main(String[] args) {
        int m = 3;
        int n = 3;
        int s = 150;
        int[][] time_map = {{0, 2, 99}, {100, 100, 4}, {1, 2, 0}};

    }

    /**
     * @param m        파티장 가로 크기
     * @param n        파티장 세로 크기
     * @param s        참을 수 있는 시간
     * @param time_map 시간과 경로가 있는 맵
     * @return answer {경로길이, 수다시간}
     */
    public int[] solution(int m, int n, int s, int[][] time_map) {
        int moveDistance = 0;
        int sumOfTalkTime = 0;

        int[][][] hap_map = new int[m][n][m*n];





        int[] answer = new int[2];
        answer[0] = moveDistance;
        answer[1] = sumOfTalkTime;

        return answer;
    }
}
