package algorithm.codewar;

/**
 * Created by HunJin on 2017-08-11.
 */
public class PlayingWithDigits {
    public static void main(String[] args) {
        System.out.println(digPow(46288, 3));
    }

    public static long digPow(int n, int p) {
        String number = String.valueOf(n);
        long sum = 0;
        for (int i = 0; i < number.length(); i++) {
            int f = Integer.parseInt(number.substring(i, i + 1));
            sum += Math.pow(f, p);
            p++;
        }
        if(sum%n ==0 ) {
            return sum/n;
        } else {
            return -1;
        }
    }
}
