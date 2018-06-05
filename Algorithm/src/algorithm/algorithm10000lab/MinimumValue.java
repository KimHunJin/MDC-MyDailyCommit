package algorithm.algorithm10000lab;

import java.util.*;

public class MinimumValue {

    private boolean[] isVisit;

    private int start;
    private int destination;

    private Map<Integer, List<City>> map = new HashMap<>();

    public static void main(String[] args) {
        new MinimumValue().solve();
    }

    private void solve() {
        init();
        find();
    }

    class City implements Comparable<City> {
        int index;
        int weight;

        City(int index, int weight) {
            this.index = index;
            this.weight = weight;
        }

        @Override
        public int compareTo(City o) {
            return Integer.compare(this.weight, o.weight);
        }
    }

    private void find() {
        Queue<City> queue = new PriorityQueue<>();
        isVisit[start] = true;
        int dist = 0;

        queue.addAll(map.get(start));

        while (!isVisit[destination]) {
            City c = queue.poll();
            int st = c.index;
            int wt = c.weight;
            if (isVisit[st]) {

            } else {
                dist = wt;
                isVisit[st] = true;
                if (isVisit[destination]) {
                    break;
                }
                if (map.containsKey(st)) {
                    for (City cs : map.get(st)) {
                        City dmpCity = new City(cs.index, cs.weight + dist);
                        queue.add(dmpCity);
                    }
                }
            }
        }
        System.out.println(dist);
    }

    private void init() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        n++;
        isVisit = new boolean[n];
        int v = sc.nextInt();

        for (int i = 0; i < v; i++) {
            int s = sc.nextInt();
            int l = sc.nextInt();
            int w = sc.nextInt();

            City city = new City(l, w);
            if (map.containsKey(s)) {
                map.get(s).add(city);
            } else {
                List<City> list = new ArrayList<>();
                list.add(city);
                map.put(s, list);
            }

        }
        start = sc.nextInt();
        destination = sc.nextInt();
    }
}
