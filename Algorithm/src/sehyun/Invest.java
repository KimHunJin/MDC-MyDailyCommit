package sehyun;

/**
 * Created by HunJin on 2016-11-29.
 */
public class Invest {

    private static final int MAX = 10000;

    private static final float GRAPH[][] = {
            {2.219f, 0.764f, 1.026f, 1.131f, 1.085f},
            {0.764f, 1.363f, 0.719f, 0.878f, 0.722f},
            {1.026f, 0.719f, 1.955f, 1.147f, 0.761f},
            {1.131f, 0.878f, 1.147f, 2.515f, 0.710f},
            {1.085f, 0.722f, 0.761f, 0.710f, 2.775f}
    };

    private static final float[] investValue = {
            1.603f,
            1.420f,
            1.323f,
            0.869f,
            2.206f
    };

    private static float[] results = new float[MAX];
    private static float[] investsResult = new float[MAX];
    private static String[] invests = new String[MAX];


    private float[][] numbers = new float[MAX][5];

    public static void main(String[] args) {
        new Invest().solve();
    }

    void solve() {
        init();
        input();
        acc();
//        print();
        output();
    }

    void acc() {

        for (int k = 0; k < numbers.length; k++) {
            float[] sum = new float[5];
            for (int i = 0; i < GRAPH.length; i++) {
                for (int j = 0; j < GRAPH[i].length; j++) {
//                    System.out.println(numbers[1][j] + " * " + GRAPH[j][i]);
                    sum[i] += numbers[k][j] * GRAPH[j][i];
                }

//                System.out.printf("%.3f ", sum[i]);
            }

//            System.out.println();

            for(int i=0;i<investValue.length-1;i++) {
                invests[k] += numbers[k][i] + "*" + investValue[i] + " + ";
                investsResult[k] += numbers[k][i] * investValue[i];
            }
            invests[k] += numbers[k][4] + "*" + investValue[4];
            investsResult[k] += numbers[k][4] * investValue[4];

            float result = 0;
            for (int i = 0; i < numbers[k].length; i++) {
                result += numbers[k][i] * sum[i];
            }

            results[k] = result;
        }
    }

    void init() {
        numbers[0][0] = 0.05f;
        numbers[0][1] = 0.25f;
        numbers[0][2] = 0.05f;
        numbers[0][3] = 0.25f;
        numbers[0][4] = 0.40f;

        for(int i=0;i<invests.length;i++) {
            invests[i] = "";
        }
    }

    void input() {
        for (int i = 1; i < numbers.length; i++) {
            int v = 10;
            for (int j = 0; j < numbers[i].length - 1; j++) {
                int k = (int) (Math.random() * v);
                numbers[i][j] = (float) k / 10;
                v = v - k;
            }
            numbers[i][4] = (float) v / 10;
        }
    }

    void print() {
        for(int i=0;i<numbers.length;i++) {
//            for (int j=0;j<numbers[i].length;j++) {
//                System.out.printf("%.2f ",numbers[i][j]);
//            }
//            System.out.println();
            System.out.printf("result : %.3f\n",results[i]);
//            System.out.printf("sqrt : %.3f\n",Math.sqrt(results[i]));
//            System.out.println(invests[i]);
            System.out.printf("investValue : %.3f\n", investsResult[i]);
//            System.out.println();
        }
    }

    void output() {
        System.out.println("result\tvalue");
        for(int i=0;i<numbers.length;i++) {
            System.out.printf("%.3f\t",results[i]);
            System.out.printf("%.3f\n",investsResult[i]);
        }
    }
}
