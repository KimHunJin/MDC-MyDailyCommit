package algorithm.line;

import java.util.Scanner;

public class StringParsing {
    public static void main(String[] args) {
        new StringParsing().solve();
    }

    private void solve() {
        Scanner sc = new Scanner(System.in);
        String size = sc.nextLine();

        String color = sc.nextLine();
        String[] colorTmp = color.split(": ");
        String colorX = colorTmp[1].trim();

        colorX = colorX.substring(2,colorX.length());

        long l = Long.parseLong(colorX, 16);



        String number= sc.nextLine();
        String[] numberTmp = number.split(": ");
        int n = Integer.parseInt(numberTmp[1]);
        String no = sc.nextLine();

        String[] frame = new String[n];

        String[] sizeTmp = size.split(": ");
        String[] sizes = sizeTmp[1].split("x");
        int width = Integer.parseInt(sizes[0].trim());
        int height = Integer.parseInt(sizes[1].trim());

        for(int i=0;i<n;i++) {
            frame[i] = sc.nextLine();
        }

        System.out.println(width);
        System.out.println(height);

        System.out.println(l);

        System.out.println(n);

        for(int i=0;i<n;i++) {
            String[] frameTmp = frame[i].split(" ");
            int yn  =0;
            if(frameTmp[3].trim().equals("yes")) {
                yn = 1;
            } else {
                yn = 0;
            }
            System.out.println(frameTmp[1] + "x" + frameTmp[2] +", " + frameTmp[4] + ", " + yn );
        }

    }

}
