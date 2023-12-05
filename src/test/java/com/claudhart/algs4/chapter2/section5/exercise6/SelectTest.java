package com.claudhart.algs4.chapter2.section5.exercise6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SelectTest {

    @Test
    void select() {
        Integer[] a = {1, 2, 3, 4, 5, 6, 7, 8};
        assertEquals(1, Select.select(a, 0));
        assertEquals(2, Select.select(a, 1));
        assertEquals(3, Select.select(a, 2));
        assertEquals(4, Select.select(a, 3));
        assertEquals(5, Select.select(a, 4));
        assertEquals(6, Select.select(a, 5));
        assertEquals(7, Select.select(a, 6));
        assertEquals(8, Select.select(a, 7));
    }
}