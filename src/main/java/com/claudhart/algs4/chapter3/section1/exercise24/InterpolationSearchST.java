package com.claudhart.algs4.chapter3.section1.exercise24;

import com.claudhart.algs4.chapter3.section1.BinarySearchST;
import com.claudhart.algs4.chapter3.section1.OrderedST;
import com.claudhart.algs4.chapter3.section1.ST;
import edu.princeton.cs.algs4.Stopwatch;

import java.util.stream.IntStream;

@SuppressWarnings("DuplicatedCode")
public class InterpolationSearchST<Key extends Number & Comparable<Key>, Value> implements OrderedST<Key, Value> {
    private static final int INIT_CAPACITY = 2;
    private Key[] keys;
    private Value[] vals;
    private int N;

    public InterpolationSearchST() {
        this(INIT_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public InterpolationSearchST(int capacity) {
        keys = (Key[]) new Number[capacity];
        vals = (Value[]) new Object[capacity];
    }

    // tag::snippet[]
    @Override
    public int rank(Key key) {
        if (key == null) throw new IllegalArgumentException("key cannot be null");
        int lo = 0, hi = N - 1;
        while (lo <= hi) {
            int split = (lo == hi) ? lo : lo + (hi - lo) * (key.intValue() - keys[lo].intValue()) / (keys[hi].intValue() - keys[lo].intValue());
            if (split > hi) split = hi;
            else if (split < lo) split = lo;

            int cmp = key.compareTo(keys[split]);
            if (cmp < 0) hi = split - 1;
            else if (cmp > 0) lo = split + 1;
            else return split;
        }
        return lo;
    }

    @Override
    public void put(Key key, Value val) {
        if (key == null) throw new IllegalArgumentException("first argument to put() is null");

        if (val == null) {
            delete(key);
            return;
        }

        int i = rank(key);

        if (i < N && keys[i].compareTo(key) == 0) {
            vals[i] = val;
            return;
        }

        if (N == keys.length) resize(2 * keys.length);

        for (int j = N; j > i; j--) {
            keys[j] = keys[j - 1];
            vals[j] = vals[j - 1];
        }
        keys[i] = key;
        vals[i] = val;
        N++;
    }
    // end::snippet[]

    @Override
    public Value get(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to get() is null");
        if (isEmpty()) return null;
        int i = rank(key);
        if (i < N && keys[i].compareTo(key) == 0) return vals[i];
        return null;
    }

    @SuppressWarnings("unchecked")
    private void resize(int capacity) {
        Key[] tempK = (Key[]) new Number[capacity];
        Value[] tempV = (Value[]) new Object[capacity];
        for (int i = 0; i < N; i++) {
            tempK[i] = keys[i];
            tempV[i] = vals[i];
        }
        vals = tempV;
        keys = tempK;
    }

    /******************* Test client *******************/

    public static void main(String[] args) {
        printHeader();
        for (int N = 1_000; N <= 100_000; N*=10) {
            double iTime = trial(N, new InterpolationSearchST<>());
            double bTime = trial(N, new BinarySearchST<>());
            printRow(N, iTime, bTime);
        }
    }

    private static double trial(int N, ST<Integer,String> st) {
        Stopwatch timer = new Stopwatch();
        IntStream.range(0, N).forEach(i -> st.put(i, "val" + i));
        IntStream.range(0, N).forEach(st::get);
        return timer.elapsedTime();
    }

    private static void printHeader() {
        System.out.printf("%6s | %21s | %14s\n", "N", "InterpolationSearchST", "BinarySearchST");
    }

    private static void printRow(int N, double iTime, double bTime) {
        System.out.printf("%6d | %21.3f | %14.3f\n", N, iTime, bTime);
    }

    /******************* Not implemented *******************/

    @Override
    public void delete(Key key) {

    }

    @Override
    public boolean contains(Key key) {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Key min() {
        return null;
    }

    @Override
    public Key max() {
        return null;
    }

    @Override
    public Key floor(Key key) {
        return null;
    }

    @Override
    public Key ceiling(Key key) {
        return null;
    }

    @Override
    public Key select(int k) {
        return null;
    }

    @Override
    public void deleteMin() {

    }

    @Override
    public void deleteMax() {

    }

    @Override
    public int size(Key lo, Key hi) {
        return 0;
    }

    @Override
    public Iterable<Key> keys(Key lo, Key hi) {
        return null;
    }

    @Override
    public Iterable<Key> keys() {
        return null;
    }
}
