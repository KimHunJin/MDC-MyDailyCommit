/**
 * Created by HunJin on 2016-09-06.
 */
public class DFS {

    int range = 5;

    int[][] graph = new int[range][range];
    boolean[] visit = new boolean[range]; // if visit them true else then false

    public static void main(String[] args) {

        DFS dfs = new DFS();
        dfs.init();

    }

    void init() {
        graph[0][0] = 1;
        graph[range-1][range-1] = 1;

        makeGraph();

        print();
    }

    /**
     * this method is making graph
     * just right and up down because if has left then so many root
     * start is 0,0
     * end is range-1, range-1
     */
    void makeGraph() {
        int x =0, y=0;
        int random;

        while (x!=range-1 || y!=range-1) {
            random = (int)(Math.random()*4);
            if(random==0 && x<range-1) {
                x++;
            } else if(random==1 && y<range-1) {
                y++;
            } else if(random==2 && x>0) {
                x--;
            }
            graph[x][y] = 1;
        }
    }

    /**
     * dfs algorithm
     *
     */
    void dfs () {
        
    }

    /**
     * print method
     */
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
