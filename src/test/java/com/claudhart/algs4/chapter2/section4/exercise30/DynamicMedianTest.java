package com.claudhart.algs4.chapter2.section4.exercise30;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DynamicMedianTest {

    @Test
    void insert() {
        DynamicMedian<Integer> dynamicMedian = new DynamicMedian<>(10);
        for (int i = 0; i < 10; i++) {
            dynamicMedian.insert(i + 1);
        }
        assertEquals(5, dynamicMedian.findMedian());
        assertEquals(5, dynamicMedian.deleteMedian());
        assertEquals(6, dynamicMedian.deleteMedian());
        assertEquals(4, dynamicMedian.deleteMedian());
        assertEquals(7, dynamicMedian.deleteMedian());
        assertEquals(3, dynamicMedian.deleteMedian());
        assertEquals(8, dynamicMedian.deleteMedian());
        assertEquals(2, dynamicMedian.deleteMedian());
        assertEquals(9, dynamicMedian.deleteMedian());
        assertEquals(1, dynamicMedian.deleteMedian());
        assertEquals(10, dynamicMedian.deleteMedian());
    }
}