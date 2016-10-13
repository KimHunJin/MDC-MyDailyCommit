package notes;

/**
 * Created by HunJin on 2016-10-13.
 */
public class ThreadExam {
    public static void main(String[] args) {
        SharedCost cost = new SharedCost();
        MultiThread m1 = new MultiThread("Thread1", cost);
        MultiThread m2 = new MultiThread("Thread2", cost);

        Thread t1 = new Thread(m1);
        Thread t2 = new Thread(m2);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class SharedCost {
    private int cost = 50000;

    public void minusCost(int i) {
        synchronized (this) {
            cost -= i;
        }
    }

    public int getCost() {
        return cost;
    }
}

class MultiThread extends Thread {

    String name;
    SharedCost cost;

    public MultiThread(String name, SharedCost cost) {
        this.name = name;
        this.cost = cost;
    }

    @Override
    public void run() {

        while (cost.getCost() > 0) {
            try {

                if (name.equals("Thread1")) {
                    cost.minusCost(1000);
                    Thread.sleep(500);
                } else {
                    Thread.sleep(500);
                    cost.minusCost(500);
                }
                System.out.println(name + " : " + cost.getCost());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
