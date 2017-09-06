package algorithm.codewar;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by HunJin on 2017-08-11.
 */
public class WhichAreIn {
    public static void main(String[] args) {
        String[] a = {"arp", "live", "strong"};
        String[] a1 = {"live","arp", "strong"};
        String[] b = {"lively", "alive", "harp", "sharp", "armstrong"};
        String[] c = {"trap", "mice", "bull"};
        String[] d = {"1010", "111", "11234", "1234"};
        String[] f = {"111", "1010", "1", "123"};

        String[] arr = inArray(a1, b);
        for (String s : arr) {
            System.out.println(s);
        }


    }

    public static String[] inArray(String[] array1, String[] array2) {
        Set<String> arr = new LinkedHashSet<>();
        for (String s : array1) {
            for (String t : array2) {
                if (isCheck(s, t)) {
                    arr.add(s);
                    break;
                }
            }
        }

        String[] s = arr.toArray(new String[arr.size()]);
        Arrays.sort(s);

        return s;
    }

    public static boolean isCheck(String s, String t) {
        for (int i = 0; i <= t.length() - s.length(); i++) {
            if (s.equals(t.substring(i, i + s.length()))) {
                return true;
            }
        }
        return false;
    }
}
