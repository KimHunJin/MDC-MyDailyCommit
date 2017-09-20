package algorithm.kakao.codechallange;

public class Dart {
    public static void main(String[] args) {
        String v = "1S*2T*3S";
        new Dart().solution(v);
    }

    public int solution(String dartResult) {
        int answer = 0;

        int[] num = new int[3];
        String[] bonus = new String[3];
        String[] option = new String[3];
        for(int i=0;i<option.length;i++) {
            option[i] = "";
        }

        int scoreCount = 0;
        for (int i = 0; i < dartResult.length(); i++) {
            if (dartResult.charAt(i) <= '9' && dartResult.charAt(i) >= '0') {
                String s = String.valueOf(dartResult.charAt(i));
                if(dartResult.charAt(i+1)=='0') {
                    s+=dartResult.charAt(i+1);
                    i++;
                }
                num[scoreCount] = Integer.parseInt(s);

                if(dartResult.charAt(i+1)=='D' || dartResult.charAt(i+1) == 'S' || dartResult.charAt(i+1) == 'T') {
                    bonus[scoreCount] = dartResult.charAt(i+1)+"";
                    i++;
                }

                if(i<dartResult.length()-1 && (dartResult.charAt(i+1)=='*' || dartResult.charAt(i+1)=='#')) {
                    option[scoreCount] = dartResult.charAt(i+1)+"";
                    i++;
                }
                scoreCount++;
            }
        }

        int sum[] = new int[3];
        for(int i=0;i<3;i++) {
            if(bonus[i].equals("S")) {
                sum[i] = num[i];
            } else if(bonus[i].equals("D")) {
                sum[i] = num[i] * num[i];
            } else if(bonus[i].equals("T")) {
                sum[i] = num[i] * num[i] * num[i];
            }

            if(option[i].equals("#")) {
                sum[i] = sum[i] * -1;
            } else if(option[i].equals("*")) {
                sum[i] = sum[i] * 2;
                if(i>0) {
                    sum[i-1] = sum[i-1] * 2;
                }
            }
        }

        for (int i : sum) {
            answer+=i;
        }

        System.out.println(answer);

        return answer;
    }
}
