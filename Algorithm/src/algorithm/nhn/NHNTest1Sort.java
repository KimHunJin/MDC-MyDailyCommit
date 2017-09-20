package algorithm.nhn;

import java.util.Scanner;

public class NHNTest1Sort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        int[] m = new int[s.length];

        for(int i=0;i<s.length;i++) {
            m[i] = Integer.parseInt(s[i]);
            if(m[i] < 10) {
                m[i] = m[i] * 10 + m[i];
            }
        }

        for(int i=0;i<s.length-1;i++) {
            for(int j=i;j<s.length;j++) {
                if(m[i] > m[j]) {
                    int temp = m[i];
                    m[i] = m[j];
                    m[j] = temp;
                    String st = s[i];
                    s[i] = s[j];
                    s[j] = st;
                }
            }
        }

        String min = "";
        String max = "";
        for(int i=0;i<s.length;i++) {
            min += s[i];
            max += s[s.length-1-i];
        }

        long maxL = Long.parseLong(max);
        long minL = Long.parseLong(min);

        long result = maxL + minL;
        System.out.println(result);
    }
}
