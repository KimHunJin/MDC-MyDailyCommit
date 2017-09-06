package algorithm.omok;

/**
 * Created by HunJin on 2017-06-13.
 */


import java.io.*;

public class Gravity {

    private Map map;
    private DrawBoard d;
    private GUI main;
    static int Gboard[][]; // 가중치를 저장하는 배열
    private int defense = 0; // 공격 방어 결정
    static int win = 0;
    private int ucan = 0;

    public void XYset(int x, int y) {

        Gboard[y][x] = 2; // 흑돌 위치 저장
        boolean cnt = false;


        // *******************************
        // * 처음 시작 - user가 흑돌을 놓는다.*
        // *******************************
        for (int i = 1; i < Gboard.length - 1; i++) {
            if (cnt == false) {
                for (int j = 1; j < Gboard.length - 1; j++) {
                    if (Gboard[i][j] == 2 || Gboard[i][j] == 1) {
                        if (Gboard[i - 1][j - 1] == 0 && Gboard[i][j - 1] == 0
                                && Gboard[i + 1][j - 1] == 0
                                && Gboard[i - 1][j] == 0 && Gboard[i + 1][j] == 0
                                && Gboard[i - 1][j + 1] == 0
                                && Gboard[i][j + 1] == 0
                                && Gboard[i + 1][j + 1] == 0) {
                            Gboard[i - 1][j - 1] = Gboard[i][j - 1] = Gboard[i + 1][j - 1] = Gboard[i - 1][j] = Gboard[i + 1][j] = Gboard[i - 1][j + 1] = Gboard[i][j + 1] = 3;
                            Gboard[i + 1][j + 1] = 3;
                            cnt = true;
                        }
                    }
                }
            }
        }

        for (int i = 1; i < Gboard.length - 1; i++) {
            for (int j = 1; j < Gboard.length - 1; j++) {
                if (Gboard[i][j] == 1 && Gboard[i][j - 1] == 1
                        && Gboard[i][j + 1] == 1 && Gboard[i][j - 2] == 1) { // l모양
                    win = 1;
                } else if (Gboard[i][j] == 1 && Gboard[i - 1][j] == 1
                        && Gboard[i + 1][j] == 1 && Gboard[i - 2][j] == 1) { // ㅡ모양
                    win = 1;
                } else if (Gboard[i][j] == 1 && Gboard[i - 1][j + 1] == 1
                        && Gboard[i + 1][j - 1] == 1 && Gboard[i + 2][j - 2] == 1) { // /모양
                    win = 1;
                } else if (Gboard[i][j] == 1 && Gboard[i - 1][j - 1] == 1
                        && Gboard[i + 1][j + 1] == 1 && Gboard[i - 2][j - 2] == 1) {// \모양
                    win = 1;
                }
            }
        }
        // 배열 확인 목적 출력문
        for (int i = 0; i < Gboard.length; i++) {
            for (int j = 0; j < Gboard.length; j++) {
                System.out.print(Gboard[i][j]);
            }
            System.out.println("");
        }

        setDefense(); // 방어 or 공격을 설정하기 위한 defense 메소드 호출

    }

    // *******************************
    // *  가중치 저장 배열 Gravity 초기화 *
    // *******************************
    public Gravity() {

        Gboard = new int[22][22];
        for (int i = 0; i < Gboard.length; i++) {
            for (int j = 0; j < Gboard.length; j++) {
                Gboard[i][j] = 0;
                System.out.print(Gboard[i][j]);
            }
            System.out.println("");
        }
    }

