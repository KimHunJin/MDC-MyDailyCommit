package algorithm.midaschallange2018;

import java.util.Scanner;

public class TernaryOperator {
    public static void main(String[] args) {
        new TernaryOperator().solve();
    }

    private static final String BIG = ">";
    private static final String SMALL = "<";
    private static final String BIG_SAME = ">=";
    private static final String SMALL_SAME = "<=";
    private static final String NOT_SAME = "!=";
    private static final String SAME = "==";

    private static final String QUESTION = "\\?";
    private static final String COLON = ":";

    class Tree {
        String value;
        Tree left;
        Tree right;

        Tree() {

        }

        Tree(String value, Tree left, Tree right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    private void solve() {
        Scanner sc = new Scanner(System.in);
        String words = sc.nextLine();

        String[] nodes = words.split("\\? | : ");
        Tree tree = new Tree(nodes[0], null, null);
        makeTree(tree, nodes);

        oper(tree);
    }

    private void makeTree(Tree tree, String[] words) {
        makeTree(tree, words, 1, words.length-1);
    }

    private void makeTree(Tree tree, String[] words, int start, int last) {
        if(start >= last) {
            return;
        }

        if (words[start].split(" ").length > 1) {
            tree.left = new Tree(words[start], null, null);
            tree.right = new Tree(words[last], null, null);
            makeTree(tree.left, words, start + 1, last - 1);
        } else {
            tree.left = new Tree(words[start], null, null);
            tree.right = new Tree(words[start + 1], null, null);
            makeTree(tree.right, words, start + 2, last);
        }
    }

    private void oper(Tree tree) {
        if (tree.value.split(" ").length > 1) {
            if (oper(tree.value)) {
                oper(tree.left);
            } else {
                oper(tree.right);
            }
        } else {
            System.out.println(tree.value);
        }
    }

    private boolean oper(String word) {
        String[] words = word.split(" ");
        boolean result = false;
        int a = Integer.parseInt(words[0]);
        int b = Integer.parseInt(words[2]);
        switch (words[1]) {
            case BIG: {
                result = a > b;
                break;
            }
            case SMALL: {
                result = a < b;
                break;
            }
            case BIG_SAME: {
                result = a >= b;
                break;
            }
            case SMALL_SAME: {
                result = a <= b;
                break;
            }
            case SAME: {
                result = a == b;
                break;
            }
            case NOT_SAME: {
                result = a != b;
                break;
            }
        }
        return result;
    }
}
