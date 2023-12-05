package com.claudhart.algs4.chapter3.section2.exercise7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BSTTest {

    @Test
    void internalPathLength() {
        BST<Integer, Integer> bst = new BST<>();
        bst.put(5, 5);
        assertEquals(0, bst.internalPathLength());
        bst.put(3, 3);
        assertEquals(1, bst.internalPathLength());
        bst.put(7, 7);
        assertEquals(2, bst.internalPathLength());
        bst.put(2, 2);
        assertEquals(4, bst.internalPathLength());
        bst.put(4, 4);
        assertEquals(6, bst.internalPathLength());
        bst.put(6, 6);
        assertEquals(8, bst.internalPathLength());
        bst.put(8, 8);
        assertEquals(10, bst.internalPathLength());
    }
}