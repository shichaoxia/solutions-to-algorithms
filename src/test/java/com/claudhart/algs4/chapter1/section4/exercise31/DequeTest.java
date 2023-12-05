package com.claudhart.algs4.chapter1.section4.exercise31;

import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class DequeTest {

    @Test
    void testAddRemoveOperations() {
        Deque<Integer> q = new Deque<>();
        IntStream.rangeClosed(1, 3).forEachOrdered(q::addFirst);
        IntStream.rangeClosed(4, 6).forEachOrdered(q::addLast);
        assertEquals("[1, 2, 3][4, 5, 6]", q.toString());
        assertEquals(3, q.removeFirst());
        assertEquals(6, q.removeLast());
        assertFalse(q.isEmpty());
        assertEquals(4, q.size());
        assertEquals("[1, 2][4, 5]", q.toString());
    }

    @Test
    void testBalance() {
        Deque<Integer> q = new Deque<>();
        IntStream.rangeClosed(1, 5).forEachOrdered(q::addFirst);
        assertEquals("[1, 2, 3, 4, 5][]", q.toString());
        assertEquals(5, q.removeLast());
        assertEquals("[1, 2][3, 4]", q.toString());
    }

    @Test
    void testIterator() {
        Deque<Integer> q = new Deque<>();
        IntStream.rangeClosed(1, 3).forEachOrdered(q::addFirst);
        IntStream.rangeClosed(4, 6).forEachOrdered(q::addLast);
        int[] a = {1, 2, 3, 4, 5, 6};
        Iterator<Integer> qi = q.iterator();
        assertTrue(qi.hasNext());
        for (int j : a) {
            assertEquals(j, qi.next());
        }
        assertFalse(qi.hasNext());
    }
}