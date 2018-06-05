package sehyun.subject;

/**
 * Created by HunJin on 2016-11-01.
 */
public class AnimalTest {
    public static void main(String[] args) {
        Animal a1 = new Animal();
        a1.eat();
        a1.sleep();

        Lion l1 = new Lion("Simba", 200.0, 12, 23);
        l1.eat();
        l1.roar();
        l1.sleep();

        Eagle e1 = new Eagle("Sam", 20.0, 10, 150.0);
        e1.eat();
        e1.fly();
        e1.sleep();
    }
}
