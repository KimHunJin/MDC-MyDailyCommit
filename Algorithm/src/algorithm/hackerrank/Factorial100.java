package algorithm.hackerrank;

import java.util.Scanner;

public class Factorial100 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine(),10);
        long diveNum = 100000000000000L;
        long[] s = new long[100];
        int count = 1;
        s[0] = 1;
        for (int i = 1; i <= n; i++) {
            for(int j=0;j<count;j++) {
                s[j] = s[j] * i;
            }
            for(int j=0;j<count;j++) {
                if(s[count-1] > diveNum) {
                    s[j+1] += s[j] / diveNum;
                    s[j] = s[j] % diveNum;
                    count++;
                }
                if(s[j] > diveNum) {
                    s[j+1] += s[j] / diveNum;
                    s[j] = s[j] % diveNum;
                }
            }
        }
        String result = "";
        for (int i = count - 1; i >= 0; i--) {
            if (s[i] > 0) {
                if(s[i] < diveNum/10 && i!=count-1) {
                    int divC = String.valueOf(diveNum/10).length();
                    int vv = String.valueOf(s[i]).length();
                    for(int k=vv; k<divC;k++) {
                        result+="0";
                    }
                    result += s[i];
                } else {
                    result += s[i];
                }
            } else {
                result += String.valueOf(diveNum).substring(1);
            }
        }
        System.out.println(result);

        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    }
}
