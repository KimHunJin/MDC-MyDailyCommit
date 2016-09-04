/**
 * Created by HunJin on 2016-09-04.
 */
public class BubbleSort {

    int[] randomArray = new int[10];

    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.init();
    }

    // 정렬하고자 하는 배열 값 선언
    void init() {
        for (int i=0;i<randomArray.length;i++) {
            randomArray[i] = (int)(Math.random()*100)+1;
        }
        sort();
    }

    // 정렬문
    void sort() {
        int tmp; // 임시 저장 변수
        for(int i=0;i<randomArray.length;i++) {
            for(int j=i;j<randomArray.length;j++) {  // 이미 확정된 값을 다시 비교하지 않기 위해 시작 위치를 i로 함
                if(randomArray[i]>randomArray[j]) {  // 앞에서 부터 하나씩 맞춰나감 (작은 수 부터)
                    tmp = randomArray[i];
                    randomArray[i] = randomArray[j];
                    randomArray[j] = tmp;
                }
            }
        }
        print();
    }

    // 출력문
    void print() {
        for(int i : randomArray) {
            System.out.println(i);
        }
    }
}
