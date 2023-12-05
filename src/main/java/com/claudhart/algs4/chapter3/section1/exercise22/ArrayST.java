package com.claudhart.algs4.chapter3.section1.exercise22;

import com.claudhart.algs4.chapter3.section1.ST;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;


public class ArrayST<Key, Value> implements ST<Key, Value> {

    private final static int NOT_FOUND = -1;
    private final static int INIT_CAPACITY = 8;
    private Key[] keys;
    private Value[] values;

    private int N;

    @SuppressWarnings("unchecked")
    public ArrayST() {
        keys = (Key[]) new Object[INIT_CAPACITY];
        values = (Value[]) new Object[INIT_CAPACITY];
    }

    public static void main(String[] args) {

    }

    @Override
    public void put(Key key, Value val) {
        if (key == null) throw new IllegalArgumentException("key cannot be null");
        if (val == null) {
            delete(key);
            return;
        }

        int i = find(key);
        if (i != NOT_FOUND) {
            values[i] = val;
            return;
        }

        resizeIfNeeded();

        keys[N] = key;
        values[N] = val;
        N++;
    }

    @Override
    public Value get(Key key) {
        if (key == null) throw new IllegalArgumentException("key cannot be null");
        if (isEmpty()) return null;
        int i = find(key);
        if (i == NOT_FOUND) return null;
        Value result = values[i];
        shiftRightFromStart(i);
        keys[0] = key;
        values[0] = result;
        return result;
    }

    @Override
    public void delete(Key key) {
        if (key == null) throw new IllegalArgumentException("key cannot be null");
        if (isEmpty()) return;
        int i = find(key);
        if (i == NOT_FOUND) return;
        shiftLeftTillEnd(i);
        N--;
        resizeIfNeeded();
    }

    private int find(Key key) {
        for (int i = 0; i < N; i++) {
            if (keys[i].equals(key)) return i;
        }
        return NOT_FOUND;
    }

    /*
    before shift:
     s  e
    ♥ΔΔΔ ♥♥
    after shift:
     s  e
    ♥ ΔΔΔ♥♥
    */
    private void shiftRight(int start, int end) {
        for (int i = start + 1; i <= end; i++) {
            keys[i] = keys[i - 1];
            values[i] = values[i - 1];
        }
        keys[start] = null;
        values[start] = null;
    }

    private void shiftRightFromStart(int end) {
        shiftRight(0, end);
    }

    /*
    before shift:
       s  e
    ♥♥♥ ΔΔΔ
    after shift:
       s  e
    ♥♥♥ΔΔΔ
    */
    private void shiftLeft(int start, int end) {
        for (int i = start; i <= end - 1; i++) {
            keys[i] = keys[i + 1];
            values[i] = values[i + 1];
        }
        keys[end] = null;
        values[end] = null;
    }

    private void shiftLeftTillEnd(int start) {
        shiftLeft(start, N - 1);
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
    public Iterable<Key> keys() {
        List<Key> list = new ArrayList<>();
        IntStream.range(0, N).forEach(i -> list.add(keys[i]));
        return list;
    }

    @SuppressWarnings("unchecked")
    private void resize(int capacity) {
        Key[] tempKeys = (Key[]) new Object[capacity];
        Value[] tempValues = (Value[]) new Object[capacity];

        System.arraycopy(keys, 0, tempKeys, 0, N);
        System.arraycopy(values, 0, tempValues, 0, N);

        keys = tempKeys;
        values = tempValues;
    }

    private void resizeIfNeeded() {
        if (0 < N && N == keys.length / 4) {
            resize(keys.length / 2);
            return;
        }
        if (N == keys.length) {
            resize(2 * keys.length);
        }
    }
}
