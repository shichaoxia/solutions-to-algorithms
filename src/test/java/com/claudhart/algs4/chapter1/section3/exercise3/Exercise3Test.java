package com.claudhart.algs4.chapter1.section3.exercise3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Exercise3Test {
    @Test
    void testA() {
        Assertions.assertEquals("4321098765", Exercise3.a());
    }

    @Test
    void testB() {
        assertEquals("4687532910", Exercise3.b());
    }

    @Test
    void testC() {
        assertEquals("256748931", Exercise3.c());
    }

    @Test
    void testD() {
        assertEquals("4321056789", Exercise3.d());
    }

    @Test
    void testE() {
        assertEquals("1234569870", Exercise3.e());
    }

    @Test
    void testF() {
        assertEquals("0465387219", Exercise3.f());
    }

    @Test
    void testG() {
        assertEquals("1479865320", Exercise3.g());
    }

    @Test
    void testH() {
        assertEquals("2143658790", Exercise3.h());
    }
}
