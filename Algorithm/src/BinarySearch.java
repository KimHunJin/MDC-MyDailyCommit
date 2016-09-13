/**
 * Created by HunJin on 2016-09-13.
 */
public class BinarySearch {

    int[] number = new int[100];

    public static void main(String[] args) {
        new BinarySearch().solve();
    }

    void solve() {
        init();
        sort();
        System.out.println(binarySearch((int) (Math.random() * 100) + 1));
    }

    void init() {
        for(int i=0;i<number.length;i++) {
            number[i] = (int)(Math.random()*100)+1;
        }
    }

    int tmp;
    void sort() {
        for(int i=0;i<number.length;i++) {
            for(int j=0;j<number.length;j++) {
                if(number[i]<number[j]) {
                    tmp = number[i];
                    number[i] = number[j];
                    number[j] = tmp;
                }
            }
        }
    }

    int binarySearch(int findNum) {
        int fIndex = 0;
        int lIndex = number.length;
        int count = 0;
        int mid;
        while (fIndex<=lIndex) {
            mid = (fIndex + lIndex) / 2;
            if(findNum == number[mid]) {
                System.out.println("number : " + number[mid]);
                System.out.println("count : " + count);
                return number[mid];
            } else {
                if(findNum > number[mid]) {
                    System.out.println("찾고자 하는 수 > " + number[mid]);
                    fIndex = mid+1;
                    count++;
                } else {
                    System.out.println("찾고자 하는 수 < " + number[mid]);
                    lIndex = mid-1;
                    count++;
                }
            }
        }
        return -1;
    }
}
