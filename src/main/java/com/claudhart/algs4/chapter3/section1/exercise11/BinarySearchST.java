package com.claudhart.algs4.chapter3.section1.exercise11;


import com.claudhart.algs4.chapter1.section3.Queue;
import com.claudhart.algs4.chapter3.section1.OrderedST;
import com.claudhart.algs4.chapter3.section1.ST;

@SuppressWarnings("DuplicatedCode")
public class BinarySearchST<Key extends Comparable<Key>, Value> implements OrderedST<Key, Value> {
    private final Key[] keys;
    private final Value[] vals;
    private int N;
    private int comparesNum;

    @SuppressWarnings("unchecked")
    public BinarySearchST(int capacity) {
        keys = (Key[]) new Comparable[capacity];
        vals = (Value[]) new Object[capacity];
    }

    public static void main(String[] args) {
        String[] keys = {"E", "A", "S", "Y", "Q", "U", "T", "I", "O", "N"};
        ST<String, Integer> st = new BinarySearchST<>(keys.length);
        System.out.printf("%-6s | %-14s | %-69s%n", "Insert", "Total compares", "After insert");
        for (int i = 0; i < keys.length; i++)
            st.put(keys[i], i);
    }

    public int rank(Key key) {
        int lo = 0, hi = N - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            int cmp = compareTo(key, keys[mid]);
            if (cmp < 0) hi = mid - 1;
            else if (cmp > 0) lo = mid + 1;
            else return mid;
        }
        return lo;
    }

    private int compareTo(Key key1, Key key2) {
        comparesNum++;
        return key1.compareTo(key2);
    }

    @Override
    public Key select(int k) {
        return keys[k];
    }

    @SuppressWarnings("unused")
    @Override
    public void deleteMin() {
        delete(min());
    }

    @SuppressWarnings("unused")
    @Override
    public void deleteMax() {
        delete(max());
    }

    @Override
    public int size(Key lo, Key hi) {
        if (hi.compareTo(lo) < 0) return 0;
        else if (contains(hi)) return rank(hi) - rank(lo) + 1;
        else return rank(hi) - rank(lo);
    }

    @Override
    public Iterable<Key> keys(Key lo, Key hi) {
        Queue<Key> q = new Queue<>();
        for (int i = rank(lo); i < rank(hi); i++)
            q.enqueue(keys[i]);
        if (contains(hi))
            q.enqueue(keys[rank(hi)]);
        return q;
    }

    @Override
    public void put(Key key, Value val) {
        int i = rank(key);
        if (i < N && compareTo(keys[i], key) == 0) {
            vals[i] = val;
            return;
        }
        for (int j = N; j > i; j--) {
            keys[j] = keys[j - 1];
            vals[j] = vals[j - 1];
        }
        keys[i] = key;
        vals[i] = val;
        N++;
        System.out.printf("%6s | %14s | %69s%n", "{" + key + ", " + val + "}", comparesNum, this);
    }

    @Override
    public Value get(Key key) {
        if (isEmpty()) return null;
        int i = rank(key);
        if (i < N && keys[i].compareTo(key) == 0) return vals[i];
        else return null;
    }

    @Override
    public void delete(Key key) {

    }

    @Override
    public boolean contains(Key key) {
        return get(key) != null;
    }

    @Override
    public boolean isEmpty() {
        return N == 0;
    }

    @Override
    public int size() {
        return N;
    }

    @Override
    public Key min() {
        return keys[0];
    }

    @Override
    public Key max() {
        return keys[N - 1];
    }

    @Override
    public Key floor(Key key) {
        int i = rank(key);
        if (i == 0) return null;
        return keys[i - 1];
    }

    @Override
    public Key ceiling(Key key) {
        int i = rank(key);
        if (i == N) return null;
        return keys[i];
    }

    @Override
    public Iterable<Key> keys() {
        return keys(min(), max());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append("{").append(keys[i]).append(", ").append(vals[i]).append("}");
            if (i != N - 1) sb.append(" ");
        }
        return sb.toString();
    }
}
