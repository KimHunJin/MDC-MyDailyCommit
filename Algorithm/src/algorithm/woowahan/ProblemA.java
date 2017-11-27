package algorithm.woowahan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


public class ProblemA {

    public static void main(String[] args) {
        try (Scanner s = new Scanner(System.in)) {
            int n = s.nextInt(); // 사람
            int d = s.nextInt(); // 방향
            int k = s.nextInt(); // 이동 수
            int j = s.nextInt(); // 증가 폭

            //여기부터 작성해 주세요
            int index = 0;
            int[] r = new int[n];
            switch (d) {
                case 0: {
                    for (int i = n - 1, c = 1; i >= 0; i--, c++) {
                        r[i] = c;
                    }
                    index = n - 1;
                    break;
                }
                case 1: {
                    for (int i = 0; i < r.length; i++) {
                        r[i] = i + 1;
                    }
                    index = 0;
                    break;
                }
            }

            int size = r.length;

            while (n > 1) {
                int loop = k;
                for (int i = 1; i <= loop; i++) {
                    int move = (index + i) % size;
                    if (r[move] == -1) {
                        loop++;
                    }
                }
                index = (index + loop) % size;
                r[index] = -1;
                k = k + j;
                n--;
            }

            for (int a : r) {
                if(a!=-1) {
                    System.out.println(a);
                    break;
                }
            }


        }
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
