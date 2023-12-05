package com.claudhart.algs4.chapter1.section1.exercise7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Exercise7Test {

    @Test
    void testA() {
        assertEquals("3.00009\n", Exercise7.a());
    }

    @Test
    void testB() {
        assertEquals(499500, Exercise7.b());
    }

    @Test
    void testC() {
        assertEquals(10000, Exercise7.c());
    }
}
