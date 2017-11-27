package algorithm.midas_first;

import java.util.Scanner;

public class ProblemA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] first = sc.nextLine().split(" ");

        int n = Integer.parseInt(first[0],10);
        int m = Integer.parseInt(first[1],10);
        int k = Integer.parseInt(first[2],10);

        int size = n*m;
        int[] graph = new int[size];
        for(int i=0;i<k;i++) {
            String[] next = sc.nextLine().split(" ");
            int r = Integer.parseInt(next[0]);
            int start = Integer.parseInt(next[1]);
            int last = Integer.parseInt(next[2]);

            r = r-1;
            r = r * m;
            start = start-1;
            last = last-1;

            for(int j=r+start; j<=r+last; j++) {
                graph[j] = -1;
            }
        }

        int count = 0;
        for(int i=0;i<size;i++) {
            if(graph[i] == 0) {
                count ++;
            }
        }

        System.out.println(count);
    }
}
