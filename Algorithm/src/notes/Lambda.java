package notes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Lambda {


    public long nlcm(long[] num) {
        return Arrays.stream(num).reduce((x, y) ->
                (long) Math.floor((x * y) / get_gcd(x, y))).getAsLong();
    }

    public long get_gcd(long x, long y) {
        long temp;
        do {
            temp = x % y;
            x = y;
            y = temp;
        } while (y > 0);
        return x;
    }

    int[][] test() {
        int board[][] = null;
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

        } catch (IOException ie) {
            ie.printStackTrace();
        }
        return board;
    }

    public static void main(String[] args) {
        Lambda c = new Lambda();
        long[] ex = {31, 52, 90, 70, 15, 73, 95, 51, 64, 78};

        // 아래는 테스트로 출력해 보기 위한 코드입니다.
        System.out.println(c.nlcm(ex));
    }
}
