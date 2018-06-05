package sehyun.subject;

/**
 * Created by HunJin on 2016-10-11.
 */
public class Point {
    int x,y; // 멤버변수 x,y
    static int count = 0;  // 클래스변수

    /**
     * Point 생성자 (매개변수 O)
     * @param x
     * @param y
     */
    Point(int x, int y) {
        this.x = x;
        this.y = y;
        count++;
    }

    /**
     * Point 생성자 (매개변수 X)
     */
    Point() {
        this.x = 0;
        this.y = 0;
        count++;
    }

    /**
     * toString() 오버라이드
     * @return
     */
    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    /**
     * count 반환
     * @return count
     */
    public static int getCount() {
        return count;
    }
}
