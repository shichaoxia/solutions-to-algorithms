package com.claudhart.algs4.chapter1.section1.exercise18;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Exercise18Test {
    @Test
    void testMystery() {
        Assertions.assertEquals(50, Exercise18.mystery(2, 25));
        assertEquals(33, Exercise18.mystery(3, 11));
    }

    @Test
    void testMystery2() {
        assertEquals(96, Exercise18.mystery2(2, 25));
        assertEquals(135, Exercise18.mystery2(3, 11));
    }
}
