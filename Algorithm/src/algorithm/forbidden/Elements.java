package algorithm.forbidden;

/**
 * Created by HunJin on 2016-11-18.
 */
public class Elements {
    public static void main(String[] args) {
        int[] A = new int[]{-1,3,-4,5,1,-6,2,1};

        System.out.println(new Elements().solution(A));
    }

    public int solution(int[] A) {
        // write your code in Java SE 8
        long sum = 0;
        for(int i=1;i<A.length;i++) {
            sum+=A[i];
        }
        if(sum==0) {
            return 0;
        }
        sum = 0;
        for(int i=0;i<A.length-1;i++) {
            sum+=A[i];
        }
        if(sum == 0) {
            return A.length-1;
        }

        int result = 0;

        for(int i=1;i<A.length-1;i++) {
            long sum1 = 0;
            long sum2 = 0;
            for(int j=0;j<i;j++) {
                sum1+=A[j];
            }
            for(int j=i+1;j<A.length;j++) {
                sum2+=A[j];
            }
            if(sum1==sum2) {
                result = i;
            }
        }
        return result;
    }
}
