package notes;

/**
 * Created by HunJin on 2017-08-09.
 */
public class InheritanceTest extends InheritanceTest2{
    int i;

    final int re = 0;
    public InheritanceTest() {
        super();
        this.i=1;
        System.out.println(1);
    }

    public static void main(String[] args) {
        System.out.println("main");

        InheritanceTest inheritanceTest = new InheritanceTest();
        System.out.println(inheritanceTest.i);

        final int ggg;
        ggg=0;
        System.out.println(ggg);
    }

    @Override
    protected void test() {
        super.test();
    }

    @Override
    protected void test(int i) {
        super.test(i);
    }
}
