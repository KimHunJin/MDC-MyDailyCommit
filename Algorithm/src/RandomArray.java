/**
 * Created by HunJin on 2016-09-26.
 */
public class RandomArray {
    public static void main(String[] args) {
        int number = (int)(Math.random() * 10)+1;
        int[] arr = new int[number]; // random size array

        new RandomArray().makingArr(arr);
    }

    /**
     * making random value
     * @param arr
     */
    void makingArr(int[] arr) {
        for(int i=0;i<arr.length;i++) {
            arr[i] = (int)(Math.random()*10)+1; // random value in array
        }
    }
}
