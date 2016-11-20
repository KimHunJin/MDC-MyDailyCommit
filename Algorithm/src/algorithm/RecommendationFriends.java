package algorithm;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by HunJin on 2016-11-15.
 */
public class RecommendationFriends {

    private static final String FILE_PATH = "C:\\Users\\HunJin\\Desktop\\cases.txt"; // Absolute FIle Path

    private Map<Integer, Set<String>> friendsListHashMap; // Used to create a friend list by remove duplicating
    private Set<String> friendsListHashSet; // Used to create a recommendation list by remove duplicating
    private String recNames = ""; // Used to create a sentence to use trim();

    private BufferedReader in;

    public static void main(String[] args) throws IOException {
        new RecommendationFriends().solve();
    }

    /**
     * A key can have multiple values.
     *
     * @param map
     * @param key
     * @param value
     * @param <KEY>
     * @param <VALUE>
     */
    private <KEY, VALUE> void put(Map<KEY, Set<VALUE>> map, KEY key, VALUE value) {
        map.compute(key, (s, strings) -> strings == null ? (Set<VALUE>) new HashSet<String>() : strings).add(value);
    }

    /**
     * solve method
     *
     * @throws IOException
     */
    void solve() throws IOException {
        initialization();
        input();
        searchName();
    }

    /**
     * initialization
     */
    void initialization() {
        friendsListHashMap = new HashMap<>();
        in = new BufferedReader(new InputStreamReader(System.in));
        friendsListHashSet = new HashSet<>();
    }

    /**
     * File Read
     *
     * @throws IOException
     */
    void input() throws IOException {

        File file = new File(FILE_PATH);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line;
        while ((line = br.readLine()) != null) {
            setHash(line);
        }

        fr.close();
    }

    /**
     * input key values in map
     * Separated by spaces
     *
     * @param line
     */
    void setHash(String line) {
        String[] names = line.split(" ");

        put(friendsListHashMap, names[0].hashCode(), names[1]);
        put(friendsListHashMap, names[1].hashCode(), names[0]);
    }

    /**
     * input name
     *
     * @throws IOException
     */
    void searchName() throws IOException {
        System.out.print("찾고자 하는 이름을 입력하세요 : ");
        String searchName = in.readLine();

        System.out.println("------- My Friends -------");
        findMyFriends(searchName);
        System.out.println("------- Recommendation -------");
        findRecommendation(searchName);
    }

    /**
     * find my friends
     *
     * @param name
     */
    void findMyFriends(String name) {
        System.out.println(friendsListHashMap.get(name.hashCode()).stream().collect(Collectors.joining(" ")));
    }

    /**
     * find recommendation
     *
     * @param name
     */
    void findRecommendation(String name) {
        Iterator it = friendsListHashMap.get(name.hashCode()).iterator();
        Iterator it2 = friendsListHashMap.get(name.hashCode()).iterator();

        /**
         * add set
         */
        while (it.hasNext()) {
            addHashSetRecommendationFriends(it.next().toString().trim());
        }

        /**
         * remove set (my name and my friends)
         */
        while (it2.hasNext()) {
            friendsListHashSet.remove(it2.next().toString().trim());
        }
        friendsListHashSet.remove(name);

        /**
         * create a sentence to use trim();
         */
        friendsListHashSet.forEach(s -> {
            recNames += s + " ";
        });

        System.out.println(recNames.toString().trim());
    }

    /**
     * find my friends's friends
     *
     * @param name
     */
    void addHashSetRecommendationFriends(String name) {

        Iterator it = friendsListHashMap.get(name.hashCode()).iterator();
        while (it.hasNext()) {
            friendsListHashSet.add(it.next().toString().trim());
        }
    }
}