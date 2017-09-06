package algorithm.naver;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by HunJin on 2017-05-25.
 */
public class RankingSystem {
    public static void main(String[] args) {
        String[] a = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m"};
        new RankingSystem().solve(a);
    }

    Scanner sc;

    void solve(String[] celeb) {
        sc = new Scanner(System.in);
        int length = 0;
        for (int i = 0; i < celeb.length; i++) {
            if ((int) Math.pow(2, i) < celeb.length && (int) Math.pow(2, i + 1) >= celeb.length) {
                length = i + 1;
                break;
            }
        }
        int max = length;
        length = (int) Math.pow(2, length);
        int[] score = new int[length];
        for (int i = 0; i < score.length; i++) {
            score[i] = 0;
        }

        String[] ce = new String[length];
        for (int i = 0; i < celeb.length; i++) {
            ce[i] = celeb[i];
        }

        for (int i = celeb.length; i < ce.length; i++) {
            ce[i] = "null";
        }

        for (int i = 0; i < ce.length; i++) {
            System.out.println(ce[i] + " : " + score[i]);
        }

        boolean loop = true;
        int k = 0;
        int p = 0;
        while (loop) {
            int first = (int) (Math.random() * length);
            int second = (int) (Math.random() * length);
            if (first != second && score[first] == score[second]) {
                if (ce[first].equals("null")) {
                    score[second]++;
                    score[first]--;
                } else if (ce[second].equals("null")) {
                    score[first]++;
                    score[second]--;
                } else {
                    System.out.println(ce[first] + " vs " + ce[second]);
                    k++;
                    String result = sc.nextLine();
                    if (ce[first].equals(result)) {
                        score[first]++;
                        score[second]--;
                        if (score[first] >= max) {
                            loop = false;
                        }
                    } else {
                        score[second]++;
                        score[first]--;
                        if (score[second] >= max) {
                            loop = false;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < score.length; i++) {
            System.out.println(ce[i] + " : " + score[i]);
        }
        System.out.println(k);
    }
}
