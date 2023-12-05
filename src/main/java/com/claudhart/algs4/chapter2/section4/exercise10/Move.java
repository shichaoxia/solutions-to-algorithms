package com.claudhart.algs4.chapter2.section4.exercise10;

@SuppressWarnings("unused")
public class Move {
    // tag::snippet[]
    @SuppressWarnings("unused")
    public int parent(int k) {
        return (k - 1) / 2;
    }

    @SuppressWarnings("unused")
    public int leftChild(int k) {
        return 2 * k + 1;
    }

    @SuppressWarnings("unused")
    public int rightChild(int k) {
        return 2 * k + 2;
    }
    // end::snippet[]
}
