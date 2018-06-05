package sehyun.subject;

/**
 * Created by HunJin on 2016-10-04.
 */
public class PracClass {
    public static void main(String[] args) {
        Notebook notebook = new Notebook();
        notebook.brightUp();
        System.out.println(notebook.bright);
    }

    static class Notebook {
        boolean power;
        int bright;
        int sound;
        String bgcolor;

        void power() {power = !power;}

        void bgcolor() {}

        void brightUp() {bright++;}

        void brightDown() {bright--;}

    }
}



