package algorithm.find_programming_maestro;

import java.util.HashSet;
import java.util.Set;

public class ProblemE {
    public static void main(String[] args) {
        new ProblemE().solve();
    }

    void solve() {
        int[] test = {3, 1, 2, 3};
        solution(test);
    }

    public int solution(int[] nums) {
        int answer = 0;

        int maxSize = nums.length / 2;

        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        if(maxSize > set.size()) {
            answer = set.size();
        } else {
            answer = maxSize;
        }

        return answer;
    }
}
