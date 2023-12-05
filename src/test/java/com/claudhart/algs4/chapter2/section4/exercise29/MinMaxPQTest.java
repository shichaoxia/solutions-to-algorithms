package com.claudhart.algs4.chapter2.section4.exercise29;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinMaxPQTest {

    @Test
    void insert() {
        int N = 10;
        MinMaxPQ minMaxPQ = new MinMaxPQ(N);
        Integer[] a = new Integer[N];
        for (int i = 0; i < N; i++) a[i] = i + 1;
        StdRandom.shuffle(a);
        for (int x : a) minMaxPQ.insert(x);

        assertEquals(10, minMaxPQ.size());
        assertEquals(1, minMaxPQ.findMin());
        assertEquals(10, minMaxPQ.findMax());
        assertEquals(1, minMaxPQ.delMin());
        assertEquals(10, minMaxPQ.delMax());
        assertEquals(8, minMaxPQ.size());
        assertEquals(2, minMaxPQ.findMin());
        assertEquals(9, minMaxPQ.findMax());
        assertEquals(2, minMaxPQ.delMin());
        assertEquals(9, minMaxPQ.delMax());
        assertEquals(6, minMaxPQ.size());
        assertEquals(3, minMaxPQ.findMin());
        assertEquals(8, minMaxPQ.findMax());
        assertEquals(3, minMaxPQ.delMin());
        assertEquals(8, minMaxPQ.delMax());
        assertEquals(4, minMaxPQ.size());
        assertEquals(4, minMaxPQ.findMin());
        assertEquals(7, minMaxPQ.findMax());
        assertEquals(4, minMaxPQ.delMin());
        assertEquals(7, minMaxPQ.delMax());
        assertEquals(2, minMaxPQ.size());
        assertEquals(5, minMaxPQ.findMin());
        assertEquals(6, minMaxPQ.findMax());
        assertEquals(5, minMaxPQ.delMin());
        assertEquals(6, minMaxPQ.delMax());
        assertEquals(0, minMaxPQ.size());
    }
}