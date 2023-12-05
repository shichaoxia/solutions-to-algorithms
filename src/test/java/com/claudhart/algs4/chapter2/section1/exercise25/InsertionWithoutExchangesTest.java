package com.claudhart.algs4.chapter2.section1.exercise25;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class InsertionWithoutExchangesTest {

    @Test
    void sort() {
        int N = StdRandom.uniform(10, 100);
        Integer[] a = new Integer[N];
        for (int i = 0; i < N; i++) {
            a[i] = i;
        }
        StdRandom.shuffle(a);
        InsertionWithoutExchanges.sort(a);
        assertTrue(InsertionWithoutExchanges.isSorted(a));
    }

    @Test
    void moveToRightOnePosition() {
        Integer[] a = {1, 6, 9, 5, 4, 7};
        Integer[] b = {1, 6, 6, 9, 5, 7};
        InsertionWithoutExchanges.moveToRightOnePosition(a, 1, 3);
        assertArrayEquals(a, b);
    }
}