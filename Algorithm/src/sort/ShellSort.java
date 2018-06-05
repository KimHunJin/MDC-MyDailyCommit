package sort;

public class ShellSort {
    public static void main(String[] args) {
        new ShellSort().solve();
    }

    private void solve() {
        int[] arr = { 69, 10, 30, 2, 16, 8, 31, 22 };

        shellSort(arr);
    }

    private void intervalSort(int[] arr, int begin, int end, int interval) {
        int item = 0;
        int j = 0;
        for (int i = begin + interval; i <= end; i = i + interval) {
            item = arr[i];
            for (j = i - interval; j >= begin && item < arr[j]; j -= interval)
                arr[j + interval] = arr[j];
            arr[j + interval] = item;
        }
    }

    private void shellSort(int[] arr) {
        int interval = 0;
        int t = 1;
        int arrSize = arr.length;

        interval = arrSize / 2;

        while (interval >= 1) {
            for (int i = 0; i < interval; i++) {
                intervalSort(arr, i, arrSize - 1, interval);
                System.out.println("셸 정렬 " + t++ + " 단계:  interval => " + interval);

                interval /= 2;
            }
        }
    }
}
