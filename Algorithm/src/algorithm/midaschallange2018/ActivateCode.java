package algorithm.midaschallange2018;

import java.util.Scanner;

public class ActivateCode {
    public static void main(String[] args) {
        new ActivateCode().solve();
    }

    int min = Integer.MAX_VALUE;

    private void solve() {
        Scanner sc = new Scanner(System.in);
        long serial = sc.nextLong();
        int token = sc.nextInt();

        String serialNumber = Long.toBinaryString(serial);
        String tokenNumber = Integer.toBinaryString(token);

        int tokenSize = tokenNumber.length();
        int serialSize = serialNumber.length();

        for (int i = 0; i <= serialSize - tokenSize; i++) {
            String sub = serialNumber.substring(i, i + tokenSize);
            if (tokenNumber.equals(sub)) {
                String dmp = serialNumber.substring(0, i) + serialNumber.substring(i + tokenSize, serialSize);
                find(dmp, tokenNumber);
            }
        }

        System.out.println(min);
    }

    private void find(String word, String token) {
        for (int i = 0; i <= word.length() - token.length(); i++) {
            String sub = word.substring(i, i + token.length());
            if (token.equals(sub)) {
                String dmp = word.substring(0, i) + word.substring(i + token.length(), word.length());
                find(dmp, token);
            }
        }

        min = min < word.length() ? min : word.length();
    }
}
