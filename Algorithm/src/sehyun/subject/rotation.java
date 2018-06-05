package sehyun.subject;

/**
 * Created by HunJin on 2016-10-16.
 */
public class rotation {
    public static void main(String[] args) {
        String[][] a = {
            {"*","*"," "," "," "},
            {"*","*"," "," "," "},
            {"*","*","*","*","*"},
            {"*","*","*","*","*"}
        };

        String[][] b = new String[a[0].length][a.length];

        //1,1 -> 1.4
        //4,1 -> 5,1

        for(int i=0;i<a.length;i++) {
            for(int j=0;j<a[i].length;j++) {
                b[j][i] = a[a.length-i-1][j];
            }
            System.out.println();
        }

        System.out.println();
        System.out.println();

        for(int i=0;i<b.length;i++) {
            for(int j=0;j<b[i].length;j++) {
                System.out.print(b[i][j]);
            }
            System.out.println();
        }
    }
}
