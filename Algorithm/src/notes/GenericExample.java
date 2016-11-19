package notes;

import java.util.Vector;

/**
 * Created by HunJin on 2016-10-27.
 */
public class GenericExample {
    public static void main(String[] args) {

        Vector<? super Car> v = new Vector<>();

        Vector<String> vv = new Vector<>();

        vv.add("aaa");
        vv.add("aaa");
        vv.add("aaa");
        vv.add("aaa");
        vv.add("aaa");
        vv.add("aaa");
        vv.add("aaa");
        vv.add("aaa");
        vv.add("aaa");
        vv.add("aaa");
        vv.add("aaa");
        vv.add("aaa");

        System.out.println(vv.size());
        System.out.println(vv.capacity());
    }
}

class Test {

}

class Material {
    String m = "iron";
}

class Car extends Material{
    int wheel = 4;
}

class Sonata extends Car {

}