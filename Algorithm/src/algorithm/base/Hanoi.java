package algorithm.base;

public class Hanoi {
    public static void main(String[] args) {
        new Hanoi().solve();
    }

    private void solve() {
        hanoi(4,"A","B","C");
    }

    private void hanoi(int n, String start, String tmp, String end) {
        if (n == 1) {
            System.out.println(start + " => " + end);
        } else {
            hanoi(n - 1, start, end, tmp);
            System.out.println(start + " => " + end);
            hanoi(n - 1, tmp, start, end);
        }
    }
}
