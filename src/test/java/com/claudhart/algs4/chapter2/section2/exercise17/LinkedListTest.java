package com.claudhart.algs4.chapter2.section2.exercise17;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    @Test
    void addFirst() {
        LinkedList a = new LinkedList();
        LinkedList b = LinkedList.fromArray(new Integer[]{2});
        LinkedList c = LinkedList.fromArray(new Integer[]{9, 5, 0, 4});
        assertEquals("1", a.addFirst(1).toString());
        assertEquals(1, a.size);
        assertEquals("12", b.addFirst(1).toString());
        assertEquals("19504", c.addFirst(1).toString());
    }

    @Test
    void concatenate() {
        LinkedList a = LinkedList.fromArray(new Integer[]{1, 2, 3});
        LinkedList b = LinkedList.fromArray(new Integer[]{4, 5, 6});
        LinkedList c = LinkedList.concatenate(a, b);
        assertEquals("123456", c.toString());
        assertEquals(6, c.size);
    }

    @Test
    void removeFirst() {
        LinkedList l = LinkedList.fromArray(new Integer[]{0, 1, 2});
        assertEquals(0, l.removeFirst());
        assertEquals(2, l.size);
        assertEquals(1, l.removeFirst());
        assertEquals(2, l.removeFirst());
        assertEquals(0, l.size);
        assertNull(l.removeFirst());
    }

    @Test
    void addLast() {
        LinkedList l = LinkedList.fromArray(new Integer[]{0, 1, 2});
        l.addLast(5);
        l.addLast(6);
        assertEquals("01256", l.toString());
        assertEquals(5, l.size);
    }

    @Test
    void count() {
        LinkedList l = LinkedList.fromArray(new Integer[]{0, 1, 2});
        assertEquals(1, l.count(l.first));
        assertEquals(3, l.count(l.first.next.next));
        assertThrows(RuntimeException.class, () -> l.count(null));
    }

    @Test
    void splitAfter() {
        LinkedList l = LinkedList.fromArray(new Integer[]{0, 1, 2, 3, 4});
        LinkedList b = l.splitAfter(l.first.next.next);
        assertEquals("012", b.toString());
        assertEquals(3, b.size);
        assertEquals("34", l.toString());
        assertEquals(2, l.size);
        LinkedList c = l.splitAfter(l.first.next);
        assertEquals("34", c.toString());
        assertEquals("", l.toString());
    }

    @Test
    void findSortedSegment() {
        LinkedList l = new LinkedList();
        assertNull(l.findSortedSegment());
        l.addLast(4);
        assertEquals(4, l.findSortedSegment().item);
        l.addLast(5);
        l.addLast(3);
        l.addLast(6);
        l.addLast(2);
        assertEquals(5, l.findSortedSegment().item);
    }

    @Test
    void splitSortedSegment() {
        LinkedList l = new LinkedList();
        assertEquals("", l.splitSortedSegment().toString());
        assertEquals("", l.toString());
        l.addLast(4);
        l.addLast(5);
        l.addLast(3);
        l.addLast(6);
        l.addLast(2);
        LinkedList a = l.splitSortedSegment();
        assertEquals("45", a.toString());
        assertEquals(2, a.size);
        assertEquals("362", l.toString());
        assertEquals(3, l.size);
        assertEquals("36", l.splitSortedSegment().toString());
        assertEquals("2", l.toString());
        assertEquals("2", l.splitSortedSegment().toString());
        assertEquals("", l.toString());
    }

    @Test
    void merge() {
        LinkedList a = new LinkedList();
        LinkedList b = new LinkedList();
        LinkedList c = LinkedList.merge(a, b);
        assertEquals("", c.toString());
        a.addLast(5);
        a.addLast(7);
        a.addLast(9);
        b.addLast(0);
        b.addLast(6);
        b.addLast(8);
        c = LinkedList.merge(a, b);
        assertEquals("056789", c.toString());
    }

    @Test
    void mergeList() {
        LinkedList a = LinkedList.fromArray(new Integer[]{6, 8, 7, 1, 2, 3, 9, 5, 0, 4});
        LinkedList b = LinkedList.merge(a);
        assertEquals("6781235904", b.toString());
    }

    @Test
    void sort() {
        LinkedList a = LinkedList.fromArray(new Integer[]{6, 8, 7, 1, 2, 3, 9, 5, 0, 4});
        LinkedList b = LinkedList.sort(a);
        assertEquals("0123456789", b.toString());
    }
}