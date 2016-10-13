package sehyun;

/**
 * Created by HunJin on 2016-10-11.
 */
public class CircleTest {

    public static void main(String[] args) {
        Point p1 = new Point();
        System.out.println(p1 + " created");

        Point p2 = new Point(5, 10);
        System.out.println(p2 + " created");

        // 생성된 Piont 인스턴스의 개수를 출력하는 문장을 여기에 추가하시오.
        System.out.println("N of points = " + Point.getCount());

        Circle c1 = new Circle();
        System.out.println(c1 + " created");

        Circle c2 = new Circle(p2, 15);
        System.out.println(c2 + " created");

        // 생성된 Piont 인스턴스의 개수를 출력하는 문장을 여기에 추가하시오.
        // 생성된 Circle 인스턴스의 개수를 출력하는 문장을 여기에 추가하시오.
        System.out.println("N of points = " + Point.getCount());
        System.out.println("N of circles = " + Circle.getCount());

        System.out.println("area of c2 = " + c2.getArea());

    }


}
