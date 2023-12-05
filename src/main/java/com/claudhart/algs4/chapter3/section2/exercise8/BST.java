package com.claudhart.algs4.chapter3.section2.exercise8;

import java.util.stream.IntStream;

public class BST<Key extends Number & Comparable<Key>, Value> {
    private Node root;
    private int getCompareCount = 0;

    private class Node {
        private Key key;
        private Value val;
        private Node left, right;
        private int N;

        public Node(Key key, Value val, int N) {
            this.key = key;
            this.val = val;
            this.N = N;
        }

        @SuppressWarnings("unchecked")
        public Node(int key, int val, int N) {
            this.key = (Key) Integer.valueOf(key);
            this.val = (Value) Integer.valueOf(val);
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
        return get(root, key);
    }

    private Value get(Node x, Key key) {
        if (x == null) return null;
        int cmp = getCompare(key, x.key);
        if (cmp < 0) return get(x.left, key);
        else if (cmp > 0) return get(x.right, key);
        else return x.val;
    }

    private int getCompare(Key k1, Key k2) {
        getCompareCount++;
        return k1.compareTo(k2);
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

    // tag::snippet[]
    private Node optimalBST(int start, int end) {
        if (start > end)
            return null;
        int mid = (start + end) / 2;
        Node node = new Node(mid, mid, 1);
        node.left = optimalBST(start, mid - 1);
        node.right = optimalBST(mid + 1, end);
        return node;
    }

    private static BST<Integer, Integer> optimalBST(int N) {
        BST<Integer, Integer> bst = new BST<>();
        bst.root = bst.optimalBST(0, N - 1);
        return bst;
    }

    public static int optCompares(int N) {
        BST<Integer, Integer> bst = optimalBST(N);
        int totalCompares = IntStream.range(0, N).map(i -> {
            bst.get(i);
            int temp = bst.getCompareCount;
            bst.getCompareCount = 0;
            return temp;
        }).sum();
        return totalCompares / N;
    }

    public static void main(String[] args) {
        System.out.printf("%10s %11s%n", "N", "avgCompares");
        for (int N = 1_000; N <= 1_000_000; N *= 2)
            System.out.printf("%10d %11d%n", N, optCompares(N));
    }
    // end::snippet[]
}
