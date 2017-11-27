package algorithm.midas_second;

import java.util.*;

public class ProblemE {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim(), 10);
        int pair = Integer.parseInt(sc.nextLine().trim(), 10);

        String word = "";

        ArrayList<Character> wordList = new ArrayList<>();

        HashMap<Character, ArrayList<Character>> hashMap = new HashMap<>();


        for (int i = 0; i < n; i++) {
            wordList.add((char) (65 + i));
        }

        for (int i = 0; i < wordList.size(); i++) {
            word += wordList.get(i);
        }

        ArrayList<Character> hashChar = null;

        for (int i = 0; i < pair; i++) {
            String[] s = sc.nextLine().split(" ");
            char first = s[0].charAt(0);
            char second = s[1].charAt(0);
            if (hashMap.containsKey(first)) {
                hashChar = hashMap.get(first);
                hashChar.add(second);
                Collections.sort(hashChar);
            } else {
                hashChar = new ArrayList<>();
                hashChar.add(second);
            }
            hashMap.put(first, hashChar);
        }

        Set<Character> s = new HashSet<>();
        s = hashMap.keySet();

        Iterator iterator = s.iterator();
        while (iterator.hasNext()) {
            char key = (char) iterator.next();
            System.out.print(key + " : ");
            for (int i = 0; i < hashMap.get(key).size(); i++) {
                System.out.print(hashMap.get(key).get(i)+ " ");
            }
            System.out.println();
        }



        System.out.println(word);
    }
}
