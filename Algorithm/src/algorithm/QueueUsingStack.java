package algorithm;

import java.util.Stack;

/**
 * Created by HunJin on 2016-09-19.
 *
 * problem
 * Stack 2개를 이용하여 Queue를 만들어라. (don't using any variable)
 * 다음 메서드를 완성하라.
 *
 * put->1
 * put->2
 * put->3
 *
 * get() = 1
 * get() = 2
 * get() = 3
 */
public class QueueUsingStack {

    Stack stack1, stack2;

    public static void main(String[] args) {
        new QueueUsingStack().solve();
    }

    void solve() {
        init();
        problem();
    }

    /**
     * put 1 , 2 , 3 -> get
     */
    void problem() {
        put(1);
        put(2);
        put(3);

        System.out.println(get());
        System.out.println(get());
        System.out.println(get());

        put(4);
        put(5);

        System.out.println(get());
        put(6);
        System.out.println(get());
        System.out.println(get());
    }

    /**
     * 초기화
     */
    void init() {
        stack1 = new Stack();
        stack2 = new Stack();
    }

    /**
     * 스택1에 담긴 수를 스택2로 옮기는 메서드
     */
    void change() {
        // 스택의 사이즈를 미리 지정하지 않고 for문 안에 stack1.size()를 써버리면
        // 반복을 돌면서 스택의 사이즈가 바껴 버리는 문제 발생
        int size = stack1.size();
        for(int i=0;i<size;i++) {
            stack2.push(stack1.pop());
        }
    }

    /**
     * 스택에 수i를 저장하는 메서드
     * @param i
     */
    void put(int i) {
        stack1.push(i);
    }

    /**
     * 숫자를 출력하는 메서드
     * @return
     */
    int get() {
        // stack1의 사이즈가 0이 아니라는 것은 스택에 수가 있다는걸 의미
        if(stack1.size()>0 && stack2.size()==0) {
            change();
        }
        return Integer.parseInt(stack2.pop().toString());
    }
}
