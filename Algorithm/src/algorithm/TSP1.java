package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by HunJin on 2016-12-16.
 */
public class TSP1 {
    public static void main(String[] args) {
        new TSP1().solve();
    }

    void solve() {

        try {
            int loops = Integer.parseInt(br.readLine(), 10);

            while (loops-- > 0) {
                int size = Integer.parseInt(br.readLine(), 10);
                double[][] arr = init(size);
                int[] d = new int[size-1];
                for(int i=0;i<d.length;i++) {
                    d[i] = i+1;
                }
                double max = Double.MAX_VALUE;
                do {
                    boolean ok = true;
                    double sum = 0;
                    for(int i=0;i<size-2;i++) {
                        if(arr[d[i]][d[i+1]]== 0) {
                            ok = false;
                        } else {
                            sum += arr[d[i]][d[i+1]];
                        }
                    }
                    if(ok && arr[0][d[0]] != 0 && arr[d[size-2]][0] != 0) {
                        sum += arr[0][d[0]] + arr[d[size-2]][0];
                        if (max > sum) {
                            max = sum;
                        }
                    }
                } while (next_permutation(d));
                System.out.println(max);
            }

        } catch (IOException ie) {
            ie.printStackTrace();
        }
    }

    public static boolean next_permutation(int[] a) {
        int i = a.length-1;
        while (i > 0 && a[i-1] >= a[i]) {
            i -= 1;
        }

        // 마지막 순열
        if (i <= 0) {
            return false;
        }

        int j = a.length-1;
        while (a[j] <= a[i-1]) {
            j -= 1;
        }

        int temp = a[i-1];
        a[i-1] = a[j];
        a[j] = temp;

        j = a.length-1;
        while (i < j) {
            temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i += 1;
            j -= 1;
        }
        return true;
    }

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    double[][] init(int size) throws IOException {

        double[][] arr;

        arr = new double[size][size];

        for (int i = 0; i < size; i++) {
            String s = br.readLine();
            StringTokenizer st = new StringTokenizer(s, " ");
            for (int j = 0; j < size; j++) {
                arr[i][j] = Double.parseDouble(st.nextToken());
            }
        }

        return arr;
    }
}
