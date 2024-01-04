package ch3.sec2.ex13;

import java.util.ArrayList;
import java.util.List;

public class BST<Key extends Comparable<Key>, Value> {
    private Node root;

    private class Node {
        private final Key key;
        private Value val;
        private Node left, right;
        private int N;

        public Node(Key key, Value val, int N) {
            this.key = key;
            this.val = val;
            this.N = N;
        }
    }

    
    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if (x == null) return 0;
        else return x.N;
    }


    public Value get(Key key) {
        Node x = root;
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if (cmp == 0) return x.val;
            else if (cmp < 0) x = x.left;
            else /* if (cmp > 0) */ x = x.right;
        }
        return null;
    }

    // tag::snippet[]
    public void put(Key key, Value val) {
        if (root == null) {
            root = new Node(key, val, 1);
            return;
        }
        List<Node> paths = new ArrayList<>();
        Node x = root;
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if (cmp == 0) {
                x.val = val;
                return;
            }
            paths.add(x);
            if (cmp < 0) x = x.left;
            else x = x.right;
        }
        Node p = paths.get(paths.size() - 1);
        Node n = new Node(key, val, 1);
        if (key.compareTo(p.key) < 0) p.left = n;
        else p.right = n;
        for (Node node : paths) node.N += 1;
    }
    // end::snippet[]

    private void printTree(StringBuilder sb, Node x, String prefix, boolean isRoot, boolean isLeft, boolean hasSibling) {
        if (x == null) return;
        sb.append(prefix);
        String pointer = isLeft ? "┄┄┄" : "───";
        if (!isRoot) sb.append(hasSibling ? "├" + pointer : "└" + pointer);
        sb.append(x.key).append(", ").append(x.N).append("\n");
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
}
