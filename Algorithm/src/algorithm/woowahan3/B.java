package algorithm.woowahan3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        new B().solve();
    }

    private void solve() {
        try (Scanner s = new Scanner(System.in)) {
            int n = s.nextInt();

            Map<Integer, Integer> map = new HashMap<>();

            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                int a = s.nextInt();
                int b = s.nextInt();

                //여기부터 작성해 주세요

                if (min > a) {
                    min = a;
                }
                if (min > b) {
                    min = b;
                }
                if (max < a) {
                    max = a;
                }
                if (max < b) {
                    max = b;
                }


                for (int j = a * 2; j <= b * 2; j++) {
                    input(map, j);
                }


            }

            min = min * 2;
            max = max * 2;

            for (int i = min; i <= max; i++) {
                if (map.get(i) == null) {
                    map.put(i, 0);
                }
            }

            if (map.get(min) % 2 == 0) {
                int check = map.get(min);
                System.out.print("(-, ");
                Integer t = new Integer(min);
                t++;
                while (map.get(t) == check && t <= max) {
                    t++;
                }
                t--;
                min = t;
                System.out.println(t / 2 + "]");
            } else {
                System.out.println("(-, " + min / 2 + ")");
            }
            for (int i = min; i <= max; i++) {
                if (map.get(i) % 2 == 0) {
                    int check = map.get(i);
                    if (i % 2 == 0) {
                        System.out.print("[" + i / 2 + ", ");
                    } else {
                        System.out.print("(" + ((i / 2)) + ", ");
                    }
                    Integer t = new Integer(i);
                    t++;
                    while (map.get(t) == check && t <= max) {
                        t++;
                    }
                    t--;
                    i = t;
                    if (t % 2 == 0) {
                        System.out.println(t / 2 + "]");
                    } else {
                        System.out.println(t / 2 + 1 + ")");
                    }
                }
            }
            System.out.println("(" + max / 2 + ", +)");
        }
    }

    public static void input(Map<Integer, Integer> map, int key) {
        if (map.containsKey(key)) {
            int value = map.get(key);
            value++;
            map.put(key, value);
        } else {
            map.put(key, 1);
        }
    }
}
