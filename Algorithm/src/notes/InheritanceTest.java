package notes;

/**
 * Created by HunJin on 2017-08-09.
 */
public class InheritanceTest extends InheritanceTest2 implements Interface {
    int i;

    final int re = 0;

    public InheritanceTest() {
        super();
        this.i = 1;
        System.out.println(1);
    }

    public static void main(String[] args) {
        System.out.println("main");

        InheritanceTest inheritanceTest = new InheritanceTest();
        System.out.println("상속 : " + inheritanceTest.i);

    }

    @Override
    public void test() {
        super.test();
    }


    @Override
    protected void test(int i) {
        super.test(i);
    }
}
