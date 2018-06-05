package sehyun.subject;

import java.util.Arrays;

/**
 * Created by HunJin on 2016-10-16.
 */
public class SortDesc {
    public static void main(String[] args) {
        int[] a = new int[10];

        System.out.println(a);

        int[] a2 = new int[10];

        System.out.println(a2);

        a2 = a;

        System.out.println(a2);
        for(int i=0;i<a.length;i++) {
            a[i] = i+1;
        }

        a2[5] = 100;

        for(int i=0;i<a.length;i++) {
            System.out.print(a[i]+ " ");
            System.out.println(a2[i]);
        }
    }
}
