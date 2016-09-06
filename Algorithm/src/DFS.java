/**
 * Created by HunJin on 2016-09-06.
 */
public class DFS {

    int range = 10;

    int[][] graph = new int[range][range];
    int[] visit = new int[range];

    public static void main(String[] args) {

        DFS dfs = new DFS();
        dfs.init();

    }

    void init() {
        for(int i=0;i<range;i++) {
            for(int j=0;j<range;j++) {
                graph[i][j] = (int)(Math.random()*2);
            }
        }
        print();
    }

    void dfs () {

    }

    void print() {
        for (int[] ints : graph) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

}