    // *******************************
    // *   defense를 설정하는 메소드      *
    // *******************************
    public void setDefense() {
        int defense = 0;

        //실행 흐름 확인을 위한 출력문
        System.out.println("setDEfense 들어옴");

        for (int i = 0; i < Gboard.length; i++) {
            for (int j = 0; j < Gboard.length; j++) {
                System.out.print(Gboard[i][j]);
            }
            System.out.println("");
        }

        System.out.println("defense =" + defense);

        for (int i = 1; i < Gboard.length - 1; i++) {
            if (defense == 1) { //흑돌이 3개 이상 연결되어 있을 때 방어 전환
                break;
            }
            for (int j = 1; j < Gboard.length - 1; j++) {// ㅡ모양
                if (Gboard[i][j] == 2 && Gboard[i - 1][j] == 2
                        && Gboard[i + 1][j] == 2) {
                    System.out.println("ㅡ 모양 들어옴");
                    if (Gboard[i - 2][j] == 1 && Gboard[i + 2][j] == 1) {
                        defense = 0;
                        Max();
                    } else {
                        defense = 1;
                        break;
                    }

                } else if (Gboard[i][j] == 2 && Gboard[i][j - 1] == 2
                        && Gboard[i][j + 1] == 2) { // l 모양
                    System.out.println("l 모양 들어옴");
                    if (Gboard[i][j - 2] == 1 && Gboard[i][j + 2] == 1) {
                        defense = 0;
                        Max();
                    } else {
                        defense = 1;
                        break;
                    }

                } else if (Gboard[i][j] == 2 && Gboard[i - 1][j + 1] == 2
                        && Gboard[i + 1][j - 1] == 2) {
                    System.out.println("// 모양 들어옴");
                    if (Gboard[i + 2][j - 1] == 1 && Gboard[i - 2][j + 2] == 1) {
                        defense = 0;
                        Max();
                    } else {
                        defense = 1;
                        break;
                    }

                } else if (Gboard[i][j] == 2 && Gboard[i - 1][j - 1] == 2
                        && Gboard[i + 1][j + 1] == 2) {
                    System.out.println("/ 모양 들어옴");
                    if (Gboard[i - 2][j - 2] == 1 && Gboard[i + 2][j + 2] == 1) {
                        defense = 0;
                        Max();
                    } else {
                        defense = 1;
                        break;
                    }

                } else {
                    defense = 0;
                }

            }
        }


        //defense 확인
        System.out.println("defense = " + defense);
        switch (defense) {
            case 0:
                Max(); //공격 - 가중치 중 최댓값 반환
                break;
            case 1:
                Min(); //방어 - 가중치 중 최소값
                break;
        }
    }

