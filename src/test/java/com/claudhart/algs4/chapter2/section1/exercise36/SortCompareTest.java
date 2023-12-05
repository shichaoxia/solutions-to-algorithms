package com.claudhart.algs4.chapter2.section1.exercise36;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import com.claudhart.algs4.chapter2.section1.exercise36.SortCompare;

class SortCompareTest {

    @Test
    void halfZeroHalfOne() {
        Integer[] a = SortCompare.halfZeroHalfOne(10);
        assertArrayEquals(new Integer[]{0, 0, 0, 0, 0, 1, 1, 1, 1, 1}, a);
    }

    @Test
    void halfZeroHalfReminder() {
        Integer[] a = SortCompare.halfZeroHalfReminder(10);
        assertArrayEquals(new Integer[]{0, 0, 0, 0, 0, 1, 1, 2, 3, 4}, a);
    }

    @Test
    void halfZeroHalfRandom() {
        int k = 10 / 2;
        Integer[] a = SortCompare.halfZeroHalfRandom(10);
        for (int i = 0; i < k; i++) assertEquals(0, a[i]);
        for (int i = k; i < 10; i++) assertTrue(0 <= a[i] && a[i] <= 1_000_000 - 1);
    }
}