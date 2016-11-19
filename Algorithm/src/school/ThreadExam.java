package school;

/**
 * Created by HunJin on 2016-10-13.
 */
public class ThreadExam {
    static int cost = 50000;

    public static void main(String[] args) {
        Amount amount = new Amount();
//        MultiThread m = new MultiThread();
        MultiThread m1 = new MultiThread("쓰레드1",500,amount);
        MultiThread m2 = new MultiThread("쓰레드2",1000,amount);

        Thread t1 = new Thread(m1);
        t1.setName("쓰레드1");
        Thread t2 = new Thread(m2);
        t2.setName("쓰레드2");

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        }catch (Exception e) {
            e.printStackTrace();
        }

    }
}

class Amount {
    public synchronized void minus(int i) {
        if(ThreadExam.cost > 0) {
            try {
                Thread.sleep(500);
            } catch (Exception e) {

            }
            System.out.printf(Thread.currentThread().getName());
            ThreadExam.cost -= i;
        }
    }
}

class MultiThread implements Runnable {

    Amount amount;
    String name;
    int cost;

    MultiThread(String name, int cost, Amount amount) {
        this.name = name;
        this.cost = cost;
        this.amount = amount;
    }

    @Override
    public void run() {
        while (ThreadExam.cost>0) {
            amount.minus(cost);
//            System.out.println(name + " : " + ThreadExam.cost);
        }
    }
}
