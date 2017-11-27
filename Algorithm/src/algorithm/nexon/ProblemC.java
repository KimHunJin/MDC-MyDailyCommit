package algorithm.nexon;

import java.util.HashSet;

public class ProblemC {
    public static void main(String[] args) {
        System.out.println(substringCalculator("kincenvizh"));
    }

    /*
 * Complete the function below.
 */
    static long substringCalculator2(String s) {

//        List<String> list = new ArrayList<>();

        HashSet<String> set = new HashSet<>();

        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = s.length() - i; j > 0; j--) {
                String subS = s.substring(i, i + j);
                if (set.contains(subS)) {
                    break;
                } else {
                    if (subS.length() < s.length() / 2) {
                        set.add(subS);
                    }
                    count++;
                }
            }
        }
        return count;
    }

    static long substringCalculator(String s) {

//        List<String> list = new ArrayList<>();

        HashSet<String> set = new HashSet<>();

        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            String ss = s.substring(i);
            String c = String.valueOf(ss.charAt(0));

            if (set.contains(ss)) {
                continue;
            } else {
                set.add(ss);

            }

            if (set.contains(c)) {
                int j = 1;
                while (set.contains(c) && j < ss.length()) {
                    set.add(String.valueOf(ss.substring(0, j)));
                    j++;
                }
                count += j;
            } else {
                set.add(c);
                count += ss.length();
            }
        }
        return count;
    }
}
