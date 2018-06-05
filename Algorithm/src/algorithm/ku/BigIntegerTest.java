package algorithm.ku;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class BigIntegerTest {
    public static void main(String[] args) {


        BigInteger b = new BigInteger("10");

        Map<String, Integer> m = new HashMap<>();

        m.put(b.toString(), 1);

        System.out.println(m.containsKey(b.toString()));

    }
}
