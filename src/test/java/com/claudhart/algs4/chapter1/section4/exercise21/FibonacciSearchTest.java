package com.claudhart.algs4.chapter1.section4.exercise21;

import com.claudhart.algs4.chapter1.section4.exercise22.FibonacciSearch;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FibonacciSearchTest {

    @Test
    void search() {
        int[] a = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        assertEquals(7, FibonacciSearch.search(7, a));
        assertEquals(0, FibonacciSearch.search(0, a));
        assertEquals(10, FibonacciSearch.search(10, a));
        assertEquals(11, FibonacciSearch.search(11, a));
        assertEquals(-1, FibonacciSearch.search(12, a));
        assertEquals(-1, FibonacciSearch.search(-1, a));
        int[] b = {2};
        assertEquals(-1, FibonacciSearch.search(3, b));
        assertEquals(-1, FibonacciSearch.search(1, b));
        assertEquals(0, FibonacciSearch.search(2, b));
        int[] c = {};
        assertEquals(-1, FibonacciSearch.search(3, c));
    }
}