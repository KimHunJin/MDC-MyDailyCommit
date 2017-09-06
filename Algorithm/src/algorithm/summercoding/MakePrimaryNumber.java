package algorithm.summercoding;

/**
 * Created by HunJin on 2017-05-20.
 */
public class MakePrimaryNumber {

    public static void main(String[] args) {
        int[] nums = {1,2,7,6,4};
        System.out.println(new MakePrimaryNumber().solution(nums));
    }

    int solution(int[] nums) {
        int answer = 0;
        for(int i=0;i<nums.length-2;i++) {
            int sum = 0;
            for(int j=i+1;j<nums.length-1;j++) {
                for(int k=j+1;k<nums.length;k++) {
                    sum = nums[i]+nums[j]+nums[k];
                    if(checkPrimary(sum)) {
                        answer++;
                    }
                }
            }
        }
        return answer;
    }

    boolean checkPrimary(int number) {

        boolean isPrime = true;
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                isPrime = false;
                break;
            }
        }
        return isPrime;
    }
}

