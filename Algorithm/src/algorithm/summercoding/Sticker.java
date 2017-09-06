package algorithm.summercoding;

/**
 * Created by HunJin on 2017-05-20.
 */
public class Sticker {
    public static void main(String[] args) {
        int[] sticker = {1,2,3};
        new Sticker().solution(sticker);
    }

    int solution(int[] sticker) {
        int answer = 0;
        if(sticker.length>2) {
            int[] dis = new int[sticker.length + 1];

            dis[1] = sticker[0];  // 1


            for (int i = 2; i <= sticker.length - 1; i++) {
                dis[i] = dis[i - 2];  // 0
                dis[i] = Math.max(dis[i - 1], dis[i] + sticker[i - 1]);  // 1, 0+3
//            System.out.println(dis[i]);
                answer = dis[i];
            }

            int[] b = new int[sticker.length + 1];
            b[1] = 0; // 3
            b[2] = sticker[1];
            for (int i = 3; i <= sticker.length; i++) {
                b[i] = b[i - 2]; // 0
                b[i] = Math.max(b[i - 1], b[i] + sticker[i - 1]);  // 3, 0+3
                answer = Math.max(answer, b[i]);
            }


        } else {
            if(sticker.length>1) {
                answer = Math.max(sticker[0], sticker[1]);
            } else {
                answer = sticker[0];
            }
        }


        System.out.println(answer);

        return 0;
    }


    void test(int[] sticker) {

        int[] dis = new int[sticker.length+1];
        int[] dis2 = new int[sticker.length+1];

        dis[1] = sticker[0];
        dis2[1] = sticker[1];

        for(int i=2;i<sticker.length-1;i++) {
            dis[i] = dis[i-2];
            dis[i] = Math.max(dis[i],dis[i-2]+sticker[i]);
//            dis2[i] = dis2[i-2];
//            dis2[i] = Math.max(dis2[i],dis2[i-2]+sticker[i]);
        }

//        int k = sticker.length-1;
//        dis2[k] = dis2[k-2];
//        dis2[k] = Math.max(dis2[k],dis2[k-2]+sticker[k]);

        int answer = dis[1];
        for(int i=2;i<dis.length;i++) {
            answer = Math.max(answer,dis[i]);
            answer = Math.max(answer,dis2[i]);
        }

//        for(int i=0;i<dis.length;i++) {
//            System.out.print(dis[i] + " ");
//        }

//        System.out.println();

        dis[1] = sticker[1];

        for(int i=2;i<sticker.length;i++) {
            dis[i] = dis[i-2];
            dis[i] = Math.max(dis[i],dis[i-2]+sticker[i]);
        }

        for(int i=2;i<dis.length;i++) {
            answer = Math.max(answer,dis[i]);
        }

//        for(int i=0;i<dis.length;i++) {
//            System.out.print(dis[i]+ " ");
//        }
//        System.out.println();

        System.out.println(answer);

    }
}
