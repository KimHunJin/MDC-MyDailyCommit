package algorithm.kakao.codechallange;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class Cache {
    public static void main(String[] args) {

        String[] s = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
        String[] s1 = {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"};
        String[] s3 = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"};
        String[] s4 = {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"};
        String[] s5 = {"Jeju", "jeju","jeju"};
        String[] s6 = {};
        int cacheSize = 7;
        System.out.println(new Cache().solution2(cacheSize, s3));
    }

    public int solution2(int cacheSize, String[] cities) {

        int anser = 0;

        if (cacheSize == 0) {
            return 5 * cities.length;
        }

        for (int i = 0; i < cities.length; i++) {
            cities[i] = cities[i].toLowerCase();
        }

        String[] cache = new String[cacheSize];
        int[] cachePosition = new int[cacheSize];
        for (int i = 0; i < cities.length; i++) {
            boolean isCache = false;
            int position = 0;
            for (int j = 0; j < cache.length; j++) {
                if (cities[i].equals(cache[j])) {
                    isCache = true;
                    position = j;
                    break;
                }
            }
            if (isCache) {
                anser++;
                cachePosition[position] = i+1;
            } else {
                anser += 5;
                cache[min(cachePosition)] = cities[i];
                cachePosition[min(cachePosition)] = i + 1;
            }
        }

        return anser;
    }

    public int min(int[] positon) {
        int min = Integer.MAX_VALUE;
        int result = 0;
        for (int i = 0; i < positon.length; i++) {
            if (min > positon[i]) {
                min = positon[i];
                result = i;
            }
        }
        return result;
    }

    public int solution(int cacheSize, String[] cities) {
        int answer = 0;

        if (cacheSize == 0) {
            return 5 * cities.length;
        }

        for (int i = 0; i < cities.length; i++) {
            cities[i] = cities[i].toLowerCase();
        }


        HashMap<Integer, String> cache = new LinkedHashMap<>();


        int position = 0;
        int sum = 0;

        for (int i = 0; i < cities.length; i++) {
            if (cache.containsValue(cities[i])) {
                sum += 1;
            } else {
                position = position % cacheSize;
                cache.put(position, cities[i]);
                sum += 5;
                position++;
            }
        }

        answer = sum;
        return answer;
    }
}
