package algorithm.woowahan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProblemD {

    public static void main(String[] args) {

    }

    public static int iRead(String s) {
        return Integer.parseInt(s, 10);
    }

    public static long lRead(String s) {
        return Long.parseLong(s, 10);
    }

    public static String readWord() {
        String line = "";
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            line = br.readLine();
        } catch (IOException ie) {
            ie.printStackTrace();
        }
        return line;
    }
}
