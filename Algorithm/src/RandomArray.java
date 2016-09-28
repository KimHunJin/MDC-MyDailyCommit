/**
 * Created by HunJin on 2016-09-26.
 */
public class RandomArray {
    public static void main(String[] args) {

        new RandomArray().makingArr();
    }

    /**
     * making random value
     * @param
     */
    public int[] makingArr() {
        int number = (int)(Math.random() * 10)+1;
        int[] arr = new int[number];
        for(int i=0;i<arr.length;i++) {
            arr[i] = (int)(Math.random()*10)+1; // random value in array
        }
        return arr;
    }
}
