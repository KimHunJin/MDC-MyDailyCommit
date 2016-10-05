package sehyun;

/**
 * Created by HunJin on 2016-10-04.
 */
public class Tv {
    int channel = 0;
    boolean onOff = false;
    int volume = 10;

    void channelUp() {
        channel++;
    }
    void channelDown() {
        channel--;
    }
    void switchOn() {
        onOff = true;
    }
    void switchOff() {
        onOff = false;
    }
    void volumeUp(int size) {
        volume+=size;
    }
    void volumeDown() {
        volume--;
    }
}
