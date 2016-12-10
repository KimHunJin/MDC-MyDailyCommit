package sehyun;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * Created by HunJin on 2016-12-06.
 */
public class TicketCounterSim {

    final static int PROCESS = 120;
    final static int MAX_CASHIERS = 10;
    final static int NUM_CUSTOMERS = 1000;
    final static double LAMBDA = 1.0 / 15;
    static int[] cashierTime = new int[MAX_CASHIERS];
    static Random rand = new Random();

    public static int earliestAvailableCashier(int cashiers) {
        int index = 0;

        int min = cashierTime[0];
        for (int i = 1; i < cashiers; i++) {
            if (min > cashierTime[i]) {
                min = cashierTime[i];
                index = i;
            }
        }
        return index;
    }

    public static void main(String[] args) {

        Customer customer;
        Queue customerQueue = new LinkedList();
        int totalTime, averageTime, departs;

        for (int cashiers = 1; cashiers <= MAX_CASHIERS; cashiers++) {

            for (int count = 0; count < cashiers; count++) {
                cashierTime[count] = 0;
            }

            // customerQueue에 NUM_CUSTOMERS 만큼의 Customer 객체를 넣는다.
            // 이를 위해서 getNext() 함수를 활용한다.
            for (int i = 0; i < NUM_CUSTOMERS; i++) {
                customer = new Customer(getNext());
                customerQueue.add(customer);
            }


            totalTime = 0;

            while (!(customerQueue.isEmpty())) {
                int i = earliestAvailableCashier(cashiers);
                if (!(customerQueue.isEmpty())) {
                    //customerQueue 맨 앞 고객을 i번째 cashier에게 할당
                    customer = (Customer) customerQueue.poll();
                    customer.setDepartureTime(customer.getArrivalTime() + PROCESS);
                    departs = customer.getDepartureTime();
                    cashierTime[i] += departs;
                    // 해당 고객의 departure 시간을 예측하여, i번째 cashier의
                    // cashierTime[i]을 적절히 수정
                    totalTime += customer.totalTime();
                }
            }

            averageTime = totalTime / NUM_CUSTOMERS;
            System.out.println("N of cashiers : " + cashiers);
            System.out.println("--> Average dwell time : " + averageTime);
        }

    }

    public static int getNext() {
        int r = (int) (Math.log(1 - rand.nextDouble()) / (-LAMBDA));
        return r;
    }
}
