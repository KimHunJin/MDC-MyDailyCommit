package algorithm.forbidden;

/**
 * Created by HunJin on 2016-11-18.
 */
public class TranslateS {

    public static void main(String[] args) {
        System.out.println(new TranslateS().solution2("AAAAAAAAAA"));
    }

    public String solution(String S) {
        // write your code in Java SE 8

        if(S.contains("A") || S.contains("C")) {
            S = S.replaceAll("B", "");
            S = S.replaceAll("AA", "A");
            S = S.replaceAll("CC", "C");
        }

        return S;
    }

    public static String solution2(String S)
    {
        StringBuilder sb = new StringBuilder();

        int init = S.charAt(0);
        if(init !=66)
        {
            sb.append(S.charAt(0));
        }
        int current = 0;

        for(int i=1;i<S.length();i++)
        {
            current = S.charAt(i);

            if(init != current && current != 66)
            {
                sb.append(S.charAt(i));
                init = current;
            }
        }

        if(sb.toString().length()==0)
        {
            sb.append(S);
        }

        return sb.toString();
    }
}
