package notes;

/**
 * Created by HunJin on 2016-10-08.
 */
public class NBaseLog {
    public static void main(String[] args) {
        System.out.println("log2(8) : " + new NBaseLog().baseLog(8,2));
        System.out.println("log3(9) : " + new NBaseLog().baseLog(9,3));
    }

    double baseLog(double x, double base) {
        return Math.log10(x) / Math.log10(base);
    }
}
