package sort;

/**
 * Created by HunJin on 2016-09-15.
 *
 * sort.QuickSort
 */
public class QuickSort {
    public static void main(String[] args) {
        new QuickSort().solve();
    }

    void solve() {
        int[] arr = init();
        System.out.print("before sort : ");
        print(arr);

        quickSort(arr,0,arr.length-1);

        System.out.print("after sort : ");
        print(arr);
    }

    /**
     * 배열 초기화 (크기 1~10 랜덤, 수 1~100 랜덤)
     * @return
     */
    int[] init() {
        int number = (int)(Math.random()*10)+1;
        int[] arr = new int[number];
        for(int i=0;i<arr.length;i++) {
            arr[i] = (int)(Math.random()*100)+1;
        }
        return arr;
    }

    /**
     * 분할
     * @param arr  // 수가 저장된 배열
     * @param left  // 피벗을 기준으로 왼쪽
     * @param right  // 피벗을 기준으로 오른쪽
     * @return
     */
    int partition(int[] arr, int left, int right) {

        int i = left; int j = right;  // 첫 시작은 i = 0, right = arr.length-1
        int tmp;  // 임시 변수
        int pivot = arr[(left+right)/2];  // 피벗 값

        while (i<=j) {

            // 피벗보다 값이 클 경우의 i번지 인덱스를 기억
            while (arr[i]<pivot) {  // 피벗보다 값이 작으면 i 값 증가
                i++;
            }

            // 피벗보다 작을 경우의 j번지 인덱스를 기억
            while (arr[j]>pivot) {  // 피벗보다 값이 크면 j 값 감소
                j--;
            }

            // i번지의 값과 j번지의 값 교환 (i는 피벗보다 값이 크고, j는 피벗보다 값이 작기 때문)
            if(i<=j) {
                tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
                j--;
            }
        }
        System.out.println(j);
        return i;  // 기준이 되는 수로 이 수를 기준으로 왼쪽은 이하, 오른쪽은 이상으로 나뉨.
    }

    /**
     *
     * @param arr  // 수가 저장된 배열
     * @param left  // index를 기준으로 왼쪽
     * @param right  // index를 기준으로 오른쪽
     */
    void quickSort(int[] arr, int left, int right) {
        int index = partition(arr,left,right); // 이 수를 기준으로 왼쪽은 이 인덱스의 값보다 작거나 같고 오른쪽은 크거나 같음
        if(left < index-1) {
            quickSort(arr, left, index - 1);  // 작은 수들을 다시 재정렬
        }
        if(index < right) {
            quickSort(arr, index, right);  // 큰 수들을 다시 재정렬
        }
    }

    /**
     * 출력문
     * @param arr  // 값이 저장된 배열
     */
    void print(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
