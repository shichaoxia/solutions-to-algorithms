package com.claudhart.algs4.chapter2.section3.exercise22;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class Quick3wayTest {

    @Test
    void sort() {
        Integer[] a;


        a = new Integer[]{1};
        Quick3way.sort(a);
        assertArrayEquals(new Integer[]{1}, a);
        a = new Integer[]{1, 2};
        Quick3way.sort(a);
        assertArrayEquals(new Integer[]{1, 2}, a);
        a = new Integer[]{2, 1};
        Quick3way.sort(a);
        assertArrayEquals(new Integer[]{1, 2}, a);

        for (int i = 0; i < 1_000; i++) {
            a = new Integer[]{2, 1, 2, 3, 2, 1, 2, 3, 2};
            Quick3way.sort(a);
            assertArrayEquals(new Integer[]{1, 1, 2, 2, 2, 2, 2, 3, 3}, a);
        }
    }
}