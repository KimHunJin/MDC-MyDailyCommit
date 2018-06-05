package algorithm.line;

public class TextProblem {
    public static void main(String[] args) {
        int cnt = 0;
        for(int i=0;i<=1024;++i) {
             if((i&(i-1))==0) {
                ++cnt;
            }
        }
        System.out.println(cnt);
    }
}
