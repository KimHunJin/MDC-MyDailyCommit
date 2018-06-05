package algorithm.line;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class SNS {

    public static void main(String[] args) throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(br.readLine().trim());

            List<Set<Integer>> list = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                StringTokenizer tokens = new StringTokenizer(br.readLine().trim());
                int x = Integer.parseInt(tokens.nextToken());
                int y = Integer.parseInt(tokens.nextToken());

                if (list.size() > 0) {
                    boolean isBefore = false;
                    boolean isAfter = false;
                    int count = 0;
                    List<Integer> arr = new ArrayList<>();
                    for (int j = 0; j < list.size(); j++) {
                        if (list.get(j).contains(x) || list.get(j).contains(y)) {
                            count++;
                            arr.add(j);
                        }
                        if (count > 0) {
                            if (count > 1) {
                                // 합병
                                Set<Integer> set = new HashSet<>();
                                for (int k = 0; k < arr.size(); k++) {
                                    for(int s : list.get(arr.get(k))) {
                                        set.add(s);
                                    }
                                    list.remove(arr.get(k));
                                }
                                list.add(set);
                            } else {
                                // 추가
                                list.get(arr.get(0)).add(x);
                                list.get(arr.get(0)).add(y);
                            }
                        } else {
                            Set<Integer> set = new HashSet<>();
                            set.add(x);
                            set.add(y);
                            list.add(set);
                        }
                    }
                } else {
                    Set<Integer> set = new HashSet<>();
                    set.add(x);
                    set.add(y);
                    list.add(set);
                }
            }
            System.out.println(list.size());
        }
    }
}
