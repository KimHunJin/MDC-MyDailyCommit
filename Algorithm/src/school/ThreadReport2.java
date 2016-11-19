package school;

/**
 * Created by HunJin on 2016-10-21.
 */
public class ThreadReport2 {
    public static void main(String[] args) {
        Money m = new Money();
        Custom[] c = new Custom[4];
        for(int i=0;i<c.length;i++) {
            c[i] = new Custom(m);
            c[i].start();
        }


        try {
            for(int i=0;i<c.length;i++) {
                c[i].join();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Money {
    int money = 1000000;

    synchronized void deposit(int ant) {
        money -= ant;
        if(getMoney() < 9800) {
            System.out.println("잔액은 " + getMoney());
        }
    }

    int getMoney() {
        return money;
    }
}

class Custom extends Thread {
    Money money;

    Custom(Money money) {
        this.money = money;
    }

    public void run() {
        try {
            for(int i=0;i<300;i++) {
                if(money.getMoney()<9800) {
                    break;
                }
                System.out.println("9800원 출력");
                money.deposit(9800);
                sleep(50);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}


