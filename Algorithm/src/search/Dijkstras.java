package search;

/**
 * Created by HunJin on 2016-09-03.
 */
public class Dijkstras {

    int MAX = 1000; // 거리의 최대치
    int GRAPH_XY = 5; // 그래프 행렬

    int[][] graph = new int[GRAPH_XY][GRAPH_XY];  // 그래프
    int dist[] = new int[GRAPH_XY];  // 거리
    boolean visit[] = new boolean[GRAPH_XY];  // 방문 유무

    public static void main(String[] args) {

        Dijkstras dijkstras = new Dijkstras();
        dijkstras.init();
    }

    // 그래프 초기화
    void init() {
        for(int i=0;i<GRAPH_XY;i++) {
            dist[i] = MAX; // 거리를 알 수 없는 수로 지정 (무한값)
            visit[i] = false;
        }

        // 임의로 그래프 선언
        graph[0][1] = 2;
        graph[0][2] = 4;
        graph[1][2] = 1;
        graph[3][4] = 5;
        graph[2][3] = 3;
        graph[2][4] = 8;

        // 시작 위치와 끝 위치 지정
        dijkstra(1,3);
    }

    void dijkstra(int start, int end) {

        dist[start] = 0;  // 시작 지점은 0으로 초기화 (시작 위치기 때문)

        for(int i=start;i<=end;i++) {  // 종료지점까지 반복
            int min = MAX;  // 최소값 초기화
            int index = -1;  // 위치값 초기화
            for(int j=start;j<GRAPH_XY;j++) {
                if(visit[j]==false && min > dist[j]) {  // 방문하지 않았고, 거리가 최소보다 작다면
                    min = dist[j];  // 최소를 측정한 거리로 바꾸고
                    index = j;  // 인덱스 저장
                }
            }
            visit[index] = true;  // 인덱스 값을 방문했다고 선언

            for(int j=start;j<=end;j++) {
                // 인덱스에서 j로 가는 길이 0이 아니고 측정한 거리 값이 측정한 인덱스의 거리값에서 인덱스에서 다음 위치로 가는 값보다 크다면
                if(graph[index][j] != 0 && dist[j] > dist[index]+graph[index][j]) {
                    dist[j] = dist[index] + graph[index][j];  // 거리를 현재 인덱스까지의 거리 + 움직이고자 하는 거리를 저장
                }
            }
        }

        // 출력
        for(int i=start;i<=end;i++) {
            System.out.print(dist[i] + " ");
        }

        System.out.println();

    }
}
