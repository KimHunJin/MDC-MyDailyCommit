package sehyun;

/**
 * Created by HunJin on 2016-11-01.
 */
public class Animal {
    String name = "No-Name";
    double weight = 0.0;
    int age = 0;

    Animal() {
        System.out.println(toString());
    }

    Animal(String name, double w, int age) {
        this.name = name;
        this.weight = w;
        this. age = age;

        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "Animal created : + " + getClass().getSimpleName() + " [" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", age=" + age +
                ']';
    }

    void eat() {
        System.out.println(name + " is eating");
    }

    void sleep() {
        System.out.println(name + " is sleeping");
    }
}
