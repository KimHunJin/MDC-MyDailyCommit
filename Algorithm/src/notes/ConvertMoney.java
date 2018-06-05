package notes;

public class ConvertMoney {
    public static void main(String[] args) {
        System.out.println(new ConvertMoney().change("1000000"));
    }

    private String change(String m) {
        String k = "";

        for (int i = m.length() - 1, j=1; i >= 0; i--, j++) {
            k = m.charAt(i) + k;

            if (i != 0 && j % 3 == 0) {
                k = "," + k;
            }
        }
        return k;
    }
}

