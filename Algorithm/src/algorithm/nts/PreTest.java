package algorithm.nts;

class PreTest {

    private static final int[] NUMBER_UNIT = {1, 10, 100, 1000, 10000};
    private static final String[] UNIT = {"", "십", "백", "천", "만"};
    private static final String[] NUMBER_NAME = {"", "일", "이", "삼", "사", "오", "육", "칠", "팔", "구"};

    public static void main(String[] args) {
        PreTest p = new PreTest();
        p.solve(args[0]);
    }

    private void solve(String num) {
        int number = convertInt(num);
        if (number < 1 || number > 99999) {
            System.out.println("범위 초과");
            return;
        }
        int size = num.length();

        String result = resultSpeakNumber(number, size);
        print(result);
    }

    // 숫자 발음 결과
    private String resultSpeakNumber(int number, int size) {
        String value = "";
        while (true) {
            if (size <= 1) {
                break;
            }
            value += makeSpeakNumber(number, size);
            number = number % NUMBER_UNIT[size - 1];
            size--;
        }
        value += NUMBER_NAME[number];
        return value;
    }

    // 숫자 발음 만들기
    private String makeSpeakNumber(int number, int size) {
        int quo = number / NUMBER_UNIT[size - 1];
        String value = "";
        if (quo == 1) {
            value = UNIT[size - 1];
        } else if (quo > 0) {
            value = NUMBER_NAME[quo] + UNIT[size - 1];
        }
        return value;
    }

    private int convertInt(String number) {
        return Integer.parseInt(number);
    }

    private void print(String result) {
        System.out.println(result);
    }
}
