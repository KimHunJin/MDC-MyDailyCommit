import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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

        int right = 0, bottom = -1, top = 1;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());

        int[][] falinux = new int[size][size];

        int input = size;
        int count = 1;

        for(int i=input;i>=0;i--) {
            for(int j=0;j<input;j++) {
                bottom = bottom + top;
                falinux[right][bottom] = count;
                count++;
            }
            input--;
            for(int j=0;j<input;j++) {
                right = right+top;
                falinux[right][bottom] = count;
                count++;
            }
            top = top * (-1);
        }

        print(falinux);
    }

    void print(int[][] faliux) {
        for (int[] ints : faliux) {
            for (int anInt : ints) {
                System.out.print(anInt+"\t");
            }
            System.out.println();
        }
    }
}
