package algorithm;

import java.io.IOException;

/**
 * Created by HunJin on 2016-09-24.
 *
 * 01 02 03 04
 * 12 13 14 05
 * 11 16 15 06
 * 10 09 08 07
 */
public class FalinuxForm {
    public static void main(String[] args) throws IOException{
        new FalinuxForm().solve();
    }

    void solve() throws IOException{

        int right = 0, bottom = -1, top = 1; // 시작지점의 오른쪽 값은 0, 바텀값은 -1 (없음), 탑 값음 1

//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int size = Integer.parseInt(br.readLine());
        int size = 3;

        int[][] falinux = new int[size][size];

        int input = size;
        int count = 1;

        for(int i=input;i>=0;i--) {
            for(int j=0;j<input;j++) {
                bottom = bottom + top;  // top이 0이나 -1로 바뀌면서 바텀값이 증가하거나 감소
                falinux[right][bottom] = count;
                count++;
            }
            input--; // 점점 줄어들면서 반복 진행
            for(int j=0;j<input;j++) {
                right = right+top;  // top이 스위칭이 되면서 right가 증가하거나 감소
                falinux[right][bottom] = count;
                count++;
            }
            top = top * (-1); // 스위칭
        }
        print(falinux);
    }

    /**
     * 출력문
     * @param faliux
     */
    void print(int[][] faliux) {
        for (int[] ints : faliux) {
            for (int anInt : ints) {
                System.out.print(anInt+"\t");
            }
            System.out.println();
        }
    }
}
