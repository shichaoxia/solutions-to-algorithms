package com.claudhart.algs4.chapter1.section3.exercise1;

import org.junit.jupiter.api.Test;

import com.claudhart.algs4.chapter1.section3.exercise1.Exercise1.FixedCapacityStackOfStrings;

import static org.junit.jupiter.api.Assertions.*;

public class Exercise1Test {
    @Test
    void testIsFull() {
        FixedCapacityStackOfStrings s = new FixedCapacityStackOfStrings(3);
        s.push("item0");
        assertFalse(s.isFull());
        s.push("item1");
        assertFalse(s.isFull());
        s.push("item2");
        assertTrue(s.isFull());
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> s.push("item3"));
    }
}
