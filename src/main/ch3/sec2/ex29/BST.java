package ch3.sec2.ex29;

import ch3.sec1.OrderedST;

import java.util.LinkedList;
import java.util.Queue;

@SuppressWarnings("DuplicatedCode")
public class BST<Key extends Comparable<Key>, Value> implements OrderedST<Key, Value> {
    public Node root;
    
    public class Node {
        @SuppressWarnings("CanBeFinal")
        public Key key;
        public Value val;
        public Node left, right;
        public int N;
        
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
        return min(root).key;
    }
    
    private Node min(Node x) {
        if (x.left == null) return x;
        return min(x.left);
    }
    
    @Override
    public Key max() {
        return max(root).key;
    }
    
    private Node max(Node x) {
        if (x.right == null) return x;
        return max(x.right);
    }
    
    @Override
    public Key floor(Key key) {
        Node x = floor(root, key);
        if (x == null) return null;
        return x.key;
    }
    
    private Node floor(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0) return x;
        else if (cmp < 0) return floor(x.left, key);
        Node t = floor(x.right, key);
        if (t != null) return t;
        else return x;
    }
    
    @Override
    public Key ceiling(Key key) {
        Node x = ceiling(root, key);
        if (x == null) return null;
        return x.key;
    }
    
    private Node ceiling(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0) return x;
        else if (cmp > 0) return ceiling(x.right, key);
        Node t = ceiling(x.left, key);
        if (t != null) return t;
        else return x;
    }
    
    @Override
    public Key select(int k) {
        return select(root, k).key;
    }
    
    private Node select(Node x, int k) {
        if (x == null) return null;
        int t = size(x.left);
        if (t > k) return select(x.left, k);
        else if (t < k) return select(x.right, k - t - 1);
        else return x;
    }
    
    @Override
    public int rank(Key key) {
        return rank(root, key);
    }
    
    private int rank(Node x, Key key) {
        if (x == null) return 0;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) return rank(x.left, key);
        else if (cmp > 0) return 1 + size(x.left) + rank(x.right, key);
        else return size(x.left);
    }
    
    
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
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        @SuppressWarnings("rawtypes") BST other = (BST) o;
        @SuppressWarnings("unchecked") boolean result = isIdentical(root, other.root);
        return result;
    }
    
    private boolean isIdentical(Node root1, Node root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;
        if (root1.val != root2.val) return false;
        return isIdentical(root1.left, root2.left) && isIdentical(root1.right, root2.right);
    }
    
    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + calculateHashCode(root);
        return result;
    }
    
    private int calculateHashCode(Node node) {
        if (node == null) return 0;
        int result = 31 * node.val.hashCode();
        result += calculateHashCode(node.left);
        result += calculateHashCode(node.right);
        return result;
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
    
    private boolean isBinaryTree(Node x) {
        if (x == null) return true;
        int leftSize = x.left == null ? 0 : x.left.N;
        int rightSize = x.right == null ? 0 : x.right.N;
        if (x.N != leftSize + rightSize + 1) return false;
        return isBinaryTree(x.left) && isBinaryTree(x.right);
    }
    
    public boolean isBinaryTree() {
        return isBinaryTree(root);
    }

    public static void main(String[] args) {
        System.out.println("Hello and welcome!");
    }
}