    public void Max() {
        int max = 0;
        int setX = 0;
        int setY = 0;
        boolean cnt = false;
        System.out.println("Max");


        // 백돌이 4개 있을 때 point = 9
        for (int i = 1; i < Gboard.length - 1; i++) {
            if (cnt == false) {
                for (int j = 1; j < Gboard.length - 1; j++) {
                    if ((Gboard[i][j] == 1 && Gboard[i][j - 1] == 1)
                            && (Gboard[i][j + 1] == 1 && Gboard[i][j - 2] == 1)) { // l모양
                        if ((Gboard[i][j - 3] != 1 && Gboard[i][j - 3] != 2)
                                && (Gboard[i][j + 2] != 1 && Gboard[i][j + 2] != 2)) {
                            Gboard[i][j - 3] = Gboard[i][j + 2] = 9;
                            cnt = true;
                        }
                    } else if ((Gboard[i][j] == 1 && Gboard[i - 1][j] == 1)
                            && (Gboard[i + 1][j] == 1 && Gboard[i - 2][j] == 1)) { // ㅡ모양
                        if ((Gboard[i - 3][j] != 1 && Gboard[i - 3][j] != 2)
                                && (Gboard[i + 2][j] != 1 && Gboard[i + 2][j] != 2)) {
                            Gboard[i - 3][j] = Gboard[i + 2][j] = 9;
                            cnt = true;
                        }
                    } else if ((Gboard[i][j] == 1 && Gboard[i - 1][j + 1] == 1)
                            && (Gboard[i + 1][j - 1] == 1 && Gboard[i + 2][j - 2] == 1)) { // /모양
                        if ((Gboard[i - 2][j + 2] != 1 && Gboard[i - 2][j + 2] != 2)
                                && (Gboard[i + 3][j - 3] != 1 && Gboard[i + 3][j - 3] != 2)) {
                            Gboard[i - 2][j + 2] = Gboard[i + 3][j - 3] = 9;
                            cnt = true;
                        }
                    } else if ((Gboard[i][j] == 1 && Gboard[i - 1][j - 1] == 1)
                            && (Gboard[i + 1][j + 1] == 1 && Gboard[i - 2][j - 2] == 1)) {// \모양
                        if ((Gboard[i - 3][j - 3] != 1 && Gboard[i - 3][j - 3] != 2)
                                && (Gboard[i + 2][j + 2] != 1 && Gboard[i + 2][j + 2] != 2)) {
                            Gboard[i - 3][j - 3] = Gboard[i + 2][j + 2] = 9;
                            cnt = true;
                        }
                    } else if (Gboard[i][j] == 1 && Gboard[i][j - 1] == 1
                            && Gboard[i][j + 1] == 1 && Gboard[i][j - 2] == 1
                            && Gboard[i][j - 3] == -1) { // 1_4 l 모양
                        if (Gboard[i][j + 2] != 1 && Gboard[i][j + 2] != -1) {
                            Gboard[i][j + 2] = 9;
                            cnt = true;
                        }
                    }
                }
            }
        } //끝

        // 백돌이 3개 있을 떄 point = 7
        for (int i = 1; i < Gboard.length - 1; i++) {
            if (cnt == false) {
                for (int j = 1; j < Gboard.length - 1; j++) {
                    if ((Gboard[i][j] == 1 && Gboard[i][j - 1] == 1)
                            && Gboard[i][j + 1] == 1) {
                        if ((Gboard[i][j - 2] != 1 && Gboard[i][j - 2] != 2)
                                && (Gboard[i][j + 2] != 1 && Gboard[i][j + 2] != 2)) {
                            Gboard[i][j - 2] = Gboard[i][j + 2] = 7;
                            cnt = true;
                        }
                    } else if ((Gboard[i][j] == 1 && Gboard[i - 1][j] == 1)
                            && Gboard[i + 1][j] == 1) {
                        if ((Gboard[i - 2][j] != 1 && Gboard[i - 2][j] != 2)
                                && (Gboard[i + 2][j] != 1 && Gboard[i + 2][j] != 2)) {
                            Gboard[i - 2][j] = Gboard[i + 2][j] = 7;
                            cnt = true;
                        }
                    } else if ((Gboard[i][j] == 1 && Gboard[i - 1][j + 1] == 1)
                            && Gboard[i + 1][j - 1] == 1) {
                        if ((Gboard[i - 2][j + 2] != 1 && Gboard[i - 2][j + 2] != 2)
                                && (Gboard[i + 2][j - 2] != 1 && Gboard[i + 2][j - 2] != 2)) {
                            Gboard[i - 2][j + 2] = Gboard[i + 2][j - 2] = 7;
                            cnt = true;
                        }
                    } else if ((Gboard[i][j] == 1 && Gboard[i - 1][j - 1] == 1)
                            && Gboard[i + 1][j + 1] == 1) {
                        if ((Gboard[i - 2][j - 2] != 1 && Gboard[i - 2][j - 2] != 2)
                                && (Gboard[i + 2][j + 2] != 1 && Gboard[i + 2][j + 2] != 2)) {
                            Gboard[i - 2][j - 2] = Gboard[i + 2][j + 2] = 7;
                            cnt = true;
                        }
                    }
                }
            }
        }

        // 백돌이 2개 있을 때 point = 5
        for (int i = 1; i < Gboard.length - 1; i++) {
            if (cnt == false) {
                for (int j = 1; j < Gboard.length - 1; j++) {
                    if (Gboard[i][j] == 1 && Gboard[i][j + 1] == 1) {
                        if ((Gboard[i][j - 1] != 1 && Gboard[i][j - 1] != 2)
                                && (Gboard[i][j + 2] != 1 && Gboard[i][j + 2] != 2)) {
                            Gboard[i][j - 1] = Gboard[i][j + 2] = 5;
                            cnt = true;
                        }
                    } else if (Gboard[i][j] == 1 && Gboard[i + 1][j] == 1) {
                        if ((Gboard[i - 1][j] != 1 && Gboard[i - 1][j] != 2)
                                && (Gboard[i + 2][j] != 1 && Gboard[i + 2][j] != 2)) {
                            Gboard[i - 1][j] = Gboard[i + 2][j] = 5;
                            cnt = true;
                        }
                    } else if (Gboard[i][j] == 1 && Gboard[i + 1][j + 1] == 1) {
                        if ((Gboard[i - 1][j - 1] != 1 && Gboard[i - 1][j - 1] != 2)
                                && (Gboard[i + 2][j + 2] != 1 && Gboard[i + 2][j + 2] != 2)) {
                            Gboard[i - 1][j - 1] = Gboard[i + 2][j + 2] = 5;
                            cnt = true;
                        }
                    } else if (Gboard[i][j] == 1 && Gboard[i - 1][j + 1] == 1) {
                        if ((Gboard[i - 2][j + 2] != 1 && Gboard[i - 2][j + 2] != 2)
                                && (Gboard[i + 1][j - 1] != 1 && Gboard[i + 1][j - 1] != 2)) {
                            Gboard[i - 2][j + 2] = Gboard[i + 1][j - 1] = 5;
                            cnt = true;
                        }
                    }
                }
            }
        }


        for (int i = 1; i < Gboard.length - 1; i++) {
            for (int j = 1; j < Gboard.length - 1; j++) {
                if (Gboard[i][j] > max) {
                    max = Gboard[i][j];
                    setX = i;
                    setY = j;
                }
            }
        }
        max = 0;
        if (Gboard[setX][setY] != 1 && Gboard[setX][setY] != 2) {
            Gboard[setX][setY] = 1;
        }
        System.out.println("Max문 " + Gboard[setX][setY] + " " + max);
        System.out.println("(setX,setY) = (" + setX + ", " + setY + ")");

    }

