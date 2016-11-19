package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by HunJin on 2016-11-15.
 */
public class RecommendationFriends {

    Map<Integer, Set<String>> hashMap = new LinkedHashMap<>();

    String searchName;

    public static void main(String[] args) throws IOException {
        new RecommendationFriends().solve();
    }

    private <KEY, VALUE> void put(Map<KEY, Set<VALUE>> map, KEY key, VALUE value) {
        map.compute(key, (s, strings) -> strings == null ? (Set<VALUE>) new HashSet<String>() : strings).add(value);
    }

    void solve() throws IOException{
        input();

        ss(searchName);
//        print();
        hashMap.get(searchName.hashCode()).forEach((s -> {
            System.out.println("s : " + s);
            output(s);
        }));
    }

    void ss(String names) {
        System.out.println(names + " : " + hashMap.get(names.hashCode()));
    }

    void print() {
        hashMap.forEach((s, strings) -> {
            System.out.print(s + " : " );
            System.out.println(strings.stream().collect(Collectors.joining(", ")));
        });
    }

    void output(String name) {
        if(hashMap.containsKey(name.hashCode())) {
            hashMap.get(name.hashCode()).forEach(s -> {
                hashMap.forEach((k, strings) -> {
//                    System.out.print(hashMap.get(k.hashCode()));
                    System.out.print(strings.stream().collect(Collectors.joining(", ")));
                });
            });
        }
    }

    void input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] names = br.readLine().split(" ");


        put(hashMap, names[0].hashCode(), names[1]);
        put(hashMap, names[1].hashCode(), names[0]);

        searchName = br.readLine();
    }
}