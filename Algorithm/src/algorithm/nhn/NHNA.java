package algorithm.nhn;

import java.util.Scanner;

public class NHNA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] line = sc.nextLine().split(" ");

        String secretKey = line[1];
        String word = line[3];
        int lotation = Integer.parseInt(line[2]);

        String changeWord = "";
        if(line[0].equals("encrypt")) {
            // 암호화
            for(int i=0;i<word.length();i++) {
                int changeValue = ((word.charAt(i)-97) + (secretKey.charAt(i)-97)) % 26;
                changeWord += (char)(changeValue + 97);
            }

            if(lotation > 0) {
                String m = changeWord.substring(0,lotation);
                String result = changeWord.substring(lotation, changeWord.length()) + m;
                System.out.println(result);
            } else if(lotation < 0) {
                String m = changeWord.substring(changeWord.length()-lotation, changeWord.length());
                String result = m + changeWord.substring(0,changeWord.length()-lotation);
                System.out.println(result);
            } else {
                System.out.println(changeWord);
            }

        } else if(line[0].equals("decrypt")) {
            // 복호화
            String result;
            if(lotation < 0) {
                String m = word.substring(0,lotation);
                result = word.substring(lotation, word.length()) + m;
            } else if(lotation > 0) {
                String m = word.substring(word.length()-lotation, word.length());
                result = m + word.substring(0,word.length()-lotation);
            } else {
                result = word;
            }
            for(int i=0;i<result.length();i++) {
                int changeValue = (((result.charAt(i)-97) ) - ((secretKey.charAt(i)-97)) + 26) % 26;
                changeWord += (char)(changeValue + 97);
            }
            System.out.println(changeWord);
        }
    }
}
