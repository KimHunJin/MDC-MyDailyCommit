/**
 * Created by HunJin on 2016-09-20.
 *
 * complete is not yet
 *
 * making linked list similar C's linked list
 */
public class CustomLinkedList {

    private Node node;
    private CustomList list;

    public static void main(String[] args) {
        new CustomLinkedList().init();
    }

    void init() {
        list = new CustomList();

        list.count = 0;
        list.head = null;
    }
}


class Node {
    int value;
    Node next;
}

class CustomList {
    int count;
    Node head;
}
