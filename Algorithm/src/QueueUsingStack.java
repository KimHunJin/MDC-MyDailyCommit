import java.util.Stack;

/**
 * Created by HunJin on 2016-09-19.
 */
public class QueueUsingStack {

    Stack stack1, stack2;

    public static void main(String[] args) {

        new QueueUsingStack().solve();

    }

    void solve() {
        init();
        put(1);
        put(2);

        System.out.println(get());
        System.out.println(get());
    }

    void init() {
        stack1 = new Stack();
        stack2 = new Stack();
    }

    void change() {
        for(int i=0;i<stack1.size();i++) {
            stack2.push(stack1.pop());
        }
    }

    void put(int i) {
        stack1.push(i);
    }

    int get() {
        if(!stack1.isEmpty()) {
            change();
        }
        return Integer.parseInt(stack2.pop().toString());
    }
}
