package algorithm.line;

import java.util.Scanner;

public class StringMatch {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String[][] tc = new String[n][2];
        for (int i = 0; i < n; i++) {
            tc[i] = sc.nextLine().split(" ");
        }

        for (int i = 0; i < n; i++) {
            String s = match(tc[i][0], tc[i][1]) == true ? "O" : "X";
            System.out.println(s);
        }

    }

    private static boolean match(String a, String b) {

        return false;
    }

    private static boolean match2(String a, String b) {
        boolean isLoop = false;
        boolean isAll = false;
        boolean isResult = false;
        int b_length = 0;
        int b_last = b.length();
        if (a.equals(b)) {
            return true;
        }
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == '*') {
                isLoop = true;
                isResult = true;
            } else if (a.charAt(i) == '?') {
                isAll = true;
                isResult = true;
            } else {
                if (isLoop && isAll) {
                    isLoop = false;
                    isAll = false;
                    if (a.charAt(i) == b.charAt(b_length)) {
                        isResult = true;
                        b_length++;
                    } else {
                        isResult = false;
                    }
                } else if (isLoop) {
                    if(b_length >= b_last) {
                        isResult = true;
                    } else {
                        while (true) {
                            if (a.charAt(i) != b.charAt(b_length)) {
                                isResult = true;
                                break;
                            } else {
                                b_length++;
                                if (a.length() - 1 == i) {
                                    isResult = true;
                                    break;
                                }
                                if (b_length >= b_last) {
                                    isResult = false;
                                    break;
                                }
                            }
                        }
                    }
                    isLoop = false;
                } else if (isAll) {
                    b_length++;
                    isAll = false;
                    if(a.charAt(i) == b.charAt(b_length)) {
                        isResult = true;
                    } else {
                        isResult = false;
                    }
                } else if (a.charAt(i) == b.charAt(b_length)) {
                    b_length++;
                    isResult = true;
                } else {
                    isResult = false;
                }
            }
            if (!isResult) {
                break;
            }
        }
        if (isLoop && isAll) {
            return true;
        }
        return isResult;
    }
}
