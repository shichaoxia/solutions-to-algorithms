package chapter1.section1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class Exercise20Test {
    @Test
    void testLogFact() {
        assertEquals(15.104412573075518, Exercise20.logFact(10));
    }
}
