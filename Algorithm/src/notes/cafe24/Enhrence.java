package notes.cafe24;

public class Enhrence {
    public static void main(String[] args) {
        Child c = new Child();
    }
}

class Super {
    Super(int a) {
        System.out.println(a);
    }
}

class Child extends Super {

    public Child() {
        this(5);
    }

    Child(int a) {
        super(a);
    }
}