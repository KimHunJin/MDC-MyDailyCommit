package algorithm.forbidden;

/**
 * Created by HunJin on 2016-12-20.
 */
public class CompareNonEquals {
    public static void main(String[] args) {
        int a = 123414;
        int b = 123123;
        int c = 123414;

        byte k = 12;
        byte f = 13;

        System.out.println(a^b) ;
        System.out.println(a^c);

        System.out.println(a|c);
        System.out.println(a&c);

        System.out.println(a|b);
        System.out.println(a&b);
    }
}