    public void Min() {

        int min = 0;
        int setX = 0;
        int setY = 0;
        boolean cnt = false;

        // 흑돌이 4개 있을 때 point = -5
        for (int i = 1; i < Gboard.length - 1; i++) {
            if (cnt == false) {
                for (int j = 1; j < Gboard.length - 1; j++) {
                    // l모양 4개 연결
                    if ((Gboard[i][j] == 2 && Gboard[i][j - 1] == 2)
                            && (Gboard[i][j + 1] == 2 && Gboard[i][j - 2] == 2)) {
                        if ((Gboard[i][j - 3] != 1 && Gboard[i][j - 3] != 2)
                                && (Gboard[i][j + 2] != 1 && Gboard[i][j + 2] != 2)) {
                            Gboard[i][j - 3] = Gboard[i][j + 2] = -5;
                            cnt = true;
                        } else if (Gboard[i][j - 3] == 1 && Gboard[i][j + 2] != 1 && Gboard[i][j + 2] != 2) { // 1개의 백돌로 막혀 있을 때
                            Gboard[i][j + 2] = -7;
                            cnt = true;
                        } else if (Gboard[i][j + 2] == 1 && Gboard[i][j - 3] != 1 && Gboard[i][j - 3] != 2) {
                            Gboard[i][j - 3] = -7;
                            cnt = true;
                        }
                        // ㅡ모양
                    } else if ((Gboard[i][j] == 2 && Gboard[i - 1][j] == 2)
                            && (Gboard[i + 1][j] == 2 && Gboard[i - 2][j] == 2)) { // ㅡ모양
                        if ((Gboard[i - 3][j] != 1 && Gboard[i - 3][j] != 2)
                                && (Gboard[i + 2][j] != 1 && Gboard[i + 2][j] != 2)) {
                            Gboard[i - 3][j] = Gboard[i + 2][j] = -5;
                            cnt = true;
                        } else if (Gboard[i - 3][j] == 1 && Gboard[i + 2][j] != 1 && Gboard[i + 2][j] != 2) { // 1개의 백돌로 막혀 있을 때
                            Gboard[i + 2][j] = -7;
                            cnt = true;
                        } else if (Gboard[i + 2][j] == 1 && Gboard[i - 3][j] != 1 && Gboard[i - 3][j] != 2) {
                            Gboard[i - 3][j] = -7;
                            cnt = true;
                        }
                        // /모양
                    } else if ((Gboard[i][j] == 2 && Gboard[i - 1][j + 1] == 2)
                            && (Gboard[i + 1][j - 1] == 2 && Gboard[i + 2][j - 2] == 2)) {
                        if ((Gboard[i - 2][j + 2] != 1 && Gboard[i - 2][j + 2] != 2)
                                && (Gboard[i + 3][j - 3] != 1 && Gboard[i + 3][j - 3] != 2)) {
                            Gboard[i - 2][j + 2] = Gboard[i + 3][j - 3] = -5;
                            cnt = true;
                        } else if (Gboard[i - 2][j + 2] == 1 && Gboard[i + 3][j - 3] != 1 && Gboard[i + 3][j - 3] != 2) { // 1개의 백돌로 막혀 있을 때
                            Gboard[i + 3][j - 3] = -7;
                            cnt = true;
                        } else if (Gboard[i + 3][j - 3] == 1 && Gboard[i - 2][j + 2] != 1 && Gboard[i - 2][j + 2] != 2) {
                            Gboard[i - 2][j + 2] = -7;
                            cnt = true;
                        }
                        // \모양
                    } else if ((Gboard[i][j] == 2 && Gboard[i - 1][j - 1] == 2)
                            && (Gboard[i + 1][j + 1] == 2 && Gboard[i - 2][j - 2] == 2)) {// \모양
                        if ((Gboard[i - 3][j - 3] != 1 && Gboard[i - 3][j - 3] != 2)
                                && (Gboard[i + 2][j + 2] != 1 && Gboard[i + 2][j + 2] != 2)) {
                            Gboard[i - 3][j - 3] = Gboard[i + 2][j + 2] = -5;
                            cnt = true;
                        } else if (Gboard[i - 3][j - 3] == 1 && Gboard[i + 2][j + 2] != 1 && Gboard[i + 2][j + 2] != 2) { // 1개의 백돌로 막혀 있을 때
                            Gboard[i + 2][j + 2] = -7;
                            cnt = true;
                        } else if (Gboard[i + 2][j + 2] == 1 && Gboard[i - 3][j - 3] != 1 && Gboard[i - 3][j - 3] != 2) {
                            Gboard[i - 3][j - 3] = -7;
                            cnt = true;
                        }
                    }
                }
            }
        }// 돌 4개 있을 때끝

        // 흑 돌이 3개 있을 때
        for (int i = 1; i < Gboard.length - 1; i++) {
            if (cnt == false) {
                for (int j = 1; j < Gboard.length - 1; j++) {
                    if ((Gboard[i][j] == 2 && Gboard[i][j - 1] == 2)
                            && Gboard[i][j + 1] == 2) { //l 모양
                        if ((Gboard[i][j - 2] != 1 && Gboard[i][j - 2] != 2)
                                && (Gboard[i][j + 2] != 1 && Gboard[i][j + 2] != 2)) {
                            Gboard[i][j - 2] = Gboard[i][j + 2] = -3;
                            cnt = true;
                        } else if (Gboard[i][j - 2] == 1 && Gboard[i][j + 2] != 1 && Gboard[i][j + 2] != 2) { //1개가 막혀있을 때
                            Gboard[i][j + 2] = -3;
                            cnt = true;
                        } else if (Gboard[i][j + 2] == 1 && Gboard[i][j - 2] != 1 && Gboard[i][j - 2] != 2) {
                            Gboard[i][j - 2] = -3;
                            cnt = true;
                        }
                    } else if ((Gboard[i][j] == 2 && Gboard[i - 1][j] == 2)
                            && Gboard[i + 1][j] == 2) {
                        if ((Gboard[i - 2][j] != 1 && Gboard[i - 2][j] != 2)
                                && (Gboard[i + 2][j] != 1 && Gboard[i + 2][j] != 2)) {
                            Gboard[i - 2][j] = Gboard[i + 2][j] = -3;
                            cnt = true;
                        } else if (Gboard[i - 2][j] == 1 && Gboard[i + 2][j] != 1 && Gboard[i + 2][j] != 2) { //1개가 막혀있을 때
                            Gboard[i + 2][j] = -3;
                            cnt = true;
                        } else if (Gboard[i + 2][j] == 1 && Gboard[i - 2][j] != 1 && Gboard[i - 2][j] != 2) {
                            Gboard[i - 2][j] = -3;
                            cnt = true;
                        }
                    } else if ((Gboard[i][j] == 2 && Gboard[i - 1][j + 1] == 2)
                            && Gboard[i + 1][j - 1] == 2) {
                        if ((Gboard[i - 2][j + 2] != 1 && Gboard[i - 2][j + 2] != 2)
                                && (Gboard[i + 2][j - 2] != 1 && Gboard[i + 2][j - 2] != 2)) {
                            Gboard[i - 2][j + 2] = Gboard[i + 2][j - 2] = -3;
                            cnt = true;
                        } else if (Gboard[i - 2][j + 2] == 1 && Gboard[i + 2][j - 2] != 1 && Gboard[i + 2][j - 2] != 2) { //1개가 막혀있을 때
                            Gboard[i + 2][j - 2] = -3;
                            cnt = true;
                        } else if (Gboard[i + 2][j - 2] == 1 && Gboard[i + 2][j - 2] != 1 && Gboard[i + 2][j - 2] != 2) {
                            Gboard[i - 2][j + 2] = -3;
                            cnt = true;
                        }
                    } else if ((Gboard[i][j] == 2 && Gboard[i - 1][j - 1] == 2)
                            && Gboard[i + 1][j + 1] == 2) {
                        if ((Gboard[i - 2][j - 2] != 1 && Gboard[i - 2][j - 2] != 2)
                                && (Gboard[i + 2][j + 2] != 1 && Gboard[i + 2][j + 2] != 2)) {
                            Gboard[i - 2][j - 2] = Gboard[i + 2][j + 2] = -3;
                            cnt = true;
                        } else if (Gboard[i - 2][j - 2] == 1 && Gboard[i + 2][j + 2] != 1 && Gboard[i + 2][j + 2] != 2) { //1개가 막혀있을 때
                            Gboard[i + 2][j + 2] = -3;
                            cnt = true;
                        } else if (Gboard[i + 2][j + 2] == 1 && Gboard[i - 2][j - 2] != 1 && Gboard[i - 2][j - 2] != 2) {
                            Gboard[i - 2][j - 2] = -3;
                            cnt = true;
                        }
                    }
                }
            }
        }


        System.out.println("min = " + min);

        for (int i = 1; i < Gboard.length - 1; i++) {
            for (int j = 1; j < Gboard.length - 1; j++) {
                if (Gboard[i][j] < min) {
                    min = Gboard[i][j];
                    setX = i;
                    setY = j;
                }
            }
        }

        min = 0;
        if (Gboard[setX][setY] != 1 && Gboard[setX][setY] != 2) {
            Gboard[setX][setY] = 1;
        }
        defense = 0;
        System.out.println("Min문 " + Gboard[setX][setY] + " " + min);
        System.out.println("(setX,setY) = (" + setX + ", " + setY + ")");

    }


}


