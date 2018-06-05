package algorithm.algorithm10000lab;

import java.util.*;

public class Virus {

    private static boolean[] isCheck;

    private static Map<Integer, Set<Integer>> map = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int pair = sc.nextInt();

        isCheck = new boolean[n + 1];

        isCheck[1] = true;
        for (int i = 0; i < pair; i++) {
            int first = sc.nextInt();
            int second = sc.nextInt();
            if (map.containsKey(first)) {
                map.get(first).add(second);
            } else {
                Set<Integer> list = new HashSet<>();
                list.add(second);
                map.put(first, list);
            }
            if (map.containsKey(second)) {
                map.get(second).add(first);
            } else {
                Set<Integer> list = new HashSet<>();
                list.add(first);
                map.put(second, list);
            }
        }

        if (map.containsKey(1)) {
            for (int i : map.get(1)) {
                dfs(i);
            }
        }
        int count = 0;
        for (int i = 0; i < isCheck.length; i++) {
            if (i != 1) {
                if (isCheck[i]) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    private static void dfs(int n) {
        isCheck[n] = true;
        if (map.containsKey(n)) {
            for (int k : map.get(n)) {
                if (isCheck[k]) {
                    continue;
                }
                dfs(k);
            }
        }
    }
}
