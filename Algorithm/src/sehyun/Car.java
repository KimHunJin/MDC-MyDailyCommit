package sehyun;

/**
 * Created by HunJin on 2016-10-04.
 */
public class Car {
    int color = 0;
    boolean engineState = false;
    int speed = 0;
    int gear = 0;

    @Override
    public String toString() {
        return "Car{" +
                "color=" + color +
                ", engineState=" + engineState +
                ", speed=" + speed +
                ", gear=" + gear +
                '}';
    }
}
