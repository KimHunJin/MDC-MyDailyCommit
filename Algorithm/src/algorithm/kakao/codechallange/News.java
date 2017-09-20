package algorithm.kakao.codechallange;

import java.util.*;

public class News {
    public static void main(String[] args) {

        String str1 = "handshake";
        String str2 = "ab";

        System.out.println(new News().solution(str1, str2));
    }

    public int solution(String str1, String str2) {
        int answer = 0;

        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        int kyo = 1;
        int hap = 1;

        String[] str1Zip = new String[str1.length() - 1];
        String[] str2Zip = new String[str2.length() - 1];
        Map<String, Zip> map = new HashMap<>();

        for (int i = 0; i < str1.length() - 1; i++) {
            str1Zip[i] = str1.substring(i, i + 2);
            boolean isEnglish = true;
            for (int j = 0; j < str1Zip[i].length(); j++) {
                if (str1Zip[i].charAt(j) < 'a' || str1Zip[i].charAt(j) > 'z') {
                    isEnglish = false;
                    break;
                }
            }
            if (isEnglish) {
                if (map.containsKey(str1Zip[i])) {
                    Zip zip = map.get(str1Zip[i]);
                    zip.str1Number++;
                    map.put(str1Zip[i], zip);
                } else {
                    Zip zip = new Zip();
                    zip.str1Number = 1;
                    map.put(str1Zip[i], zip);
                }
            }
        }

        for (int i = 0; i < str2.length() - 1; i++) {
            str2Zip[i] = str2.substring(i, i + 2);
            String test = str2Zip[i];
            boolean isEnglish = true;
            for (int j = 0; j < str2Zip[i].length(); j++) {
                if (str2Zip[i].charAt(j) < 'a' || str2Zip[i].charAt(j) > 'z') {
                    isEnglish = false;
                    break;
                }
            }
            if (isEnglish) {
                if (map.containsKey(str2Zip[i])) {
                    Zip zip = map.get(str2Zip[i]);
                    zip.str2Number++;
                    map.put(str2Zip[i], zip);
                } else {
                    Zip zip = new Zip();
                    zip.str2Number = 1;
                    map.put(str2Zip[i], zip);
                }
            }
        }

        Set<String> set = map.keySet();

        Iterator<String> iterator = set.iterator();

        List<String> kyoList = new ArrayList<>();
        List<String> hapList = new ArrayList<>();

        while (iterator.hasNext()) {
            String key = iterator.next();
            int max = map.get(key).str1Number > map.get(key).str2Number ? map.get(key).str1Number : map.get(key).str2Number;
            int min = map.get(key).str1Number < map.get(key).str2Number ? map.get(key).str1Number : map.get(key).str2Number;
            for(int i=0;i<max;i++) {
                hapList.add(key);
            }
            for(int i=0;i<min;i++) {
                kyoList.add(key);
            }
        }

        if(hapList.size()==0 && kyoList.size()==0) {
            kyo = 1;
            hap = 1;
        } else if(hapList.size()==0) {
            kyo = 0;
            hap = 1;
        } else if(kyoList.size()==0) {
            kyo = 0;
            hap = 1;
        } else {
            kyo = kyoList.size();
            hap = hapList.size();
        }

        double result = (double)kyo/(double)hap;
        result = result * 65536;
        answer = (int)result;

        return answer;
    }

    class Zip {
        int str1Number = 0;
        int str2Number = 0;
    }
}
