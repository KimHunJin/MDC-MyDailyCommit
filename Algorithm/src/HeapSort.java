/**
 * Created by HunJin on 2016-09-27.
 *
 * HeapSort
 * 가장 끝의 노드를 루트로 가져와 값을 비교해가며 제자리를 맞춰가는 정렬방법
 *
 */
public class HeapSort {
    public static void main(String[] args) {
        new HeapSort().solve();
    }

    void solve() {
        int[] arr = new int[(int)(Math.random()*10)+1];
        for(int i=0;i<arr.length;i++) {
            arr[i] = (int)(Math.random()*100)+1;
        }
        System.out.println("Before");
        print(arr);
        System.out.println();
        arr = heapSort(arr);
        System.out.println("After");
        print(arr);
    }

    void print(int[] arr) {
        for(int i : arr) {
            System.out.print(i + " ");
        }
    }

    int[] heapSort(int[] arr) {
        int len = arr.length;
        for(int k=len/2;k>0;k--) {
            downHeap(arr, k, len);
        }

        do {
            int tmp = arr[0];
            arr[0] = arr[len-1];
            arr[len-1] = tmp;
            len--;
            downHeap(arr, 1, len);
        } while (len>1);

        return arr;
    }

    void downHeap(int[] arr, int k, int len) {
        int j,tmp = arr[k-1];
        while (k<=len/2) {
            j = 2*k;
            if((j<len)&& (arr[j-1] < arr[j])) j++;
            if(tmp >= arr[j-1]) break;

            arr[k-1] = arr[j-1];
            k = j;
        }
        arr[k-1] = tmp;
    }

}
