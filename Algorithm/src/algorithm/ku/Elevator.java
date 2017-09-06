package algorithm.ku;

/**
 * Created by HunJin on 2017-05-30.
 */
public class Elevator {
    private int mId;
    private int mAvailableFirst;
    private int mAvailableLast;
    private int mCurrentFloor;

    public Elevator(int id, int availableFirst, int availableLast, int currentFloor) {
        this.mId = id;
        this.mAvailableFirst = availableFirst;
        this.mAvailableLast = availableLast;
        this.mCurrentFloor = currentFloor;
    }

    public int getmAvailableFirst() {
        return mAvailableFirst;
    }

    public int getmAvailableLast() {
        return mAvailableLast;
    }

    public int getmId() {
        return mId;
    }

    public int getmCurrentFloor() {
        return mCurrentFloor;
    }

    public void setmCurrentFloor(int mCurrentFloor) {
        this.mCurrentFloor = mCurrentFloor;
    }
}
