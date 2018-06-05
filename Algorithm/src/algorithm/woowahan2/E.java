package algorithm.woowahan2;

public class E {

    public static void main(String[] args) {
        int[] a = {6, 1, 4, 6, 5, 6, 7, 4};
        int k = 4;
        int l = 4;
        System.out.println(new E().solution(a, k, l));
    }

    public int solution(int[] A, int K, int L) {
        // write your code in Java SE 8

        int size = A.length;

        if (size < K + L) {
            return -1;
        }

        int[] alice = makeArray(K, A);
        int[] bob = makeArray(L, A);


        int max = -1;
        for (int i = 0; i < size; i++) {
            int sum = alice[i];
            for (int j = 0; j < size; j++) {
                if (j <= i - K || j >= i + L) {
                    max = max > sum + bob[j] ? max : sum + bob[j];
                }
            }
        }

        return max;

    }

    private int[] makeArray(int k, int[] a) {
        int[] tmp = new int[a.length];
        for (int i = k - 1; i < a.length; i++) {
            int sum = 0;
            for (int j = i; j > i - k; j--) {
                sum += a[j];
            }
            tmp[i] = sum;
        }
        return tmp;
    }
}
