package algorithm.algorithm10000lab;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Teaching {

    private List<String> list = new ArrayList<>();

    private int k;
    private int useWord;

    private boolean[] isUse = new boolean[26];

    private char[] defaultWord = {'a', 'c', 'n', 't', 'i'};

    public static void main(String[] args) {
        new Teaching().solve();
    }

    private void solve() {
        input();
        check();
        print();
    }

    private void check() {

    }

    private void input() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        k = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            List<Character> cl = new ArrayList<>();
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                if (!cl.contains(c)) {
                    cl.add(c);
                }
            }
            Collections.sort(cl);
            String dmp = "";
            for (char c : cl) {
                dmp += c;
            }
            list.add(dmp);
        }
        for (int i = 0; i < 5; i++) {
            initBool(defaultWord[i]);
        }
    }

    private void initBool(char word) {
        isUse[word - 'a'] = true;
        useWord++;
    }

    private void find() {

    }

    private void print() {
        for (String s : list) {
            System.out.println(s);
        }
    }
}
