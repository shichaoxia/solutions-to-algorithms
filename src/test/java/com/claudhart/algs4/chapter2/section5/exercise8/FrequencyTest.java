package com.claudhart.algs4.chapter2.section5.exercise8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FrequencyTest {

    @Test
    void frequency() {
        String[] a = {"a", "b", "c", "a", "b", "a"};
        String expected = """
                a 3
                b 2
                c 1
                """;
        assertEquals(expected, Frequency.frequency(a));
    }
}