package datastructure;

/**
 * Created by HunJin on 2016-09-27.
 *
 * this class is making heap.
 *
 */
public class Heap {

    int[] arr;

    public Heap(int[] arr) {
        this.arr = arr;
    }

    /**
     * 루트노드를 만들고 -> 왼쪽부터 큰 수로 만들고 오른쪽으로 반복
     * @param i
     */
    public void max_Heapify(int i) {

        if (arr == null || arr.length < 1)
            return;

        int leftChild = i * 2;
        int rightChild = leftChild + 1;
        int largest;

        if (leftChild < arr.length && arr[leftChild] > arr[i])
            largest = leftChild;
        else
            largest = i;

        if (rightChild < arr.length && arr[rightChild] > arr[largest])
            largest = rightChild;

        if (largest != i) {
            swap(i, largest);
            max_Heapify(largest);
        }
    }

    public void buildMaxHeap() {

        // 만약 arr 값이 없거나 1보다 작음 리턴
        if (arr == null || arr.length < 1)
            return;

        // 배열의 사이즈/2 부터 반복 시작
        for (int i = arr.length / 2; i > 0; i--) {
            max_Heapify(i);
        }
    }

    /**
     * swap 메서드
     * @param i
     * @param j
     */
    private void swap(int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    /**
     * 출력문
     */
    public void printArr() {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(" " + arr[i]);
            if (i == 0 || i == 1 || i == 3 || i == 7) {
                System.out.println();
            }
        }
    }

    public static void main(String args[]) {

        int[] arr = { 0, 16, 42, 15, 14, 67, 39, 13, 92, 18 };

        Heap heap = new Heap(arr);

        System.out.println("before");
        heap.printArr();

        System.out.println();

        heap.buildMaxHeap();
        System.out.println("After");
        heap.printArr();

        System.out.println();
        System.out.println();

    }
}
