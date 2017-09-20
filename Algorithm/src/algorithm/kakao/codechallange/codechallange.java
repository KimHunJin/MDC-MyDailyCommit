package algorithm.kakao.codechallange;

public class codechallange {
    public static void main(String[] args) {
        int[] arr1 = {9, 20, 28, 18, 11};
        int[] arr2 = {30, 1, 21, 17, 28};
        new codechallange().solution(5, arr1, arr2);
    }

    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for (int i = 0; i < n; i++) {
            String binary1 = Integer.toBinaryString(arr1[i]);
            String binary2 = Integer.toBinaryString(arr2[i]);

            String[] semiResult = new String[n];
            for(int j=0;j<semiResult.length;j++) {
                semiResult[j] = " ";
            }
            int semiLength = semiResult.length-1;
            for (int j = binary1.length() - 1; j >= 0; j--) {
                if (binary1.charAt(j) == '1') {
                    semiResult[semiLength] = "#";
                }
                semiLength--;
            }
            semiLength = semiResult.length-1;
            for (int j = binary2.length() - 1; j >= 0; j--) {
                if (binary2.charAt(j) == '1') {
                    semiResult[semiLength] = "#";
                }
                semiLength--;
            }
            String result = "";
            for(int j=0;j<semiResult.length;j++) {
                result += semiResult[j];
            }

            answer[i] = result;
        }
        return answer;
    }
}
