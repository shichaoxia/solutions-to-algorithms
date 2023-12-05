package com.claudhart.algs4.chapter2.section2.exercise18;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    private LinkedList a;
    private LinkedList b;
    private LinkedList c;
    private LinkedList d;


    @BeforeEach
    void setup() {
        a = LinkedList.fromArray(new Integer[]{});
        b = LinkedList.fromArray(new Integer[]{0});
        c = LinkedList.fromArray(new Integer[]{0, 1, 2, 3});
        d = LinkedList.fromArray(new Integer[]{0, 1, 2, 3, 4});
    }

    @SuppressWarnings("DataFlowIssue")
    @Test
    void removeLast() {
        assertNull(a.removeLast());
        assertEquals("", a.toString());
        assertEquals("0", b.removeLast().toString());
        assertEquals("", b.toString());
    }

    @Test
    void randomMerge() {
        LinkedList merged = LinkedList.randomMerge(a, b);
        assertEquals("0", merged.toString());
        assertEquals(1, merged.size);
    }

    @Test
    void shuffle() {
        LinkedList shuffled = LinkedList.shuffle(a);
        assertEquals("", shuffled.toString());
        assertEquals(0, shuffled.size);
        shuffled = LinkedList.shuffle(b);
        assertEquals("0", shuffled.toString());
        assertEquals(1, shuffled.size);
        shuffled = LinkedList.shuffle(c);
        assertEquals(4, shuffled.size);
    }

    @Test
    void divide() {
        LinkedList firstPart = a.divide();
        assertEquals("", firstPart.toString());
        assertEquals("", a.toString());
        firstPart = b.divide();
        assertEquals("", firstPart.toString());
        firstPart = c.divide();
        assertEquals("01", firstPart.toString());
        assertEquals(2, firstPart.size);
        firstPart = d.divide();
        assertEquals("01", firstPart.toString());
        assertEquals(2, firstPart.size);
        assertEquals("234", d.toString());
    }
}