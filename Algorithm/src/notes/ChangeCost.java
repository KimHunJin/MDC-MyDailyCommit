package notes;

/**
 * Created by HunJin on 2016-10-19.
 */
public class ChangeCost {
    public static void main(String[] args) {
        String a = changCost(500);
        System.out.println(a);
    }

    public static String changCost(int cost) {
        String number = cost + "";
        String dump = "";
        String cNumber = "";
        for (int i = number.length() - 1; i >= 0; i--) {
            dump += number.charAt(i);
        }
        for (int i = 0; i < dump.length(); i += 3) {
            if (i + 3 < dump.length()) {
                cNumber += dump.substring(i, i + 3) + ",";
            } else {
                cNumber += dump.substring(i, dump.length());
            }
        }
        number = "";
        for (int i = cNumber.length() - 1; i >= 0; i--) {
            number += cNumber.charAt(i);
        }
        return number;
    }
}

