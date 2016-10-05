package algorithm;

import java.util.Arrays;

/**
 * Created by HunJin on 2016-09-14.
 *
 * 순열을 구하는 프로그램
 *
 * input  : 1 2 3 4
 * output : 1 2 3 4
 *          1 2 4 3
 *          1 3 2 4
 *          ...
 */
public class Permutation {
    int count; // 배열에 저장하기 위한 카운트

    public static void main(String[] args) {
        new Permutation().arr(1,2,3,4);
    }

    void arr(int A, int B, int C, int D) {

        int[] number = new int[4];
        String[] allNum = new String[24];
        count = 0;

        // 초기화
        number[0] = A;
        number[1] = B;
        number[2] = C;
        number[3] = D;

        perm(allNum,number,0,number.length,number.length);
        Arrays.sort(allNum);
        print(allNum);

    }

    /**
     * 출력문
     * @param str  // 출력할 배열
     */
    void print(String[] str) {
        for (String s : str) {
            System.out.println(s);
        }
    }

    /**
     * 재귀적으로 순열을 구함 (트리 구조)
     * @param str // 모든 경우의 수를 저장할 배열
     * @param arr // 수가 저장된 배열 (x,x,x,x)
     * @param depth // 현재 트리의 깊이
     * @param n // 배열안에 들어있는 총 개수
     * @param k // 순열의 자리 수
     */
    void perm(String[] str, int[] arr, int depth, int n, int k) {

        if(depth == k ) {  // 깊이가 최대 자리 수 까지 왔을 경우
            addNum(str,arr, count); // 수를 저장
            count++; // 수를 하나 저장할 때마다 카운트 증가
            return;
        }

        //
        for(int i = depth;i<n;i++) {
            swap(arr, i, depth);
            perm(str, arr, depth + 1, n, k); // 재귀적으로 반복
            swap(arr, i, depth);
        }
    }

    /**
     * 문맥 교환 메서드
     * i번째 인덱스의 값과 j번째 인덱스의 값 교환
     * @param arr  // 교환할 배열
     * @param i  // 교환하고자 하는 인덱스
     * @param j  // 교환하고자 하는 인덱스
     */
    void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    /**
     * 모든 경우의 수를 또 하나의 배열에 저장하기 위한 메서드
     * @param str  // 모든 경우의 수를 저장할 배열
     * @param arr  // n가지 수가 들어있는 배열 (x,x,x,x)
     * @param count // 모든 경우의 수를 저장할 위치
     */
    void addNum(String[] str, int[] arr, int count) {
        str[count] = "" + arr[0] + arr[1] + arr[2] + arr[3];
    }
}


