package sehyun.subject;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by HunJin on 2016-11-06.
 */
public class LottoY {
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        int[] array = new int[725 * 7 + 1];

        int count = 1;

        for (int i = count; i <= 133; i++) {
            array[i] = 1;
            count++;
        }
        for (int i = count; i <= 250; i++) {
            array[i] = 2;
            count++;
        }
        for (int i = count; i <= 362; i++) {
            array[i] = 3;
            count++;
        }
        for (int i = count; i <= 484; i++) {
            array[i] = 4;
            count++;
        }
        for (int i = count; i <= 599; i++) {
            array[i] = 5;
            count++;
        }
        for (int i = count; i <= 709; i++) {
            array[i] = 6;
            count++;
        }
        for (int i = count; i <= 826; i++) {
            array[i] = 7;
            count++;
        }
        for (int i = count; i <= 947; i++) {
            array[i] = 8;
            count++;
        }
        for (int i = count; i <= 1034; i++) {
            array[i] = 9;
            count++;
        }
        for (int i = count; i <= 1145; i++) {
            array[i] = 10;
            count++;
        }
        for (int i = count; i <= 1260; i++) {
            array[i] = 11;
            count++;
        }
        for (int i = count; i <= 1369; i++) {
            array[i] = 12;
            count++;
        }
        for (int i = count; i <= 1491; i++) {
            array[i] = 13;
            count++;
        }
        for (int i = count; i <= 1610; i++) {
            array[i] = 14;
            count++;
        }
        for (int i = count; i <= 1721; i++) {
            array[i] = 15;
            count++;
        }
        for (int i = count; i <= 1828; i++) {
            array[i] = 16;
            count++;
        }
        for (int i = count; i <= 1949; i++) {
            array[i] = 17;
            count++;
        }
        for (int i = count; i <= 2058; i++) {
            array[i] = 18;
            count++;
        }
        for (int i = count; i <= 2169; i++) {
            array[i] = 19;
            count++;
        }
        for (int i = count; i <= 2300; i++) {
            array[i] = 20;
            count++;
        }
        for (int i = count; i <= 2406; i++) {
            array[i] = 21;
            count++;
        }
        for (int i = count; i <= 2497; i++) {
            array[i] = 22;
            count++;
        }
        for (int i = count; i <= 2599; i++) {
            array[i] = 23;
            count++;
        }
        for (int i = count; i <= 2710; i++) {
            array[i] = 24;
            count++;
        }
        for (int i = count; i <= 2823; i++) {
            array[i] = 25;
            count++;
        }
        for (int i = count; i <= 2940; i++) {
            array[i] = 26;
            count++;
        }
        for (int i = count; i <= 3071; i++) {
            array[i] = 27;
            count++;
        }
        for (int i = count; i <= 3170; i++) {
            array[i] = 28;
            count++;
        }
        for (int i = count; i <= 3268; i++) {
            array[i] = 29;
            count++;
        }
        for (int i = count; i <= 3372; i++) {
            array[i] = 30;
            count++;
        }
        for (int i = count; i <= 3486; i++) {
            array[i] = 31;
            count++;
        }
        for (int i = count; i <= 3585; i++) {
            array[i] = 32;
            count++;
        }
        for (int i = count; i <= 3707; i++) {
            array[i] = 33;
            count++;
        }
        for (int i = count; i <= 3830; i++) {
            array[i] = 34;
            count++;
        }
        for (int i = count; i <= 3942; i++) {
            array[i] = 35;
            count++;
        }
        for (int i = count; i <= 4047; i++) {
            array[i] = 36;
            count++;
        }
        for (int i = count; i <= 4170; i++) {
            array[i] = 37;
            count++;
        }
        for (int i = count; i <= 4279; i++) {
            array[i] = 38;
            count++;
        }
        for (int i = count; i <= 4394; i++) {
            array[i] = 39;
            count++;
        }
        for (int i = count; i <= 4521; i++) {
            array[i] = 40;
            count++;
        }
        for (int i = count; i <= 4618; i++) {
            array[i] = 41;
            count++;
        }
        for (int i = count; i <= 4721; i++) {
            array[i] = 42;
            count++;
        }
        for (int i = count; i <= 4850; i++) {
            array[i] = 43;
            count++;
        }
        for (int i = count; i <= 4965; i++) {
            array[i] = 44;
            count++;
        }
        for (int i = count; i <= 5075; i++) {
            array[i] = 45;
            count++;
        }

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        array = new int[6];
        for(int i=0;i<array.length;i++) {
            array[i] = i+1;
        }
        int[][] lotto = new int[n + 1][6];

        for (int j = 1; j <= n; j++) {
            for (int i = 0; i < 6; i++) {
//                lotto[j][i] = array[(int) (Math.random() * 5075) + 1];
                lotto[j][i] = array[(int)(Math.random()*6)];
            }

            for (int a = 0; a < 5; a++) {
                for (int b = a + 1; b < 6; b++) {
//                    if (lotto[j][a] == lotto[j][b]) {
////                        lotto[j][b] = array[(int) (Math.random() * 5075) + 1];
//                        lotto[j][b] = array[(int)(Math.random()*10)];
//                    }
                    while(lotto[j][a]==lotto[j][b]){
                        lotto[j][b] = array[(int)(Math.random()*6)];
                    }
                }
            }
        }


        for (int j = 1; j <= n; j++) {
            System.out.println();
            System.out.println(j + "회차");

            for (int i = 0; i < 6; i++) {
                Arrays.sort(lotto[j]);
                System.out.print(lotto[j][i] + " ");
            }
            System.out.println();
        }

    }
}
