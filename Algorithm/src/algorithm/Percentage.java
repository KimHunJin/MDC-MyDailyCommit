package algorithm;

public class Percentage {
    public static void main(String[] args) {


        double[] solveF = {0.8178, 0.7347, 0.4526, 0.2679, 0,4184, 0.4801, 0.1799};



        // java c python js ios
        double[] solveA = {0.43, 0.36, 0.11, 0.08, 0.007};
        double[] solveB = {0.11, 0.25, 0.24, 0.09, 0.2};
        double[] solveC = {0.35, 0.14, 0.42, 0.04, 0.02};

        double v = 0;
        for(int i=0;i<solveA.length;i++) {
            v += solveA[i] * solveB[i] * solveC[i];
        }

        System.out.println(166/v);
    }
}
