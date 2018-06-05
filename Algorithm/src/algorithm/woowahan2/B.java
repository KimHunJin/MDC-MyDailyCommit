package algorithm.woowahan2;

import java.util.HashMap;
import java.util.Map;

public class B {
    public static void main(String[] args) {
//        new B().solution();
    }

    private Map<Character, Integer> map;

    public int solution(String A, String B) {
        // write your code in Java SE 8

        map = new HashMap();
        int result = 0;
        int size = A.length();

        init();

        for(int i=0;i<size;i++) {
            char ac = A.charAt(i);
            char bc = B.charAt(i);

            if(map.get(ac) > map.get(bc)) {
                result++;
            }
        }
        return result;
    }

    private void init() {
        map.put('A',14);
        map.put('K',13);
        map.put('Q',12);
        map.put('J',11);
        map.put('T',10);
        for(int i=9;i>=2;i--) {
            map.put((char) ('0' + i), i);
        }
    }
}
