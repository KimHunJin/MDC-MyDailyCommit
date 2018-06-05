package algorithm.ku;

import java.util.ArrayList;

public class Test {

    private static ArrayList[] lists;

    public static void main(String[] args) {
        lists = new ArrayList[10];

        for (int i = 0; i < lists.length; i++) {
            lists[i] = new ArrayList();
            lists[i].add(new Node(i,-1));
        }

        for(int i=0;i<lists.length;i++) {
//            System.out.println(lists[i].size());
        }

        for(int i=0;i<lists.length;i++) {
            Node tmp = (Node) lists[i].get(i);
            System.out.println(tmp.getIndex());
        }
    }
}

class Node {
    private int index;
    private int weight;

    public Node(int index, int weight) {
        this.index = index;
        this.weight = weight;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
