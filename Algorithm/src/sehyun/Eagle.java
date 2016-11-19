package sehyun;

/**
 * Created by HunJin on 2016-11-01.
 */
public class Eagle extends Animal {
    double lengthWings;

    Eagle() {
    }

    Eagle(String n, double w, int age, double lW) {
        super(n, w, age);
        this.lengthWings = lW;
    }

    void eat() {
        System.out.println(name + "is eating using its beak");
    }

    @Override
    public String toString() {
        return "Animal created : + " + getClass().getSimpleName() + " [" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", age=" + age +
                ", lengthWings=" + lengthWings +
                ']';
    }

    void fly() {
        System.out.println(name + " is flying");
    }
}
