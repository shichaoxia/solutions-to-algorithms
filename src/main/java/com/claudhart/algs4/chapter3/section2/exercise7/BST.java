package com.claudhart.algs4.chapter3.section2.exercise7;

@SuppressWarnings("DuplicatedCode")
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

    @SuppressWarnings("unused")
    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if (x == null) return 0;
        else return x.N;
    }

    @SuppressWarnings("unused")
    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) return get(x.left, key);
        else if (cmp > 0) return get(x.right, key);
        else return x.val;
    }


    public void put(Key key, Value val) {
        root = put(root, key, val);
    }

    private Node put(Node x, Key key, Value val) {
        if (x == null) return new Node(key, val, 1);
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = put(x.left, key, val);
        else if (cmp > 0) x.right = put(x.right, key, val);
        else x.val = val;
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    // tag::snippet[]
    private int internalPathLength(Node x, int depth) {
        if (x == null) return 0;
        return internalPathLength(x.left, depth + 1) + internalPathLength(x.right, depth + 1) + depth;
    }

    public int internalPathLength() {
        return internalPathLength(root, 0);
    }
    // end::snippet[]

    @SuppressWarnings("unused")
    public void printTree() {
        printTree(root, "", true, false, false);
    }

    private void printTree(Node x, String prefix, boolean isRoot, boolean isLeft, boolean hasSibling) {
        if (x == null) return;
        System.out.print(prefix);
        String pointer = isLeft ? "┄┄┄" : "───";
        if (!isRoot) System.out.print(hasSibling ? "├" + pointer : "└" + pointer);
        System.out.println(x.key);
        if (!isRoot) prefix += hasSibling ? "│   " : "    ";
        printTree(x.right, prefix, false, false, x.left != null);
        printTree(x.left, prefix, false, true, false);
    }
}
