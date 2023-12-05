package com.claudhart.algs4.chapter3.section1;

public interface OrderedST<Key extends Comparable<Key>, Value> extends ST<Key, Value> {
    void put(Key key, Value val);

    Value get(Key key);

    @SuppressWarnings("unused")
    void delete(Key key);

    boolean contains(Key key);

    @SuppressWarnings("unused")
    boolean isEmpty();

    int size();

    Key min();

    Key max();

    Key floor(Key key);

    Key ceiling(Key key);

    int rank(Key key);

    Key select(int k);

    @SuppressWarnings("unused")
    void deleteMin();

    @SuppressWarnings("unused")
    void deleteMax();

    int size(Key lo, Key hi);

    Iterable<Key> keys(Key lo, Key hi);

    Iterable<Key> keys();
}
