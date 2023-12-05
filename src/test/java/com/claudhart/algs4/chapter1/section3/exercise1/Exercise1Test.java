package com.claudhart.algs4.chapter1.section3.exercise1;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.claudhart.algs4.chapter1.section3.exercise1.Exercise1.FixedCapacityStackOfStrings;

public class Exercise1Test {
    @Test
    void testIsFull() {
        FixedCapacityStackOfStrings s = new FixedCapacityStackOfStrings(3);
        s.push("item0");
        assertTrue(!s.isFull());
        s.push("item1");
        assertTrue(!s.isFull());
        s.push("item2");
        assertTrue(s.isFull());
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> s.push("item3"));
    }
}
