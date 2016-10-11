package sehyun;

/**
 * Created by HunJin on 2016-10-11.
 */

class Data1 {
    int value;
}

class Data2 {
    int value;

    Data2(int x) {
        value = x;
    }
}

class This {
    int a;
    int b;

    This(int a, int b) {
        this.a = a;
        this.b = b;
    }
}

public class ConstructorTest {
    public static void main(String[] args) {
//        Data1 d1 = new Data1();
//        Data2 d2 = new Data2(5);
//        System.out.println(d2.value);

        This t1 = new This(1,2);
    }
}
