package sehyun.subject;

/**
 * Created by HunJin on 2016-10-16.
 */
public class HomeObj {

    static int aaa = 10;
    int global;
    int safd;

    public static void main(String[] args) {
        Home h = new Home();
        HomeObj homeObj = new HomeObj();
        homeObj.abd();

    }

    void abd() {
        aaa = 15;
    }
}
