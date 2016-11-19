package algorithm;

import java.sql.Time;
import java.util.Arrays;
import java.util.Timer;

/**
 * Created by HunJin on 2016-11-18.
 */
public class Sort {
    public static void main(String[] args) {

//        int[] A = {1,2,3,4,5,6,7,8,9,23,11,12,13,14,25,16,17,18,19,20,21,22,10,24,25,26,27,28,29,30};
//        int[] B = {1,2,3,4,5,6,7,8,9,23,11,12,13,14,25,16,17,18,19,20,21,22,10,24,25,26,27,28,29,30};

        int[] A = new int[100000];
        int[] B = new int[100000];

        int k = 0;
        for(int i=0;i<100000;i++) {
//            int k = (int)(Math.random()*10000000)+1;
            k++;
            A[i] = k;
            B[i] = k;
        }


        double timeA = System.currentTimeMillis();
        System.out.println(new Sort().solution(A));
        double timeB =System.currentTimeMillis();

        System.out.println(timeA + " : " + timeB);

        double time = timeB - timeA;
        System.out.println("first : " + time);


        timeA = System.currentTimeMillis();
        System.out.println(new Sort().solutionB(B));
        timeB = System.currentTimeMillis();

        System.out.println(timeA + " : " + timeB);

        time = timeB - timeA;
        System.out.println("second : " + time);

    }

    public boolean solution(int[] A) {
        // write your code in Java SE 8
        int tmp = 0;
        for(int i=0;i<A.length-1;i++) {
            if(A[i]>A[i+1]) {
                tmp = i;
                break;
            }
        }
        for(int i=A.length-1;i>=0;i--) {
            if(A[i]<A[tmp]) {
                int dump = A[i];
                A[i] = A[tmp];
                A[tmp] = dump;
                break;
            }
        }

        boolean result = true;
        for(int i=0;i<A.length-1;i++) {
            if(A[i]>A[i+1]) {
                result = false;
                break;
            }
        }
        return result;
    }

    public boolean solutionB(int[] A) {

        int[] B = new int[A.length];
        int count = 0;
        boolean result = true;
        for(int i=0;i<B.length;i++) {
            B[i] = A[i];
        }
        Arrays.sort(B);

        for(int i=0;i<A.length;i++) {
            if(A[i] != B[i]) {
                count++;
                if(count > 2) {
                    result = false;
                    break;
                }
            }
        }

        return result;
    }

}
