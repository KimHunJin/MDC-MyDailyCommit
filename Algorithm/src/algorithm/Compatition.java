package algorithm;

/**
 * Created by HunJin on 2017-04-09.
 */
public class Compatition {
    public static void main(String[] args) {
        int count = 0;
        int n = 8;
        int a = 1;
        int b = 8;

        if((a>n/2) && (b>n/2)) {
            a = a - n/2;
            b = b - n/2;
        }
        while (a > 1 || b > 1) {

            count++;
            if (a > 1) {
                if (a % 2 != 0) {
                    a = a + 1;
                }
                a = a / 2;
            }
            if (b > 1) {
                if (b % 2 != 0) {
                    b = b + 1;
                }
                b = b / 2;
            }
            if (a == b) {
                break;
            }

        }
        System.out.println(count);

    }
}
