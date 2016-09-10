/**
 * Created by HunJin on 2016-09-06.
 */
public class DFS {

    int range = 5;

    int[][] graph = new int[range][range];
    boolean[][] visit = new boolean[range][range]; // if visit them true else then false
    int[] distance = new int[range];

    public static void main(String[] args) {

        DFS dfs = new DFS();
        dfs.init();

    }

    void init() {
        graph[0][0] = 1;
        graph[range-1][range-1] = 1;

        makingGraph();
//        makingMage();

        print();
    }

    /**
     * this method is making mage
     * just right up and down because if has left then so many root
     * start is 0,0
     * end is range-1, range-1
     */
    void makingMage() {
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
     * this method is making graph
     * the road is making to higher number for myself
     * for example
     * 1 is making 2 3 4 5
     * but, 3 is making 4 5
     * it's making range
     */
    void makingGraph() {
        for(int i=0;i<range;i++) {
            for(int j=i;j<range;j++) {
                if(i==j) {
                    graph[i][j] = 0;
                } else {
                    graph[i][j] = (int)(Math.random()*(2*range-i));
                }
            }
        }
    }

    /**
     * this method is similar by makingGraph()
     * but just making 0 and 1
     * have road or haven't road
     */
    void makingGraphZeroTwoOne() {
        for(int i=0;i<range;i++) {
            for(int j=i;j<range;j++) {
                if(i==j) {
                    graph[i][j] = 0;
                } else {
                    graph[i][j] = (int)(Math.random()*2);
                }
            }
        }
    }

    /**
     * dfs algorithm
     * find mage for shortest root
     */
    void dfs (int start, int end) {

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
