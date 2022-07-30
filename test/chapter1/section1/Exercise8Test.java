package chapter1.section1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Exercise8Test {

    @Test
    void a() {
        assertEquals("b", Exercise8.a());
    }

    @Test
    void b() {
        assertEquals("Å", Exercise8.b());
    }

    @Test
    void c() {
        assertEquals("e", Exercise8.c());
    }
}
