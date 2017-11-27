package algorithm.forbidden;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by HunJin on 2016-12-24.
 *
 * 긴 문자열 중 원하는 단어 혹은 문자를 찾는 프로그램 입니다.
 * 인풋 값으로 긴 문자열인 haystack이 들어가고, 찾고자 하는 무자인 needle이 들어갑니다.
 * 출력 값으로 인덱스를 반환합니다.
 *
 * example
 *
 * input
 * 가나다라마바사아자차카타파하ABCDEFGHIJKLMNOPQRSTUVWXYZ
 * 마바
 *
 * output
 * 인덱스는 0부터 시작합니다.
 * 마바 은(는) 인덱스 4부터 인덱스 5 까지 입니다.
 */
public class FindSubstring {

    public static void main(String[] args) throws IOException {
        new FindSubstring().solve();
    }

    /**
     * 찾은 글자의 위치를 반환하는 메서드 입니다.
     * 하나의 글자만을 비교하여 만약 그 글자가 같을 경우 다음 글자들을 비교하게 됩니다.
     * 모든 문자열을 다 비교했을 때에 비해서 한 글자만을 비교하기에
     * 메모리 사용을 조금 줄일 수 있습니다.
     *
     * @param haystack 긴 문자열 입니다.
     * @param needle   찾고자 하는 문자입니다.
     * @return 찾은 문자열의 시작 위치를 반환 합니다.
     */
    long findSubstring(String haystack, String needle) {
        char firstChar = needle.charAt(0);
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            if (haystack.charAt(i) == firstChar) {
                if (haystack.substring(i, i + needle.length()).equals(needle)) {
                    return i;
                }
            }
        }
        return -1;
    }

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    /**
     * 반환 받은 시작위치부터 글자의 길이를 더하여 출력합니다.
     * 인덱스는 0부터 시작하게 됩니다.
     *
     * @throws IOException
     */
    void solve() throws IOException {
        String needle = readString();
        String haystack = readString();

        long index = findSubstring(needle, haystack);
        if (index < 0) {
            System.out.println("no word");
        } else {
            System.out.println("인덱스는 0부터 시작합니다.");
            System.out.println(haystack + " 은(는) 인덱스 " + index + " 부터 인덱스 " +
                    (index + haystack.length() - 1) + " 까지 입니다.");
        }
    }

    String readString() throws IOException {
        return br.readLine();
    }
}
