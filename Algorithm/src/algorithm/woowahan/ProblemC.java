package algorithm.woowahan;

import java.util.Scanner;

public class ProblemC {

    public static void main(String[] args) {
        try (Scanner s = new Scanner(System.in)) {
            int x1 = s.nextInt();
            int y1 = s.nextInt();
            int x2 = s.nextInt();
            int y2 = s.nextInt();
            int x3 = s.nextInt();
            int y3 = s.nextInt();
            int x4 = s.nextInt();
            int y4 = s.nextInt();
            int x5 = s.nextInt();
            int y5 = s.nextInt();
            int x6 = s.nextInt();
            int y6 = s.nextInt();

            //여기부터 작성해 주세요


            x1 -= x1;
            x2 -= x1;
            x3 -= x1;
            x4 -= x1;
            x5 -= x1;
            x6 -= x1;


            y1 -= y1;
            y2 -= y1;
            y3 -= y1;
            y4 -= y1;
            y5 -= y1;
            y6 -= y1;

            if (x3 < 0) {
                x3 = 0;
            }
            if (x5 < 0) {
                x5 = 0;
            }

            if (x4 > x2) {
                x4 = x2;
            }
            if (x6 > x2) {
                x6 = x2;
            }
            if (y4 > y2) {
                y4 = y2;
            }
            if (y6 > y2) {
                y6 = y2;
            }


            Retangle r1 = new Retangle(x1, y1, x2, y2);
            Retangle r2 = new Retangle(x3, y3, x4, y4);
            Retangle r3 = new Retangle(x5, y5, x6, y6);


        }
    }

    public static int size(int x, int y, int x1, int y1) {
        return (x1 - x) * (y1 - y);
    }

    public static class Retangle {

        public int ltX;
        public int ltY;
        public int rtX;
        public int rtY;
        public int lbX;
        public int lbY;
        public int rbX;
        public int rbY;
        public int size;

        public Retangle(int x1, int y1, int x2, int y2) {
            ltX = x1;
            ltY = y2;
            rtX = x2;
            rtY = y2;
            lbX = x1;
            lbY = y1;
            rbX = x2;
            rbY = y1;
            size = size(x1, y1, x2, y2);
        }
    }

}
