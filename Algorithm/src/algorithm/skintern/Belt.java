package algorithm.skintern;

/**
 * Created by HunJin on 2017-06-17.
 */
public class Belt {
    public static void main(String[] args) {
        int[] truck = {2,7,4,9};
        int[] w = {7,6,8};
        new Belt().solve(truck, w);
    }

    void solve(int[] truck, int[] w) {
        int[] answer = new int[w.length];
        for (int i = 0; i < w.length; i++) {
            for (int j = 0; j < truck.length; j++) {
                if (truck[j] >= w[i]) {
                    answer[i] = j+1;
                    truck[j] -= w[i];
                    w[i] = -1;
                    break;
                }
            }
            if (w[i] > -1) {
                answer[i] = -1;
            }
        }

        for (int i : answer) {
            System.out.println(i);
        }
    }
}
