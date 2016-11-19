package sehyun;

/**
 * Created by HunJin on 2016-11-01.
 */
public class Lion extends Animal {

    int nTeeth;

    Lion() {
    }

    void eat() {
        System.out.println(name + "is eating using its teeth");
    }

    Lion(String n, double w, int age, int nT) {
        super(n,w,age);
        this.nTeeth = nT;
    }

    void roar() {
        System.out.println(name + " is roaring");
    }

    @Override
    public String toString() {
        return "Animal created : + " + getClass().getSimpleName() + " [" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", age=" + age +
                ", nTeeth=" + nTeeth +
                ']';
    }
}
