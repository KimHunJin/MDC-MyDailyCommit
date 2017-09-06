package algorithm.naver;

import java.util.Scanner;

/**
 * Created by HunJin on 2017-05-25.
 */
public class ImageRankingAlgorithm {
    public static void main(String[] args) {
        new ImageRankingAlgorithm().solve();
    }

    Scanner sc;

    void solve() {
        String[] s = {"a", "b", "c", "d", "e", "f","g","h","i"};
        sc = new Scanner(System.in);
        int length = 0;
        for (int i = 0; i < s.length; i++) {
            if ((int) Math.pow(2, i) < s.length && (int) Math.pow(2, i + 1) >= s.length) {
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
        for (int i = 0; i < s.length; i++) {
            ce[i] = s[i];
        }

        for (int i = s.length; i < ce.length; i++) {
            ce[i] = "null";
        }

        int currentMax = 0;
        while (true) {
            for (int i = 0; i < ce.length - 1; i++) {
                for (int j = i + 1; j < ce.length; j++) {
                    if (score[i] == currentMax && score[i] == score[j]) {
                        if (ce[i].equals("null")) {
                            score[j]++;
                            score[i]--;
                        } else if (ce[j].equals("null")) {
                            score[i]++;
                            score[j]--;
                        } else {
                            System.out.println(ce[i] + " vs " + ce[j]);
                            String result = sc.nextLine();
                            if (ce[i].equals(result)) {
                                score[i]++;
                                score[j]--;
                            } else if (ce[j].equals(result)) {
                                score[i]--;
                                score[j]++;
                            }
                        }
                        break;
                    }
                }
            }
            currentMax++;
            if(currentMax == max) {
                break;
            }
            for(int i=0;i<length;i++) {
                int tmp;
                String index;
                int first = (int)(Math.random()*length);
                int second = (int)(Math.random()*length);
                tmp = score[first];
                index = ce[first];
                score[first] = score[second];
                ce[first] = ce[second];
                score[second] = tmp;
                ce[second] = index;
            }
        }
        for(int i=0;i<ce.length;i++) {
            System.out.println(ce[i] + " : " + score[i]);
        }
    }
}
