package algorithm.line;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RunLength {
    public static void main(String[] args) throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int T = Integer.parseInt(br.readLine().trim());

            for (int i = 0; i < T; ++i) {
                String word = br.readLine().trim();
                char before = 0x00;
                int count =1;
                String result =  "";
                for(int j=0;j<word.length();j++) {
                    if(before == 0x00) {
                        before = word.charAt(j);
                    } else {
                        if(before == word.charAt(j)) {
                            count++;
                        } else {
                            result += count + "" +  before;
                            before = word.charAt(j);
                            count = 1;
                        }
                    }
                }
                result += count + "" + before;
                System.out.println(result);
            }
        }
    }
}
