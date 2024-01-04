package ch3.sec2.ex25;

import java.util.Arrays;

@SuppressWarnings("DuplicatedCode")
public class BST<Key, Value> {
    private final Node root;

    private class Node {
        private final Key key;
        @SuppressWarnings({"unused", "FieldCanBeLocal"})
        private final Value val;
        private Node left, right;
        private int N;

        public Node(Key key, Value val, int N) {
            this.key = key;
            this.val = val;
            this.N = N;
        }
    }

// --Commented out by Inspection START (12/5/23, 12:27):
//    public int size() {
//        return size(root);
//    }
// --Commented out by Inspection STOP (12/5/23, 12:27)

    private int size(Node x) {
        if (x == null) return 0;
        else return x.N;
    }

    private void printTree(StringBuilder sb, Node x, String prefix, boolean isRoot, boolean isLeft, boolean hasSibling) {
        if (x == null) return;
        sb.append(prefix);
        String pointer = isLeft ? "┄┄┄" : "───";
        if (!isRoot) sb.append(hasSibling ? "├" + pointer : "└" + pointer);
        sb.append(x.key).append("\n");
        if (!isRoot) prefix += hasSibling ? "│   " : "    ";
        printTree(sb, x.right, prefix, false, false, x.left != null);
        printTree(sb, x.left, prefix, false, true, false);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        printTree(sb, root, "", true, false, false);
        return sb.toString();
    }

    // tag::snippet[]
    public BST(Key[] a) {
        root = construct(a, 0, a.length - 1);
    }

    private Node construct(Key[] a, int lo, int hi) {
        if (lo > hi) return null;
        int mid = lo + (hi - lo) / 2;
        Node x = new Node(a[mid], null, 0);
        x.left = construct(a, lo, mid - 1);
        x.right = construct(a, mid + 1, hi);
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public static void main(String[] args) {
        Integer[] a = {6, 7, 8, 2, 3, 4, 5};
        Arrays.sort(a);
        BST<Integer, Integer> bst = new BST<>(a);
        System.out.println(bst);
    }
    // end::snippet[]
}
