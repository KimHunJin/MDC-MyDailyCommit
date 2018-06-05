package sehyun.subject;

/**
 * Created by HunJin on 2016-10-11.
 */
public class qeqe {

    static int b; // 클래스 변수
    String a; // 전역변수

    public static void main(String[] args) {
        Car c1 = new Car();
        Car c2 = new Car(c1);

        int a = 10; // 지역변수

        System.out.println(c1.color + c1.gearType + c1.door);
        System.out.println(c2.color + c2.gearType + c2.door);

        c2 = new Car(c1.color, c1.gearType, c1.door);

        System.out.println(c1 + " vs " + c2);

        System.out.println(c1.color + c1.gearType + c1.door);
        System.out.println(c2.color + c2.gearType + c2.door);
    }
}
class Car {
    String color; // 전역변수
    String gearType;
    int door;

    Car() {
        this("White", "auto", 4);
    }

    Car(Car c) {
        this();
    }

    Car(String color, String gearType, int door) {
        this.color = color;
        this.gearType = gearType;
        this.door = door;
    }
}
