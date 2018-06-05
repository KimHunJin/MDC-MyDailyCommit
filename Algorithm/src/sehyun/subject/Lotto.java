package sehyun.subject;

import java.util.Arrays;

/**
 * Created by HunJin on 2016-11-06.
 */
public class Lotto {
    private final static int TEST_NUMBER = 5076;
    int[] array = new int[TEST_NUMBER];
    int[] number = new int[6];
    int[] frequency = new int[46];

    public static void main(String[] args) {
        Lotto lotto = new Lotto();
        lotto.input();
        for (int i = 0; i < 1000; i++) {
            System.out.print(i + 1 + "회 : ");
            lotto.makeNumber();
            lotto.print();
            System.out.println();
        }
        System.out.println("각 숫자별 나온 횟수");
        lotto.numberFrequency();
    }

    void makeNumber() {
        int count;
        number[0] = array[(int) ((Math.random() * array.length))];
        for (int i = 1; i < 6; i++) {
            number[i] = array[(int) ((Math.random() * array.length))];
            count = i;
            while (count > 0) {
                int j = count - 1;
                if (number[i] == number[j]) {
                    number[i] = array[(int) ((Math.random() * array.length))];
                    count = i;
                } else {
                    count--;
                }
            }
        }
    }

    void print() {
        Arrays.sort(number);
        for (int i : number) {
            System.out.print(i + " ");
            frequency[i] ++;
        }
    }

    void numberFrequency() {
        for(int i=1;i<frequency.length;i++) {
            System.out.print(i + "\t\t\t");
        }
        System.out.println();
        for(int i=1;i<frequency.length;i++) {
            System.out.print(frequency[i]+"\t\t\t");
        }

    }

    void input() {

        int count = 0;

        for (int i = 0; i < 133; i++) {
            array[i] = 1;
            count++;
        }
        for (int i = count; i < 250; i++) {
            array[i] = 2;
            count++;
        }
        for (int i = count; i < 362; i++) {
            array[i] = 3;
            count++;
        }
        for (int i = count; i < 484; i++) {
            array[i] = 4;
            count++;
        }
        for (int i = count; i < 599; i++) {
            array[i] = 5;
            count++;
        }
        for (int i = count; i < 709; i++) {
            array[i] = 6;
            count++;
        }
        for (int i = count; i < 826; i++) {
            array[i] = 7;
            count++;
        }
        for (int i = count; i < 947; i++) {
            array[i] = 8;
            count++;
        }
        for (int i = count; i < 1034; i++) {
            array[i] = 9;
            count++;
        }
        for (int i = count; i < 1145; i++) {
            array[i] = 10;
            count++;
        }
        for (int i = count; i < 1260; i++) {
            array[i] = 11;
            count++;
        }
        for (int i = count; i < 1369; i++) {
            array[i] = 12;
            count++;
        }
        for (int i = count; i < 1491; i++) {
            array[i] = 13;
            count++;
        }
        for (int i = count; i < 1610; i++) {
            array[i] = 14;
            count++;
        }
        for (int i = count; i < 1721; i++) {
            array[i] = 15;
            count++;
        }
        for (int i = count; i < 1828; i++) {
            array[i] = 16;
            count++;
        }
        for (int i = count; i < 1949; i++) {
            array[i] = 17;
            count++;
        }
        for (int i = count; i < 2058; i++) {
            array[i] = 18;
            count++;
        }
        for (int i = count; i < 2169; i++) {
            array[i] = 19;
            count++;
        }
        for (int i = count; i < 2300; i++) {
            array[i] = 20;
            count++;
        }
        for (int i = count; i < 2406; i++) {
            array[i] = 21;
            count++;
        }
        for (int i = count; i < 2497; i++) {
            array[i] = 22;
            count++;
        }
        for (int i = count; i < 2599; i++) {
            array[i] = 23;
            count++;
        }
        for (int i = count; i < 2710; i++) {
            array[i] = 24;
            count++;
        }
        for (int i = count; i < 2823; i++) {
            array[i] = 25;
            count++;
        }
        for (int i = count; i < 2940; i++) {
            array[i] = 26;
            count++;
        }
        for (int i = count; i < 3071; i++) {
            array[i] = 27;
            count++;
        }
        for (int i = count; i < 3170; i++) {
            array[i] = 28;
            count++;
        }
        for (int i = count; i < 3268; i++) {
            array[i] = 29;
            count++;
        }
        for (int i = count; i < 3372; i++) {
            array[i] = 30;
            count++;
        }
        for (int i = count; i < 3486; i++) {
            array[i] = 31;
            count++;
        }
        for (int i = count; i < 3585; i++) {
            array[i] = 32;
            count++;
        }
        for (int i = count; i < 3707; i++) {
            array[i] = 33;
            count++;
        }
        for (int i = count; i < 3830; i++) {
            array[i] = 34;
            count++;
        }
        for (int i = count; i < 3942; i++) {
            array[i] = 35;
            count++;
        }
        for (int i = count; i < 4047; i++) {
            array[i] = 36;
            count++;
        }
        for (int i = count; i < 4170; i++) {
            array[i] = 37;
            count++;
        }
        for (int i = count; i < 4279; i++) {
            array[i] = 38;
            count++;
        }
        for (int i = count; i < 4394; i++) {
            array[i] = 39;
            count++;
        }
        for (int i = count; i < 4521; i++) {
            array[i] = 40;
            count++;
        }
        for (int i = count; i < 4618; i++) {
            array[i] = 41;
            count++;
        }
        for (int i = count; i < 4721; i++) {
            array[i] = 42;
            count++;
        }
        for (int i = count; i < 4850; i++) {
            array[i] = 43;
            count++;
        }
        for (int i = count; i < 4965; i++) {
            array[i] = 44;
            count++;
        }
        for (int i = count; i < 5075; i++) {
            array[i] = 45;
            count++;
        }
    }
}
