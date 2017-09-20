package algorithm.hackerrank;

import java.math.BigInteger;
import java.util.Scanner;

public class FibonacciModified {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int first = sc.nextInt();
        int second = sc.nextInt();
        int loop = sc.nextInt();
        BigInteger result = new BigInteger("0");
        BigInteger firstB = new BigInteger(String.valueOf(first));
        BigInteger secondB = new BigInteger(String.valueOf(second));
        for (int i = 2; i < loop; i++) {
            result = firstB.add(secondB.multiply(secondB));
            firstB = secondB;
            secondB = result;
        }

        System.out.println(result);
    }
}
