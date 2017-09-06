package algorithm.summercoding;

import java.util.ArrayList;

/**
 * Created by HunJin on 2017-05-20.
 */
public class Station {
    public static void main(String[] args) {
        int[] arr = {9};
        System.out.println(new Station().solution(16,arr,2));
    }

    public int solution(int n, int[] station, int w) {


        int count = 0;
        int div = w*2+1;
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=1;i<station.length;i++) {
            int max = station[i]-w-1;
            int min = station[i-1]+w+1;
            arr.add(max-min+1);
        }

        arr.add(station[0]-w-1-1+1);
        arr.add(n-station[station.length-1]+w+1);



        return 0;
    }



    void asdf(int n, int[] station, int w) {
        int[] stations = new int[station.length+1];
        for(int i=1;i<stations.length;i++) {
            stations[i] = station[i-1];
        }

        for(int i=0;i<station.length;i++) {
            System.out.println("before : " + station[i] + " after : " + stations[i+1]);
        }

        ArrayList<Integer> arr = new ArrayList();
        int count = 0;
        int div = w*2+1;

        if(stations.length>1) {
            for(int i=1;i<stations.length;i++) {
                int max = stations[i]-w-1;
                int min = stations[i-1]+w+1;
                arr.add(max-min);
            }

            for(int i=0;i<arr.size();i++) {
                int value = arr.get(i);
                if(value>1) {
                    if (value % div > 0) {
                        count += value / div + 1;
                    } else {
                        count += value / div;
                    }
                }
            }

            int value = stations[0]-w;
            if(value-0>1) {
                if (value % div > 0) {
                    count += value / div + 1;
                } else {
                    count += value / div;
                }
            }

            value = stations[stations.length-1]+w;
            if(n-value>0) {
                if (value % div > 0) {
                    count += value / div + 1;
                } else {
                    count += value / div;
                }
            }
        } else {
            int value = stations[0]-w;
            if(value-0>1) {
                if (value % div > 0) {
                    count += value / div + 1;
                } else {
                    count += value / div;
                }
            }

            value = stations[stations.length-1]+w;
            if(n-value>0) {
                value = n - value;
                if (value % div > 0) {
                    count += value / div + 1;
                } else {
                    count += value / div;
                }
            }
        }

    }
}
