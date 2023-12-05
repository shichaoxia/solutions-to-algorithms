package com.claudhart.algs4.chapter1.section3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StackTest {

    @Test
    void push() {
        Stack<String> s = new Stack<>();
        s.push("a");
        s.push("b");
        s.push("c");
        assertEquals("a, b, c", s.toString());
    }
}