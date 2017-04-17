package algorithm;

import java.util.ArrayList;

/**
 * Created by HunJin on 2017-04-09.
 */
public class RemoveWord {
    public static void main(String[] args) {
        String s = "aaaaaaaaaa";
        int count = s.length();


        test3(s, count);


//        System.out.println(s);

//        if (s.length() > 0) {
//            System.out.println(0);
//        } else {
//            System.out.println(1);
//        }
    }

    static void test3(String s, int c) {
        ArrayList<Integer> start = new ArrayList();
        ArrayList<Integer> end = new ArrayList();

        if (s.length() > 1) {
            for (int i = 0; i < s.length() - 1; i++) {
                char k = s.charAt(i);
                if (k == s.charAt(i + 1)) {
                    start.add(i);
                    if (i + 2 < s.length()) {
                        for (int j = i + 2; j < s.length(); j++) {
                            if (k != s.charAt(j) || j == s.length() - 1) {
                                if (j == s.length() - 1) {
                                    end.add(j);
                                } else {
                                    end.add(j - 1);
                                    i = j - 1;
                                }
                                break;
                            }
                        }
                    } else {
                        end.add(i + 1);
                    }
                }
            }
        }

//        System.out.println(s.substring(start.get(0),end.get(0)+1));

        ArrayList<String> arr = new ArrayList<>();

        for (int i = 0; i < start.size(); i++) {
            arr.add(s.substring(start.get(i), end.get(i) + 1));
        }

        for (int i = 0; i < arr.size(); i++) {
            s = s.replace(arr.get(i), "");
        }

        if (s.length() != c) {
            test3(s, s.length());
        } else {
            if (s.length() > 0) {
                System.out.println(0);
            } else {
                System.out.println(1);
            }
        }
    }


    static void test1(String s) {
        if (s.length() > 1) {
            for (int i = 0; i < s.length() - 1; i++) {
                char k = s.charAt(i);
                if (k == s.charAt(i + 1)) {
                    s = s.substring(i + 2, s.length());
                    i = 0;
                }
            }
        }


        System.out.println(s);

        if (s.length() > 0) {
            System.out.println(0);
        } else {
            if (s.length() > 0) {
                System.out.println(0);
            } else {
                System.out.println(1);
            }
        }

    }


    static void test2(String s) {
        if (s.length() > 1) {
            for (int i = 0; i < s.length() - 1; i++) {
                char k = s.charAt(i);
                if (k == s.charAt(i + 1)) {
                    if (i + 2 < s.length()) {
                        for (int j = i + 2; j < s.length(); j++) {
                            if (k != s.charAt(j) || j == s.length() - 1) {
                                if (s.length() - 1 == j) {
                                    s = s.substring(j + 1, s.length());
                                } else {
                                    s = s.substring(j, s.length());
                                }
                                break;
                            }
                        }
                    } else {
                        s = s.substring(i + 2, s.length());
                    }
                    i = 0;
                }
            }
        }

        if (s.length() > 0) {
            System.out.println(0);
        } else {
            System.out.println(1);
        }
    }
}
