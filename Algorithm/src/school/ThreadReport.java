package school;

/**
 * Created by HunJin on 2016-10-21.
 */
public class ThreadReport {
    public static void main(String[] args) {
        Account acc = new Account();
        Custommer custommer[] = new Custommer[10];
        for(int i=0;i<custommer.length;i++) {
            custommer[i] = new Custommer(acc);
            custommer[i].start();
        }

        try {
            for(int i=0;i<custommer.length;i++) {
                custommer[i].join();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("총액은 : " + acc.getTot());
    }
}

class Account {
    private int tot = 0;
    synchronized void deposit (int ant) {
        tot += ant;
    }

    int getTot() {
        return tot;
    }

}

class Custommer extends Thread {
    Account acc;

    Custommer(Account acc) {
        this.acc = acc;
    }

    public void run() {
        try {
            for(int i=0;i<300;i++) {
                System.out.println("쓰레드 " + getName() + " : " + i + "번째");
                acc.deposit(1000);
                sleep(50);
                if(acc.getTot() >= 100000) break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
