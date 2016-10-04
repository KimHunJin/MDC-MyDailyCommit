import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by HunJin on 2016-09-29.
 *
 * 체스판 흰색 타일에 놓여있는 체스 말의 개수를 구하는 알고리즘
 * (0,0) : 흰색
 * 흰색과 검은색은 번갈아가면서 만들어짐.
 * 체스판의 사이즈는 8,8
 *
 * input            output
 * .F.F...F         1
 * F...F.F.
 * ...F.F.F
 * F.F...F.
 * .F...F..
 * F...F.F.
 * .F.F.F.F
 * ..FF..F.
 *
 */
public class WhiteBlock {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = 0;
        int j;
        for(int i=0;i<8;i++) {
            String check = br.readLine();
            if(i%2==0) { // 0,2,4,6,8 라인
                j = 0;
            } else { // 1,3,5,7 라인
                j = 1;
            }
            for(;j<check.length();j+=2) { // 흰색이 0부터 시작
                // 흰색만 검토하면 되기 때문에 j값에 2씩 더함
                if(check.charAt(j)=='F') {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
