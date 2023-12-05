package com.claudhart.algs4.chapter2.section2.exercise16;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NaturalMergesortTest {

    @Test
    void sort() {
        Integer[] a = {6, 8, 7, 1, 2, 3, 9, 5, 0, 4};
        NaturalMergesort.sort(a);
//        StdOut.println(Arrays.toString(a));
    }

    @Test
    void findSortedSubarray() {
        Integer[] a = {6, 8, 7, 1, 2, 3, 9, 5, 0, 4};
        assertEquals(1,NaturalMergesort.findSortedSubarray(a, 0));
        assertEquals(1,NaturalMergesort.findSortedSubarray(a, 1));
        assertEquals(2,NaturalMergesort.findSortedSubarray(a, 2));
        assertEquals(6,NaturalMergesort.findSortedSubarray(a, 3));
        assertEquals(9,NaturalMergesort.findSortedSubarray(a, 9));
    }
}