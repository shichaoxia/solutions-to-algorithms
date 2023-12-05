package com.claudhart.algs4.chapter1.section3;

public class FixedCapacityStackOfInts {
    private final int[] a;
    private int N;

    public FixedCapacityStackOfInts(int cap) {
        a = new int[cap];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    @SuppressWarnings("unused")
    public int size() {
        return N;
    }

    public void push(int item) {
        a[N++] = item;
    }

    @SuppressWarnings("UnusedReturnValue")
    public int pop() {
        return a[--N];
    }
}
