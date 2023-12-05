package com.claudhart.algs4.chapter3.section1.exercise12;

import com.claudhart.algs4.chapter3.section1.OrderedST;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchST<Key extends Comparable<Key>, Value> implements OrderedST<Key, Value> {

    // tag::snippet[]
    private final List<Item<Key, Value>> items;
    private int N;

    public BinarySearchST(List<Item<Key, Value>> items) {
        this.items = items;
        this.N = items.size();
        items.sort(Item::compareTo);
    }

    @Override
    public int rank(Key key) {
        int lo = 0, hi = N - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            int cmp = key.compareTo(items.get(mid).key);
            if (cmp < 0) hi = mid - 1;
            else if (cmp > 0) lo = mid + 1;
            else return mid;
        }
        return lo;
    }

    @Override
    public void put(Key key, Value val) {
        int i = rank(key);
        if (i < N && items.get(i).key.compareTo(key) == 0) {
            items.get(i).value = val;
            return;
        }
        for (int j = N; j > i; j--)
            items.set(j, items.get(j - 1));
        items.set(i, new Item<>(key, val));
        N++;
    }

    @Override
    public Value get(Key key) {
        if (isEmpty()) return null;
        int i = rank(key);
        if (i < N && items.get(i).key.compareTo(key) == 0)
            return items.get(i).value;
        return null;
    }

    @Override
    public boolean isEmpty() {
        return N == 0;
    }

    @Override
    public int size() {
        return N;
    }

    public static class Item<Key extends Comparable<Key>, Value> implements Comparable<Item<Key, Value>> {
        final Key key;
        Value value;

        Item(Key key, Value value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public int compareTo(Item<Key, Value> o) {
            return key.compareTo(o.key);
        }
    }
    // end::snippet[]

    public static void main(String[] args) {
        List<Item<Integer, String>> items = new ArrayList<>();
        items.add(new Item<>(5, "five"));
        items.add(new Item<>(1, "one"));
        items.add(new Item<>(3, "three"));
        items.add(new Item<>(2, "two"));
        items.add(new Item<>(4, "four"));
        BinarySearchST<Integer, String> st = new BinarySearchST<>(items);
        System.out.println(st.get(1));
        System.out.println(st.get(2));
        System.out.println(st.get(3));
        System.out.println(st.get(4));
        System.out.println(st.get(5));
        st.put(1, "ONE");
        System.out.println(st.get(1));
        st.put(2, "TWO");
        System.out.println(st.get(2));
    }

    @Override
    public boolean contains(Key key) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @SuppressWarnings("unused")
    @Override
    public void delete(Key key) {
        throw new UnsupportedOperationException("Not implemented yet");
    }


    @Override
    public Key min() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public Key max() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public Key floor(Key key) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public Key ceiling(Key key) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public Key select(int k) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @SuppressWarnings("unused")
    @Override
    public void deleteMin() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @SuppressWarnings("unused")
    @Override
    public void deleteMax() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public int size(Key lo, Key hi) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public Iterable<Key> keys(Key lo, Key hi) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public Iterable<Key> keys() {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
