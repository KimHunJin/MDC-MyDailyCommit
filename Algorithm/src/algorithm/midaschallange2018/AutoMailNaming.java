package algorithm.midaschallange2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class AutoMailNaming {
    public static void main(String[] args) {
        new AutoMailNaming().solve();
    }

    private void solve() {
        String company = readWord().toLowerCase();
        String peoples[] = readWord().toLowerCase().split(", ");

        List<String> names = new ArrayList<>();

        for (String s : peoples) {
            String tmp[] = s.split(" ");
            int size = tmp.length;
            String firstName;
            String lastName;
            if (size < 3) {
                firstName = tmp[0].replaceAll("-", "");
                lastName = tmp[1].replaceAll("-", "");
            } else {
                firstName = tmp[0].replaceAll("-", "");
                lastName = tmp[2].replaceAll("-", "");
            }
            String name = lastName + firstName.charAt(0);


            int count = 1;
            String dmp = name;
            while (names.contains(dmp)) {
                count++;
                dmp = name + count;
            }
            if (count > 1) {
                name = name + count;
            }
            names.add(name);
        }

        int size = names.size();
        StringBuilder result = new StringBuilder();
        for(int i=0;i<size;i++) {
            if(i==size-1) {
                result.append(names.get(i)).append("@").append(company).append(".com");
            } else {
                result.append(names.get(i)).append("@").append(company).append(".com, ");
            }
        }
        System.out.println(result);
    }

    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private String readWord() {

        String s = "";
        try {
            s = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return s;
    }
}
