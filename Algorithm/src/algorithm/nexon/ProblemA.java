package algorithm.nexon;

import java.util.*;

public class ProblemA {
    public static void main(String[] args) {

        int[] testCase = {5, 3, 7, 10, 14};
        int[] s = solution2(testCase);
        for(int v : s ) {
            System.out.println(v);
        }
    }

    private static int[] solution2(int[] elements) {
        Arrays.sort(elements);

        List<Number> list = new ArrayList<>();

        int[] result = new int[elements.length];

        for (int i = 0; i < elements.length; i++) {
            Number number = new Number();
            number.k = elements[i];
            number.v = countNumberOne(elements[i]);
            list.add(number);
        }

        Collections.sort(list, comparator);

        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i).k;
        }

        return result;
    }

    static Comparator<Number> comparator = new Comparator<Number>() {
        @Override
        public int compare(Number o1, Number o2) {
            if (o1.v > o2.v) {
                return 1;
            } else if (o1.v < o2.v) {
                return -1;
            } else {
                return 0;
            }
        }
    };

    static class Number {
        public int k;
        public int v;
    }

    private static int[] solution(int[] elements) {
        Map<Integer, String> map = new HashMap<>();


        for (int number : elements) {
            int key = countNumberOne(number);
            if (map.containsKey(key)) {
                String value = map.get(key);
                value = value + " " + number;
                map.put(key, value);
            } else {
                map.put(key, String.valueOf(number));
            }
        }

        Set<Integer> elementsKey = map.keySet();
        int[] result = new int[elements.length];
        int count = 0;
        for (int key : elementsKey) {
            String value = map.get(key);
            String[] dump = value.split(" ");
            for (int i = 0; i < dump.length; i++) {
                result[count] = Integer.parseInt(dump[i]);
                count++;
            }
        }
        return result;
    }

    private static int countNumberOne(int n) {
        int count = 0;
        while (n > 1) {
            int a = n % 2;
            n = n / 2;
            if (a == 1) {
                count++;
            }
        }
        if (n == 1) {
            count++;
        }
        return count;
    }
}
