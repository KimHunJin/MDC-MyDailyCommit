import java.util.Arrays;

/**
 * Created by HunJin on 2016-09-14.
 *
 * 순열을 구하는 프로그램
 *
 * input : 1 2 3 4
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

        perm(allNum,number,0,4,4);
        Arrays.sort(allNum);
        print(allNum);

    }


    /**
     * 출력문
     * @param str
     */
    void print(String[] str) {
        for (String s : str) {
            System.out.println(s);
        }
    }

    /**
     *
     * @param str  // 4개의 통합된 수를 저장할 배열
     * @param arr  // 4개의 수
     * @param depth  // 시작할 깊이
     * @param n  // 반복할 개수
     * @param k  // k와 같아진다면 배열 str에 추가
     */
    void perm(String[] str, int[] arr, int depth, int n, int k) {

        // 깊이가 k와 같아진다는건 한 싸이클을 돌았다는 것
        if(depth == k ) {
            addNum(str,arr, count);
            count++;
            return;
        }

        //
        for(int i = depth;i<n;i++) {
            swap(arr, i, depth);
            perm(str, arr, depth + 1, n, k); // 재귀적으로 반복
            swap(arr, i, depth);
        }
    }

    // 숫자 교체
    void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    // str에 숫자 저장
    void addNum(String[] str, int[] arr, int count) {
        str[count] = "" + arr[0] + arr[1] + arr[2] + arr[3];
    }
}


