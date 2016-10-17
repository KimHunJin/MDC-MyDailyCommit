package sehyun;

/**
 * Created by HunJin on 2016-10-14.
 */
public class ForWhile {
    public static void main(String[] args) {
        int count = 0;
        int sum = 0;
        int i = 1;
        int dump;
        boolean check = false;
        while (true) {
            count++;
            if(check==false) {
                dump = i;
                check = true;
            } else {
                dump = i * (-1);
                check = false;
            }

            sum+=dump;
            if(sum>100) {
                break;
            }
            i++;
        }
        System.out.println(count);
    }
}
