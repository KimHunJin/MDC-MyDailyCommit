package algorithm;

/**
 * Created by HunJin on 2016-11-18.
 */
public class NumberOfSqrt {

    public static void main(String[] args) {
        System.out.println(new NumberOfSqrt().solution(4,16));
    }
    public int solution(int A, int B) {
        // write your code in Java SE 8

        double d = Math.ceil(Math.sqrt(A));
        double e = Math.floor(Math.sqrt(B));

        return ((int)e-(int)d+1);
    }
}
