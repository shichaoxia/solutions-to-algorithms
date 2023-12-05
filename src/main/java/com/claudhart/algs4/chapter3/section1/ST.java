package com.claudhart.algs4.chapter3.section1;

public interface ST<Key, Value> {
    void put(Key key, Value val);

    Value get(Key key);

    @SuppressWarnings("unused")
    void delete(Key key);

    boolean contains(Key key);

    @SuppressWarnings("unused")
    boolean isEmpty();

    int size();

    Iterable<Key> keys();
}
