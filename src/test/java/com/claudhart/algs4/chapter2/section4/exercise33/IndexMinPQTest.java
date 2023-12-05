package com.claudhart.algs4.chapter2.section4.exercise33;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@SuppressWarnings("CommentedOutCode")
class IndexMinPQTest {

    @Test
    void insert() {
        IndexMinPQ<String> pq = new IndexMinPQ<>(10);
        for (int i = 0; i < 10; i++)
            pq.insert(i + 1, Character.toString((char) ('J' - i)));
//        System.out.println(">Insert J to A");
//        pq.printHeap();
//        System.out.println(Arrays.toString(pq.keys));
        assertTrue(pq.contains(5));
        pq.change(10, "Z");
//        System.out.println(">Change 10 to Z");
        pq.change(1, "Y");
//        System.out.println(">Change 1 to Y");
//        pq.printHeap();
//        System.out.println(Arrays.toString(pq.keys));
        pq.delete(5);
//        System.out.println(">Delete 5");
//        pq.printHeap();
//        System.out.println(Arrays.toString(pq.keys));
        assertFalse(pq.contains(5));
        assertEquals("B", pq.min());
        assertEquals(9, pq.minIndex());
        assertEquals("B", pq.delMin());
//        pq.printHeap();
//        System.out.println(Arrays.toString(pq.keys));
    }
}