package algorithm;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by HunJin on 2016-11-15.
 *
 * 이 프로그램은 친구 추천 서비스 입니다.
 * 친구 리스트는 텍스트 파일로 제공됩니다.
 * 텍스트 파일은 내 이름과 친구 이름으로 구성됩니다.
 * 예 : 둘리 희동이
 *
 * 38라인 FILE_PATH만 수정하면 됩니다.
 *
 * loops : 내 이름
 *
 * output : 내 친구.
 *          내 친구의 친구.
 *          만약 이름이 없을 경우 없음을 반환합니다.
 *
 * This program is friends recommendation service.
 * Friends list is given as a text file.
 * A text file consists of a myName and a friendsName.
 * for example : 둘리 희동이
 *
 * Line 38 You must modify FILE_PATH.
 *
 * loops : my name.
 *
 * output : my freinds,
 *          my friends's friends.
 *          if hasn't name then return false.
 */
public class FriendsRecommendation {

    private static final String FILE_PATH = "cases.txt"; // FIle Path

    private Map<Integer, Set<String>> friendsListHashMap; // Used to create a friend list by remove duplicating
    private Set<String> friendsListHashSet; // Used to create a recommendation list by remove duplicating
    private String recNames = ""; // Used to create a sentence to use trim();

    private BufferedReader in;

    public static void main(String[] args) throws IOException {
        new FriendsRecommendation().solve();
    }

    /**
     * 하나의 키는 여러개의 값을 가집니다.
     *
     * A key can have multiple values.
     *
     * @param map
     * @param key
     * @param value   loops value (friends name)    인풋으로 값을 받습니다. (친구 이름)
     * @param <KEY>   int (my name . hash code)     키는 정수형입니다. (내 이름.hashCode)
     * @param <VALUE> set (friends list)            VALUE는 셋으로 되어있습니다. (친구 목록)
     */
    private <KEY, VALUE> void put(Map<KEY, Set<VALUE>> map, KEY key, VALUE value) {
        map.compute(key, (s, strings) -> strings == null ? (Set<VALUE>) new HashSet<String>() : strings).add(value);
    }

    /**
     * 문제를 해결하는 메서드입니다.
     *
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
     * 초기화
     *
     * initialization
     */
    void initialization() {
        friendsListHashMap = new HashMap<>();
        in = new BufferedReader(new InputStreamReader(System.in));
        friendsListHashSet = new HashSet<>();
    }

    /**
     * 파일을 읽어오는 메서드입니다.
     *
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
     * 키 값으로 맵에 저장합니다.
     * 공백으로 구분합니다.
     *
     * loops key values in map
     * Separated by spaces
     *
     * @param line String : name friend
     */
    void setHash(String line) {
        String[] names = line.split(" ");

        put(friendsListHashMap, names[0].hashCode(), names[1]);
        put(friendsListHashMap, names[1].hashCode(), names[0]);
    }

    /**
     * 인풋 값은 이름 입니다.
     *
     * loops name
     *
     * @throws IOException
     */
    void searchName() throws IOException {
        System.out.print("찾고자 하는 이름을 입력하세요 : ");
        String searchName = in.readLine();
        System.out.println();
        if (isCheckName(searchName)) {
            System.out.println("------- My Friends -------");
            findMyFriends(searchName);
            System.out.println();
            System.out.println("------- Recommendation -------");
            findRecommendation(searchName);
        } else {
            System.out.println("찾고자 하는 이름이 없습니다.");
        }

    }

    /**
     * 리스트에 이름이 있는지 검사합니다.
     *
     * check the list that has a name.
     *
     * @param name checking name  검사할 이름
     * @return has : true    hasn't : false   있으면 true, 없으면 false
     */
    boolean isCheckName(String name) {
        if (friendsListHashMap.containsKey(name.hashCode())) {
            return true;
        } else {
            return false;
        }
    }


    /**
     * 친구 추천 메서드 입니다.
     *
     * find recommendation
     *
     * @param name
     */
    void findRecommendation(String name) {
        Iterator it = friendsListHashMap.get(name.hashCode()).iterator();
        Iterator it2 = friendsListHashMap.get(name.hashCode()).iterator();

        /**
         * 셋에 추가
         * add set
         */
        while (it.hasNext()) {
            addHashSetRecommendationFriends(it.next().toString().trim());
        }

        /**
         * 셋에서 삭제
         * remove set (my name and my friends)
         */
        while (it2.hasNext()) {
            friendsListHashSet.remove(it2.next().toString().trim());
        }
        friendsListHashSet.remove(name);

        /**
         * trim() 메서드를 이용하기 위해 문장으로 만듭니다.
         * create a sentence to use trim();
         */
        friendsListHashSet.forEach(s -> {
            recNames += s + " ";
        });

        System.out.println(recNames.toString().trim());
    }

    /**
     * 내 친구를 찾습니다.
     *
     * find my friends
     *
     * @param name : name to look for friends   친구를 찾고자 하는 이름
     */
    void findMyFriends(String name) {
        System.out.println(friendsListHashMap.get(name.hashCode()).stream().collect(Collectors.joining(" ")));
    }

    /**
     * 내 친구의 친구를 찾습니다.
     *
     * find my friends's friends
     *
     * @param name name to look for friends's friends   친구의 친구를 찾고자 하는 이름
     */
    void addHashSetRecommendationFriends(String name) {

        Iterator it = friendsListHashMap.get(name.hashCode()).iterator();
        while (it.hasNext()) {
            friendsListHashSet.add(it.next().toString().trim());
        }
    }
}