package notes.cafe24;

public class InterfaceFake {
    public static void main(String[] args) {
        E e = new E();
        C c = e;
        A a = e;
        B b = c;
        D d = e;

        c.m1();
        c.m2();
        c.m3();

    }
}


class E implements C,D {
    @Override
    public void m1() {

    }

    @Override
    public void m2() {

    }

    @Override
    public void m3() {

    }

    @Override
    public void m4() {

    }
}

interface A {
    void m1();
}

interface B {
    void m2();
}

interface C extends A,B {
    void m3();
}

interface D {
    void m4();
}