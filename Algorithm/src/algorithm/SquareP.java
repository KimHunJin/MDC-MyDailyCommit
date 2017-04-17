package algorithm;

/**
 * Created by HunJin on 2017-03-07.
 */
public class SquareP {
    public static void main(String[] args) {
        int A = 9;
        int B = 17;

        int small = (int)Math.ceil(Math.sqrt(A));
        int big = (int)Math.floor(Math.sqrt(B));

        System.out.println(big-small+1);
    }
}
