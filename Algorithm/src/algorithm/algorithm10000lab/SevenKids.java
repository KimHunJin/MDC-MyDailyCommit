package algorithm.algorithm10000lab;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by HunJin on 2017-07-15.
 */
public class SevenKids {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] value = new int[9];
        for(int i=0;i<value.length;i++) {
            value[i] = Integer.parseInt(sc.nextLine());
        }

        for (int i = 0; i < 3; i++) {
            for (int j = i+1; j < 4; j++) {
                for (int k = j+1; k < 5; k++) {
                    for (int z = k+1; z < 6; z++) {
                        for (int t = z+1; t < 7; t++) {
                            for (int p = t+1; p < 8; p++) {
                                for (int q = p+1; q < 9; q++) {
                                    if(value[i]+value[j]+value[k]+value[z]+value[t]+value[p]+value[q] == 100) {
                                        int[] result = new int[7];
                                        result[0] = value[i];
                                        result[1] = value[j];
                                        result[2] = value[k];
                                        result[3] = value[z];
                                        result[4] = value[t];
                                        result[5] = value[p];
                                        result[6] = value[q];
                                        Arrays.sort(result);
                                        for(int m : result) {
                                            System.out.println(m);
                                        }
                                        return;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
