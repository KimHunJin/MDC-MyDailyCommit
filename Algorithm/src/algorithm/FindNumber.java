package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by HunJin on 2016-12-24.
 * <p>
 * 숫자 n과 d를 입력받아 1부터 숫자 n 까지 숫자 d가 몇 번 나오는지 숫자를 세는 프로그램 입니다.
 * 숫자를 문자열로 바꿔 비교를 하였습니다.
 * 인풋 값으로 숫자 n과 숫자 d가 들어옵니다.
 * 출력 값으로 숫자 d가 나온 횟수가 출력됩니다.
 *
 * example
 * input
 * 10000
 * 8
 *
 * output
 * 4000
 */
public class FindNumber {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        new FindNumber().solve();
    }

    /**
     * 숫자 n과 숫자 d를 입력 받습니다.
     * 만약 찾고자 하는 수가 9보다 클 경우 다시 반복합니다.
     * 찾고자 하는 수를 문자열로 바꾸어 substing과 equals로 비교합니다.
     * 수를 찾을 때 마다 카운터 값을 1씩 증가시킵니다.
     *
     * @throws IOException
     */
    void solve() throws IOException {
        System.out.print("숫자 N을 입력해 주세요 : ");
        int lastNumber = number();
        System.out.print("숫자 D를 입력해 주세요 : ");
        int findNumber = number();
        if (findNumber > 9) {
            while (findNumber > 9) {
                System.out.print("범위를 초과했습니다. 다시 입력해주세요 : ");
                findNumber = number();
            }
        }
        long count = 0;
        String find = findNumber + "";
        for (int i = 1; i <= lastNumber; i++) {
            String s = i + "";
            for (int j = 0; j < s.length(); j++) {
                if ((s.substring(j, j + 1)).equals(find)) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    int number() throws IOException {
        return Integer.parseInt(br.readLine(), 10);
    }
}
