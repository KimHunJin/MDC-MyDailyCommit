package algorithm.find_programming_maestro;

public class ProblemC {
    public static void main(String[] args) {
        new ProblemC().solve();
    }

    void solve() {
        String[] s = {"1", "-", "3", "+", "5", "-", "8"};
        solution(s);
    }

    public int solution(String arr[]) {
        int answer = 1;

        String[] plusMinus = new String[arr.length / 2];
        int[] nums = new int[(arr.length / 2) + 1];

        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                nums[count] = Integer.parseInt(arr[i]);
            } else {
                plusMinus[count] = arr[i];
                count++;
            }
        }

        int[] total = new int[nums.length];


        return answer;
    }
}
