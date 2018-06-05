package notes;

public class CharSetTest {
    public static void main(String[] args) {
        char[] c = new char[10];

        int i =0;

        c[i++] = 65;
        c[i++] = 'A';
        c[i++] = 'A' + 1;

        System.out.println(c);

    }
}
