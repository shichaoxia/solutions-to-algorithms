package chapter1.section1.exercise1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Exercise1Test {
    @Test
    void testA() {
        assertEquals(7, Exercise1.a());
    }

    @Test
    void testB() {
        assertEquals(200.0000002, Exercise1.b());
    }

    @Test
    void testC() {
        assertTrue(Exercise1.c());
    }
}
