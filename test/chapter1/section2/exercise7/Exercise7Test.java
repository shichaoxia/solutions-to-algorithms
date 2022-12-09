package chapter1.section2.exercise7;

import static org.junit.jupiter.api.Assertions.assertEquals;

import chapter1.section2.exercise7.Exercise7;
import org.junit.jupiter.api.Test;

public class Exercise7Test {
    @Test
    void testMystery() {
        assertEquals("!dlrow olleH", Exercise7.mystery("Hello world!"));
    }
}
