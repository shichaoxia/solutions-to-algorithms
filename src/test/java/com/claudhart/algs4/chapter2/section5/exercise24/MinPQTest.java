package com.claudhart.algs4.chapter2.section5.exercise24;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinPQTest {

    @Test
    void delMin() {
        int N = 10;
        MinPQ<MinPQ.Item> pq = new MinPQ<>(N);
        for (int i = 0; i < N; i++) {
            MinPQ.Item item = new MinPQ.Item("item", i);
            pq.insert(item);
        }
        for (int i = 0; i < N; i++) {
            MinPQ.Item item = pq.delMin();
            assertEquals(i, item.id);
        }
    }
}