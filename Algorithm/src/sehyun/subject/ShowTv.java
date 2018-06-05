package sehyun.subject;

/**
 * Created by HunJin on 2016-10-04.
 */
public class ShowTv {

    public static void main(String[] args) {
        Tv tv = new Tv();
        Tv tv2 = new Tv();
        System.out.println(tv.volume);
        System.out.println(tv2.volume);

        tv.volumeUp(10);
        tv2.volumeDown();

        System.out.println(tv.volume);
        System.out.println(tv2.volume);
    }
}
