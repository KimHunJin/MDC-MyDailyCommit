package algorithm.line;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Sticker {

    static final int P = 1003001;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            final int T = Integer.parseInt(br.readLine().trim());

            for (int i = 0; i < T; i++) {
                final StringTokenizer tokenizer = new StringTokenizer(br.readLine().trim());
                int N = Integer.parseInt(tokenizer.nextToken());
                int K = Integer.parseInt(tokenizer.nextToken());
                int M = Integer.parseInt(tokenizer.nextToken());

                nCr = new long[N+1][N+1];
                for(int j=0;j<=N;j++) {
                    Arrays.fill(nCr[j],-1);
                }
                long a = value(N,K-M);
                long b = value(N,M);
                System.out.println(a*b%P);
            }
        }
    }

    static long[][] nCr;

    static long value(int N, int R) {
        if (nCr[N][R] != -1)
            return nCr[N][R];
        if (R == 0 || N == R)
            return 1;
        long ans =  ((value(N - 1, R) + value(N - 1, R - 1)) % P);
        return nCr[N][R] = ans;
    }

}
