package algorithm.ku;

import java.util.Scanner;

/**
 * Created by HunJin on 2017-05-30.
 */
public class Main {
    public static void main(String[] args) {
        Elevator elevator1 = new Elevator(1, 1, 10, 1);
        Elevator elevator2 = new Elevator(2, 1, 10, 1);
        Elevator elevator3 = new Elevator(3, 11, 20, 1);
        Elevator elevator4 = new Elevator(4, 11, 20, 1);
        Elevator elevator5 = new Elevator(5, 1, 20, 1);
        Elevator elevator6 = new Elevator(6, 1, 20, 1);

        Scanner sc = new Scanner(System.in);
        int start = sc.nextInt();
        int destination = sc.nextInt();

        Thread thread;
        int value = 0;
        if(start < destination) {
            value = 1;
        } else {
            value = -1;
        }
        thread = new ElevatorRun(elevator1, value);
        while (elevator1.getmCurrentFloor()!=destination) {
            thread.run();
        }
    }
}
