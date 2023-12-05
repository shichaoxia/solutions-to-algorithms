package com.claudhart.algs4.chapter1.section4.exercise20;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class BitonicSearchTest {
    @Test
    void testSearchPeek() {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 10, 6, 2};
        assertEquals(8, BitonicSearch.searchPeek(a));
        int[] b = {1, 2};
        assertEquals(1, BitonicSearch.searchPeek(b));
        int[] c = {2, 1};
        assertEquals(0, BitonicSearch.searchPeek(c));
    }

    @Test
    void searchMaximum() {
        int[] a = {1, 3, 5, 6, 8, 10, 7, 2};
        assertEquals(7, BitonicSearch.searchMaximum(a, 2));
        int[] b = {1, 2};
        assertEquals(0, BitonicSearch.searchMaximum(b, 1));
        int[] c = {2, 1};
        assertEquals(1, BitonicSearch.searchMaximum(c, 1));
    }
}
