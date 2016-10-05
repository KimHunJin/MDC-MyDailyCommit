package sort;

/**
 * Created by HunJin on 2016-09-28.
 *
 * sort.ArraySort (custom sort)
 * using arr to sort
 *
 */
public class ArraySort {

    public static void main(String[] args) {

        new ArraySort().solve();
    }

    void solve() {
        int[] arr = new RandomArray().makingArr();
        int[] sort = new int[100];
        for (int i = 0; i < arr.length; i++) {
            sort[arr[i]]++;
        }
        System.out.println("Before");
        print(arr);
        System.out.println();
        System.out.println("After");
        arrSort(sort);
    }

    void print(int[] arr) {
        for (int i : arr) {
            System.out.printf(i+ " ");
        }
    }

    /**
     * loop arr[n].value;
     * because the number is duplication.
     * @param arr
     */
    void arrSort(int[] arr) {
        for(int i=0;i<arr.length;i++) {
            for(int j=0;j<arr[i];j++) {
                System.out.print(i+ " ");
            }
        }
    }
}
