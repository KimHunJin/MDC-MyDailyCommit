package algorithm.midaschallange2018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class InterstellarTravel {

    public static void main(String[] args) {
        new InterstellarTravel().solve();
    }

    private Map<String, List<Planet>> map = new HashMap<>();
    private List<String> isVisitList = new ArrayList<>();

    class Planet implements Comparable<Planet> {
        String name;
        int weight;

        Planet(String name, int weight) {
            this.name = name;
            this.weight = weight;
        }

        @Override
        public int compareTo(Planet o) {
            return Integer.compare(this.weight, o.weight);
        }
    }

    private String start = "A";
    private String destination = "Z";
    private String candidate = "";

    private void solve() {
        init();
        find();
    }


    private void find() {
        Queue<Planet> queue = new PriorityQueue();
        isVisitList.add(start);
        int dist = 0;

        queue.addAll(map.get(start));

        boolean isFind = false;
        while (!isVisitList.contains(candidate)) {
            if (queue.size() < 1) {
                isFind = false;
                break;
            }
            Planet p = queue.poll();
            String st = p.name;
            int wt = p.weight;

            if (isVisitList.contains(st)) {

            } else {
                dist = wt;
                isVisitList.add(st);
                if (isVisitList.contains(candidate)) {
                    isFind = true;
                    break;
                }
                if (map.containsKey(st)) {
                    for (Planet pl : map.get(st)) {
                        Planet dump = new Planet(pl.name, pl.weight + dist);
                        queue.add(dump);
                    }
                }
            }
        }

        int result = dist;

        if (!isFind) {
            System.out.println(-1);
            return;
        }

        queue = new PriorityQueue<>();
        isVisitList = new ArrayList<>();
        isVisitList.add(candidate);

        dist = 0;
        if (map.containsKey(candidate)) {
            queue.addAll(map.get(candidate));
        } else {
            System.out.println(-1);
            return;
        }

        while (!isVisitList.contains(destination)) {
            if (queue.size() < 1) {
                isFind = false;
                break;
            }
            Planet p = queue.poll();
            String st = p.name;
            int wt = p.weight;

            if (isVisitList.contains(st)) {

            } else {
                dist = wt;
                isVisitList.add(st);
                if (isVisitList.contains(candidate)) {
                    isFind = true;
                    break;
                }
                if (map.containsKey(st)) {
                    for (Planet pl : map.get(st)) {
                        Planet dump = new Planet(pl.name, pl.weight + dist);
                        queue.add(dump);
                    }
                }
            }
        }

        if (isFind) {
            result += dist;
            System.out.println(result);
        } else {
            System.out.println(-1);
        }

    }

    private void init() {
        int number = iRead();
        for (int i = 0; i < number; i++) {
            String[] tmp = readWord().split(",");
            String key = tmp[0];
            Planet p = new Planet(tmp[1], 1);
            if (map.containsKey(key)) {
                map.get(key).add(p);
            } else {
                List<Planet> list = new ArrayList<>();
                list.add(p);
                map.put(key, list);
            }
        }
        candidate = readWord();
    }

    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private int iRead() {
        return Integer.parseInt(readWord());
    }

    private String readWord() {
        String s = "";
        try {
            s = br.readLine();
        } catch (IOException ie) {
            ie.printStackTrace();
        }
        return s;
    }
}
