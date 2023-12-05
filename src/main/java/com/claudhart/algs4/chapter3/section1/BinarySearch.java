package com.claudhart.algs4.chapter3.section1;

@SuppressWarnings("unused")
public class BinarySearch<Key extends Comparable<Key>> {
    @SuppressWarnings("unused")
    public Key[] keys;

    // tag::snippet[]
    @SuppressWarnings("unused")
    public int rank(Key key, int lo, int hi) {
        if (hi < lo) return lo;
        int mid = (lo + hi) / 2;
        int cmp = key.compareTo(keys[mid]);
        if (cmp < 0)
            return rank(key, lo, mid - 1);
        else if (cmp > 0)
            return rank(key, mid + 1, hi);
        else return mid;
    }
    // end::snippet[]
}
