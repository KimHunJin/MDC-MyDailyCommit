package algorithm.midaschallange;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by HunJin on 2017-05-12.
 */
public class TelephonePole {
    public static void main(String[] args) {
        new TelephonePole().solve();
    }

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    void solve() {
        try {
            int loop = Integer.parseInt(br.readLine());
            int[] distance = new int[loop-1];
            int beforePole = Integer.parseInt(br.readLine());
            int min = 100000000;
            for(int i=1;i<loop;i++) {
                int pole = Integer.parseInt(br.readLine());
                int dis = pole - beforePole;
                if(dis<min) {
                    min = dis;
                }
                distance[i-1] = dis;
                beforePole = pole;
            }

            int count = 0;

            for(int i=0;i<distance.length;i++) {
                if(distance[i] > min) {
                    count += (distance[i] / min -1);
                }
            }
            System.out.println(count);

        } catch (IOException ie) {
            ie.printStackTrace();
        }
    }
}
