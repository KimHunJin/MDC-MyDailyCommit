package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by HunJin on 2017-04-10.
 */
public class FailnuxFormRefactoying {
    public static void main(String[] args) throws IOException {
        new algorithm.FalinuxForm().solve();
    }

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int right = 0, bottom = -1, top = 1;

    void solve() throws IOException {

        int size = Integer.parseInt(br.readLine());

        int input = size;

        int[][] falinux = makeForm(input, size);

        print(falinux);
    }

    int[][] makeForm(int input, int size) {
        int[][] falinux = new int[size][size];
        int count = 1;
        for (int i = input; i >= 0; i--) {
            for (int j = 0; j < input; j++) {
                bottom = bottom + top;
                falinux[right][bottom] = count;
                count++;
            }
            input--;
            for (int j = 0; j < input; j++) {
                right = right + top;
                falinux[right][bottom] = count;
                count++;
            }
            top = top * (-1);
        }
        return falinux;
    }

    /**
     * 출력문
     *
     * @param faliux
     */
    void print(int[][] faliux) {
        for (int[] ints : faliux) {
            for (int anInt : ints) {
                System.out.print(anInt + "\t");
            }
            System.out.println();
        }
    }
}
