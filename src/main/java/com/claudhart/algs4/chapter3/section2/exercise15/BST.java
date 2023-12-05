package com.claudhart.algs4.chapter3.section2.exercise15;

import com.claudhart.algs4.chapter3.section1.OrderedST;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BST<Key extends Comparable<Key>, Value> implements OrderedST<Key, Value> {
    private Node root;

    private class Node {
        private Key key;
        private Value val;
        private Node left, right;
        private int N;
        private boolean examined = false;

        public Node(Key key, Value val, int N) {
            this.key = key;
            this.val = val;
            this.N = N;
        }
    }

    @Override
    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if (x == null) return 0;
        else return x.N;
    }

    @Override
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

    @Override
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

    @Override
    public Key min() {
        Node x = root;
        while (x != null) {
            if (x.left == null) return x.key;
            x = x.left;
        }
        return null;
    }

    // tag::snippet[]
    private Node min(Node x) {
        while (x != null) {
            if (x.left == null) return x;
            x = x.left;
        }
        return null;
    }

    @Override
    public Key max() {
        Node x = root;
        while (x != null) {
            if (x.right == null) return x.key;
            x = x.right;
        }
        return null;
    }

    @Override
    public Key floor(Key key) {
        Node x = root;
        while (x != null) {
            x.examined = true;
            int cmp = key.compareTo(x.key);
            if (cmp == 0) return x.key;
            if (cmp < 0) x = x.left;
            else {
                if (x.right == null) return x.key;
                if (key.compareTo(x.right.key) < 0) return x.key;
                x = x.right;
            }
        }
        return null;
    }

    @Override
    public Key ceiling(Key key) {
        Node x = root;
        while (x != null) {
            x.examined = true;
            int cmp = key.compareTo(x.key);
            if (cmp == 0) return x.key;
            if (cmp > 0) x = x.right;
            else {
                if (x.left == null) return x.key;
                if (key.compareTo(x.left.key) > 0) return x.key;
                x = x.left;
            }
        }
        return null;
    }

    @Override
    public Key select(int k) {
        Node x = root;
        while (x != null) {
            x.examined = true;
            int t = size(x.left);
            if (k == t) return x.key;
            if (k < t) x = x.left;
            else {
                x = x.right;
                k = k - t - 1;
            }
        }
        return null;
    }

    @Override
    public int rank(Key key) {
        Node x = root;
        int t = 0;
        while (x != null) {
            x.examined = true;
            int cmp = key.compareTo(x.key);
            if (cmp == 0) return t + size(x.left);
            if (cmp < 0) x = x.left;
            else {
                t += size(x.left) + 1;
                x = x.right;
            }
        }
        return t;
    }
    // end::snippet[]

    @Override
    public void deleteMin() {
        root = deleteMin(root);
    }

    private Node deleteMin(Node x) {
        if (x.left == null) return x.right;
        x.left = deleteMin(x.left);
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    @Override
    public void deleteMax() {
        root = deleteMax(root);
    }

    private Node deleteMax(Node x) {
        if (x.right == null) return x.left;
        x.right = deleteMax(x.right);
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    @Override
    public void delete(Key key) {
        root = delete(root, key);
    }

    private Node delete(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = delete(x.left, key);
        else if (cmp > 0) x.right = delete(x.right, key);
        else {
            if (x.right == null) return x.left;
            if (x.left == null) return x.right;
            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    @Override
    public Iterable<Key> keys() {
        return keys(min(), max());
    }

    @Override
    public Iterable<Key> keys(Key lo, Key hi) {
        Queue<Key> queue = new LinkedList<>();
        keys(root, queue, lo, hi);
        return queue;
    }

    private void keys(Node x, Queue<Key> queue, Key lo, Key hi) {
        if (x == null) return;
        x.examined = true;
        int cmplo = lo.compareTo(x.key);
        int cmphi = hi.compareTo(x.key);
        if (cmplo < 0) keys(x.left, queue, lo, hi);
        if (cmplo <= 0 && cmphi >= 0) queue.add(x.key);
        if (cmphi > 0) keys(x.right, queue, lo, hi);
    }

    @Override
    public boolean contains(Key key) {
        return get(key) != null;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public int size(Key lo, Key hi) {
        if (lo.compareTo(hi) > 0) return 0;
        if (contains(hi)) return rank(hi) - rank(lo) + 1;
        else return rank(hi) - rank(lo);
    }

    private void print() {
        print(root);
        System.out.println();
    }

    private void print(Node x) {
        if (x == null) return;
        print(x.left);
        System.out.print(x.key + " ");
        print(x.right);
    }

    private void printTree(StringBuilder sb, Node x, String prefix, boolean isRoot, boolean isLeft, boolean hasSibling) {
        if (x == null) return;
        sb.append(prefix);
        String pointer = isLeft ? "┄┄┄" : "───";
        if (!isRoot) sb.append(hasSibling ? "├" + pointer : "└" + pointer);
        String examined = x.examined ? "✓" : "";
        sb.append(x.key).append(examined).append("\n");
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

    private void clearExamined() {
        clearExamined(root);
    }

    private void clearExamined(Node x) {
        if (x == null) return;
        x.examined = false;
        clearExamined(x.left);
        clearExamined(x.right);
    }

    public static void main(String[] args) {
        BST<String, Integer> bst = new BST<>();
        Arrays.stream("E D Q A J T M S".split(" ")).forEach(s -> bst.put(s, (int) s.charAt(0)));

        System.out.print("Sorted keys: ");
        bst.print();

        System.out.println("floor(\"Q\"): " + bst.floor("Q"));
        System.out.println(bst);
        bst.clearExamined();

        System.out.println("select(5): " + bst.select(5));
        System.out.println(bst);
        bst.clearExamined();

        System.out.println("ceiling(\"Q\"): " + bst.ceiling("Q"));
        System.out.println(bst);
        bst.clearExamined();

        System.out.println("rank(\"J\"): " + bst.rank("J"));
        System.out.println(bst);
        bst.clearExamined();

        System.out.println("size(\"D\", \"T\"): " + bst.size("D", "T"));
        System.out.println(bst);
        bst.clearExamined();

        System.out.println("keys(\"D\", \"T\"): " + bst.keys("D", "T"));
        System.out.println(bst);
        bst.clearExamined();
    }
}
