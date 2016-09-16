/**
 * Created by HunJin on 2016-09-16.
 */
public class LamdaExpression {
    public static void main(String[] args) {
        (a,b)->a>b?a:b;
    }

    /**
     * not lambda
     * @return
     */
    int max(int a, int b) {
        return a > b ? a : b;
    }
}
