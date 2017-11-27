package algorithm.midas_first;

import java.util.Scanner;

public class ProblemB {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int loop = Integer.parseInt(sc.nextLine(), 10);

        for (int i = 0; i < loop; i++) {
            String s = sc.nextLine();
            int center = 0;
            int count = 0;
            if (s.length() % 2 == 0) {
                center = s.length() / 2;
                center = center - 1;

                for (int j = 0; j <= center; j++) {
                    if (s.charAt(s.length() - 1 - j) != s.charAt(j)) {
                        int right = s.charAt(s.length() - 1 - j);
                        int left = s.charAt(j);

                        if (right > left) {
                            while (right > left) {
                                right--;
                                count++;
                            }
                        } else {
                            while (left > right) {
                                left--;
                                count++;
                            }
                        }
                    }
                }
            } else {
                center = (s.length() / 2) + 1;
                center = center - 1;
                for (int j = 0; j < center; j++) {
                    if (s.charAt(j) != s.charAt(s.length() - 1 - j)) {
                        int right = s.charAt(s.length() - 1 - j);
                        int left = s.charAt(j);

                        if (right > left) {
                            while (right > left) {
                                right--;
                                count++;
                            }
                        } else {
                            while (left > right) {
                                left--;
                                count++;
                            }
                        }
                    }
                }
            }
            System.out.println(count);
        }
    }

}

