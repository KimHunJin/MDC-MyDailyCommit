package algorithm.woowahan3;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        new A().solve();
    }

    private void solve() {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 사람
        int d = sc.nextInt(); // 방향
        int k = sc.nextInt(); // 이동 수
        int j = sc.nextInt(); // 증가 폭

        //여기부터 작성해 주세요
        int index = 0;
        int[] r = new int[n];
        switch (d) {
            case 0: {
                for (int i = n - 1, c = 1; i >= 0; i--, c++) {
                    r[i] = c;
                }
                index = n - 1;
                break;
            }
            case 1: {
                for (int i = 0; i < r.length; i++) {
                    r[i] = i + 1;
                }
                index = 0;
                break;
            }
        }

        int size = r.length;

        while (n > 1) {
            int loop = k;
            for (int i = 1; i <= loop; i++) {
                int move = (index + i) % size;
                if (r[move] == -1) {
                    loop++;
                }
            }
            index = (index + loop) % size;
            r[index] = -1;
            k = k + j;
            n--;
        }

        for (int a : r) {
            if(a!=-1) {
                System.out.println(a);
                break;
            }
        }
    }
}
