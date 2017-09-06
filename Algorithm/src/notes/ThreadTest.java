package notes;

/**
 * Created by HunJin on 2017-08-09.
 */
public class ThreadTest {


    static int k = 0;

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new Run(i));
            thread.start();
        }

        System.out.println(thread3());
        a();
    }

    static public void a() {
        System.out.println("a");
    }


    static void thread1(int p) {
        k++;
        System.out.println("thread" + p + " : " + k);
    }

    static void thread2(int p) {
        k++;
        System.out.println("thread" + p + " : " + k);
    }

    static int thread3() {
        return k;
    }

    static class Run implements Runnable {
        int p;

        public Run(int p) {
            this.p = p;
        }

        @Override
        public void run() {
            thread1(p);
            thread2(p);
        }
    }
}
