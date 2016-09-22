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

    /**
     * 100개의 배열에 랜덤으로 수를 저장한다.
     */
    void init() {
        for(int i=0;i<number.length;i++) {
            number[i] = (int)(Math.random()*100)+1;
        }
    }


    /**
     * 수들을 정렬한다.
     */
    void sort() {
        int tmp;
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

    /**
     * 수의 중간을 기점으로 반복하여 검색
     * 수를 찾는데 걸리는 횟수와 찾은 수를 출력.
     * @param findNum
     * @return 찾은 수
     */
    int binarySearch(int findNum) {
        int fIndex = 0; // 초기값은 0
        int lIndex = number.length; // 초기 값은 배열의 크기
        int count = 0; // 횟수
        int mid; // 중앙값

        // fIndex와 lIndex가 같거나 값을 찾을때까지 반복
        while (fIndex<=lIndex) {
            mid = (fIndex + lIndex) / 2;
            // 찾았으면 리턴.
            if(findNum == number[mid]) {
                System.out.println("number : " + number[mid]);
                System.out.println("count : " + count);
                return number[mid];
            } else {
                // 찾고자 하는 수가 중앙값보다 더 크면 findIndex의 값을 중앙값에 1 증가후 반복 아니면 1 감소후 반복
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
        return -1; // 수가 없으면 -1 리턴
    }
}
