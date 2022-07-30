package chapter1.section1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class Exercise2Test {
    @Test
    void testA() {
        assertEquals(1.618, Exercise2.a());
    }

    @Test
    void testB() {
        assertEquals(10.0, Exercise2.b());
    }

    @Test
    void testC() {
        assertTrue(Exercise2.c());
    }

    @Test
    void testD() {
        assertEquals("33", Exercise2.d());
    }
}
