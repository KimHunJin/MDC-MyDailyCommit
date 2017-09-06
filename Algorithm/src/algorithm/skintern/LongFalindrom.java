package algorithm.skintern;

/**
 * Created by HunJin on 2017-06-17.
 */
public class LongFalindrom {
    public static void main(String[] args) {
        new LongFalindrom().solution("000001123");
    }

    void solution(String s) {
        int[] number = new int[10];
        for(int i=0;i<s.length();i++) {
            int k = (int)s.charAt(i)-48;
            number[k]++;
        }
        int length = 0;
        int dump = 0;
        for(int i=0;i<number.length;i++) {
            while (number[i]>0) {
//                System.out.println(number[i]);
                if(number[i]%2==0 || number[i] > 1) {
                    length++;
                } else {
                    dump = 1;
                }
                number[i] -= 2;
            }
        }
        System.out.println((length*2)+dump);
    }
}
