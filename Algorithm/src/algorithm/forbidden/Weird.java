package algorithm.forbidden;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by HunJin on 2016-11-26.
 */
public class Weird {
    public static void main(String[] args) throws IOException {
        Weird w = new Weird();
//        w.sum();
//        w.testCase();
        w.numberTest();

    }

    void numberTest() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine(), 10);
        int sum = 0;
        for (int i = 1; i <= number / 2; i++) {
            if (number % i == 0) {
                System.out.println(i);
                sum += i;
            }
        }
        System.out.println(sum);
    }

    void testCase() throws IOException {
        int loops = 10000;
        for (int loop = 0; loop < loops; loop++) {
            int number = loop + 1;
            if (number % 2 != 0 || number % 6 == 0 || number % 20 == 0 || number % 30 == 0) {
                System.out.println("not weird");
            } else {
                int sum = 0;
                for (int i = 2; i <= number / 2; i++) {
                    if (number % i == 0) {
                        sum += i;
                    }
                }
                if (sum > number) {
                    int result = sum - number;
                    int minus = 0;
                    if (number % result == 0) {
                        System.out.println("not weird");
                    } else {
                        for (int i = result; i > 0; i--) {
                            if (number % i == 0) {
                                minus += i;
                            }
                        }
                        int value = minus - result;
                        if (value >= 0) {
                            System.out.println("not weird");
                        } else {
                            System.out.println(number + " : result weird");
                        }
                    }
                } else {
                    System.out.println("not weird");
                }
            }
        }
    }

    void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int loops = Integer.parseInt(br.readLine(), 10);
        for (int loop = 0; loop < loops; loop++) {
            int number = Integer.parseInt(br.readLine(), 10);
            if (number % 2 != 0 || number % 6 == 0 || number % 20 == 0 || number % 30 == 0) {
                System.out.println("not weird");
            } else {
                int sum = 0;
                for (int i = 1; i <= number / 2; i++) {
                    if (number % i == 0) {
                        sum += i;
                    }
                }
                if (sum > number) {
                    int result = sum - number;
                    int minus = 0;
                    if (number % result == 0) {
                        System.out.println("not weird");
                    } else {
                        for (int i = result; i > 0; i--) {
                            if (number % i == 0) {
                                minus += i;
                            }
                        }
                        int value = minus - result;
                        if (value >= 0) {
                            System.out.println("not weird");
                        } else {
                            System.out.println("weird");
                        }
                    }
                } else {
                    System.out.println("not weird");
                }
            }
        }
    }
}
