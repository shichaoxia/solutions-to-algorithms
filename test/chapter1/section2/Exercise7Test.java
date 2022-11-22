package chapter1.section2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class Exercise7Test {
    @Test
    void testMystery() {
        assertEquals("!dlrow olleH", Exercise7.mystery("Hello world!"));
    }
}
