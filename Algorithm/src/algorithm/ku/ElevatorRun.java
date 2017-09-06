package algorithm.ku;

/**
 * Created by HunJin on 2017-05-30.
 */
public class ElevatorRun extends Thread {

    Elevator elevator;
    int value;

    public ElevatorRun(Elevator elevator, int value) {
        this.elevator = elevator;
        this.value = value;
    }

    @Override
    public void run() {
        super.run();
        try {
            int floor = elevator.getmCurrentFloor();
            elevator.setmCurrentFloor(floor+value);
            sleep(1000);
            System.out.println(elevator.getmId() + " 는 현재 " + elevator.getmCurrentFloor() + " 층 입니다.");
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
