package com.claudhart.algs4.chapter2.section5.exercise19;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KendallTauTest {

    @Test
    void distance() {
        int[] a = {0, 3, 1, 6, 2, 5, 4};
        int[] b = {1, 0, 3, 6, 4, 2, 5};
        assertEquals(4, KendallTau.distance(a, b));
    }
}