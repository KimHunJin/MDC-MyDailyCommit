/**
 * Created by HunJin on 2016-09-04.
 */
public class InsertSort {

    int[] arr = new int[10];

    public static void main(String[] args) {
        InsertSort insertSort = new InsertSort();
        insertSort.init();
    }

    // 배열 초기화 (랜덤으로 숫자 생성)
    void init() {
        for(int i=0;i<arr.length;i++) {
            arr[i] = (int)(Math.random()*100)+1;
        }
        insertSort();
    }

    // 삽입정렬 (낮은 수부터 정렬)
    void insertSort() {
        for(int index=1;index<arr.length;index++) { // index를 1부터 시작하는 이유 = 처음 수는 비교할 필요가 없기 때문
            int tmp = arr[index]; // 임시 저장 값으로 tmp 사용, 현재 인덱스의 값을 저장
            int aux = index-1; // 처음 값 부터 비교를 위함 (index가 1이기 때문에 처음 수와 비교를 해야함)
            while ((aux>=0)&&(arr[aux]>tmp)) { // aux의 값이 0 이상이고, 저장된 배열의 aux 번지 값이 임시 저장 값 보다 크면 반복
                arr[aux+1] = arr[aux]; // 현재 aux에 저장된 값을 aux+1로 옮기고 (aux가 적어도 tmp 보다 크기 때문)
                aux--; // aux를 감소시켜 반복
            }
            arr[aux+1] = tmp; // 반복문에 들어가지 않았을 때는 현재 배열의 값이 이전 인덱스보다 크다는것을 의미하기에 바로 저장
            // 반복문에 들어갔다면 반복문을 빠져나온 경우가 감소된 aux를 인덱스로 가지는
            // arr[aux]의 값보다 크거나 0번지 인덱스보다 작다는것을 의미하므로 aux를 1 증가시켜 저장
        }

        print();
    }

    // 출력문
    void print() {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
