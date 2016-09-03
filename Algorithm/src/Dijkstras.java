/**
 * Created by HunJin on 2016-09-03.
 */
public class Dijkstras {

    int MAX = 1000; // 거리의 최대치
    int GRAPH_XY = 5; // 그래프 행렬

    int[][] graph = new int[GRAPH_XY][GRAPH_XY];
    int dist[] = new int[GRAPH_XY];
    boolean visit[] = new boolean[GRAPH_XY];



    public static void main(String[] args) {

        Dijkstras dijkstras = new Dijkstras();
        dijkstras.init();
    }

    void init() {
        for(int i=0;i<GRAPH_XY;i++) {
            dist[i] = MAX;
            visit[i] = false;
        }

        graph[0][1] = 2;
        graph[0][2] = 4;
        graph[1][2] = 1;
        graph[3][4] = 5;
        graph[2][3] = 3;
        graph[2][4] = 8;

        dijkstra(0,4);

    }

    void dijkstra(int start, int end) {

        dist[start] = 0;

        for(int i=0;i<GRAPH_XY;i++) {
            int min = MAX;
            int index = -1;
            for(int j=0;j<GRAPH_XY;j++) {
                if(visit[j]==false && min > dist[j]) {
                    min = dist[j];
                    index = j;
                }
            }
            visit[index] = true;

            for(int j=0;j<GRAPH_XY;j++) {
                if(graph[index][j] != 0 && dist[j] > dist[index]+graph[index][j]) {
                    dist[j] = dist[index] + graph[index][j];
                }
            }
        }

        for(int i=0;i<GRAPH_XY;i++) {
            System.out.print(dist[i] + " ");
        }

        System.out.println();

    }
}
