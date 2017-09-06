package algorithm.codewar;

/**
 * Created by HunJin on 2017-08-10.
 */
public class Encryption {
    public static void main(String[] args) {
        String test = "This is a test!";
        String en = encrypt(test,1);
        System.out.println(en);
        String de = decrypt(en,1);
        System.out.println(de);
    }

    public static String encrypt(final String text, final int n) {
        String original = text;
        String s = "";
        for (int loop = 0; loop < n; loop++) {
            s = "";
            for(int i=1;i<original.length();i+=2) {
                s+=original.charAt(i);
            }
            for(int i=0;i<original.length();i+=2) {
                s+=original.charAt(i);
            }
            original = s;
        }
        return original;
    }

    public static String decrypt(final String encryptedText, final int n) {
        String original = encryptedText;
        String s = "";
        for(int loop=0;loop<n;loop++) {
            s = "";
            for(int i=0, j=(encryptedText.length()/2); j<original.length();i++, j++) {
                s += original.charAt(j);
                if(i<original.length()/2) {
                    s += original.charAt(i);
                }
            }
            original = s;
        }
        return s;
    }
}
