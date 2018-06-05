package sehyun.subject;

/**
 * Created by HunJin on 2016-10-11.
 */
public class Circle {
    static int count = 0; // 클래스 변수
    Point center; // 멤버변수 포인터
    int radius; // 멤버변수 반지름

    /**
     * Circle 생성자 (매개변수 O)
     * @param center
     * @param radius
     */
    Circle(Point center, int radius) {
        this.center = center;
        this.radius = radius;
        count++;
    }

    /**
     * Circle 생성자 (매개변수 X)
     */
    Circle() {
        this.center = new Point();
        this.radius = 100;
        count++;
    }

    /**
     * toString 오버라이드
     * @return
     */
    @Override
    public String toString() {
        return "Circle{" +
                "center=" + center +
                ", radius=" + radius +
                '}';
    }

    /**
     * count 반환
     * @return count
     */
    public static int getCount() {
        return count;
    }

    /**
     * 원의 넓이 반환
     * @return area
     */
    int getArea() {
        return (int)(radius*radius*Math.PI);
    }
}
