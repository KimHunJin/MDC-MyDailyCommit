package algorithm.hackerrank;

import java.math.BigInteger;

public class BigIntegerFactorial100 {
    public static void main(String[] args) {
        int n = 100;

        BigInteger bigInteger = new BigInteger(String.valueOf(n));

        for (int i = 99; i >= 1; i--) {
            bigInteger = bigInteger.multiply(new BigInteger(String.valueOf(i)));
        }

        System.out.println(bigInteger);


    }
}
