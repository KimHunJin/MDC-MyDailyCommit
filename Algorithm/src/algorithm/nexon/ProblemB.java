package algorithm.nexon;

import java.io.IOException;
import java.util.Scanner;

public class ProblemB {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
//        final String fileName = System.getenv("OUTPUT_PATH");
//        BufferedWriter bw = null;
//        if (fileName != null) {
//            bw = new BufferedWriter(new FileWriter(fileName));
//        } else {
//            bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        }


        int res;
        String[] g_nodesm = in.nextLine().split(" ");
        int g_nodes = Integer.parseInt(g_nodesm[0]);
        int g_edges = Integer.parseInt(g_nodesm[1]);


        int[] g_from = new int[g_edges];
        int[] g_to = new int[g_edges];

        for (int g_i = 0; g_i < g_edges; g_i++) {
            String[] g_fromv = in.nextLine().split(" ");
            g_from[g_i] = Integer.parseInt(g_fromv[0]);
            g_to[g_i] = Integer.parseInt(g_fromv[1]);
        }

        res = maximumDifference(g_nodes, g_from, g_to);
        System.out.println(res);
    }

    public static int maximumDifference(int g_nodes, int[] g_from, int[] g_to) {
        int[] result = new int[g_nodes + 1];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < g_to.length; i++) {
            int value = g_to[i] - g_from[i];
            int originalMax = result[g_to[i]];
            int afterMax = result[g_from[i]] + value;
            result[g_to[i]] = Math.max(originalMax, afterMax);
            if(max < result[g_to[i]]) {
                max = result[g_to[i]];
            }
        }
        return max;
    }

    public static int maximumDf(int g_nodes, int[] g_from, int[] g_go) {

        int[][] nodes = new int[g_nodes + 1][g_nodes + 1];
        for (int i = 0; i < g_from.length; i++) {
            nodes[g_from[i]][g_go[i]] = 1;
        }

        int max = Integer.MIN_VALUE;
        int result = Integer.MIN_VALUE;
        for (int i = 1; i < nodes.length; i++) {
            for (int j = 1; j < nodes.length; j++) {
                if (nodes[i][j] == 1) {
                    int min = i;
                    max = Math.max(max, findMax(j, nodes));
                    int value = max - min;
                    result = Math.max(value, result);
                }
            }
        }
        return result;
    }

    static int findMax(int start, int[][] nodes) {
        int max = start;
        for (int j = 1; j < nodes[start].length; j++) {
            if (nodes[start][j] == 1) {
                return findMax(j, nodes);
            }
        }
        return max;
    }
}
