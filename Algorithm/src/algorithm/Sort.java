package algorithm;

import java.sql.Time;
import java.util.Arrays;
import java.util.Timer;

/**
 * Created by HunJin on 2016-11-18.
 */
public class Sort {
    public static void main(String[] args) {

        int[] A = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30};
        int[] B = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30};
        int[] c = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30};

//        int[] A = new int[100000];
//        int[] B = new int[100000];
//        int[] c = new int[100000];
//
//        int k = 0;
//        for (int i = 0; i < 100000; i++) {
////            int k = (int)(Math.random()*10000000)+1;
//            k++;
//            A[i] = k;
//            B[i] = k;
//            c[i] = k;
//        }

//        suffle();

        double timeA = System.currentTimeMillis();
        System.out.println(new Sort().solution(A));
        double timeB = System.currentTimeMillis();

        System.out.println(timeA + " : " + timeB);

        double time = timeB - timeA;
        System.out.println("first : " + time);


        timeA = System.currentTimeMillis();
        System.out.println(new Sort().solutionC(B));
        timeB = System.currentTimeMillis();

        System.out.println(timeA + " : " + timeB);

        time = timeB - timeA;
        System.out.println("second : " + time);


        timeA = System.currentTimeMillis();
        System.out.println(new Sort().solutionC(c));
        timeB = System.currentTimeMillis();

        System.out.println(timeA + " : " + timeB);

        time = timeB - timeA;
        System.out.println("third : " + time);

    }

    void suffle(int A[], int[] B, int[] c) {
        int dump = (int) (Math.random() * A.length);
        int dump2 = (int) (Math.random() * A.length);
        int tmp = 0;
        tmp = A[dump];
        A[dump] = A[dump2];
        A[dump2] = tmp;

        tmp = B[dump];
        B[dump] = B[dump2];
        B[dump2] = tmp;

        tmp = c[dump];
        c[dump] = c[dump2];
        c[dump2] = tmp;

        dump = (int) (Math.random() * A.length);
        dump2 = (int) (Math.random() * A.length);
        tmp = 0;

        tmp = A[dump];
        A[dump] = A[dump2];
        A[dump2] = tmp;

        tmp = B[dump];
        B[dump] = B[dump2];
        B[dump2] = tmp;

        tmp = c[dump];
        c[dump] = c[dump2];
        c[dump2] = tmp;

    }

    public boolean solution(int[] A) {
        // write your code in Java SE 8
        int tmp = 0;
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] > A[i + 1]) {
                tmp = i;
                break;
            }
        }
        for (int i = A.length - 1; i >= 0; i--) {
            if (A[i] < A[tmp]) {
                int dump = A[i];
                A[i] = A[tmp];
                A[tmp] = dump;
                break;
            }
        }

        boolean result = true;
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] > A[i + 1]) {
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
        for (int i = 0; i < B.length; i++) {
            B[i] = A[i];
        }
        Arrays.sort(B);

        for (int i = 0; i < A.length; i++) {
            if (A[i] != B[i]) {
                count++;
                if (count > 2) {
                    result = false;
                    break;
                }
            }
        }

        return result;
    }

    public boolean solutionC(int[] A) {
        int max = A[0], maxIndex = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] > max) {
                max = A[i];
                maxIndex = i;
            }
        }

        for (int j = 0; j < maxIndex; j++) {
            if (A[j] > max) {
                return false;
            }
        }

        for (int j = maxIndex + 1; j < A.length - 1; j++) {
            if (!(max > A[j] && A[j + 1] < A[j])) {
                return false;
            }
        }
        return true;
    }
}
