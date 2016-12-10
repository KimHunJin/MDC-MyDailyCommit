package sehyun;

/**
 * Created by HunJin on 2016-12-06.
 */
public class Customer {
    private int arrivalTime, departureTime;

    public Customer(int arr) {
        arrivalTime = arr;
        departureTime = 0;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(int departureTime) {
        this.departureTime = departureTime;
    }

    public int totalTime() {
        return departureTime - arrivalTime;
    }
}
