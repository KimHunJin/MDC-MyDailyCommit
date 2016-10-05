package sort;

/**
 * Created by HunJin on 2016-09-05.
 */
public class SelectSort {
    int arr[] = new int[10];
    public static void main(String[] args) {
        SelectSort selectSort = new SelectSort();
        selectSort.init();
    }

    // 배열 초기화
    void init() {
        for(int i=0;i<arr.length;i++) {
            arr[i] = (int)(Math.random()*100)+1;
        }
        selectSort();
    }

    /**
     * 배열의 탐색하여 가장 작은 수를 맨 앞으로 빼는 정렬법
     */
    void selectSort() {
        int tmp; // 임시 저장 변수
        int min; // 최소 값
        for(int index = 0;index<arr.length;index++) {
            int address = index; // 처음 시작 주소 지정
            min = arr[index];
            for(int aux = index;aux<arr.length;aux++) {
                if(min>arr[aux]) { // 가장 작은 수의 값과 주소 저장
                    min = arr[aux];
                    address = aux;
                }
            }
            // 현재 인덱스 번호의 값과 교환
            tmp = arr[index];
            arr[index] = min;
            arr[address] = tmp;
        }
        print();
    }

    // 출력문문
   void print() {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
