package chapter1.section3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ResizingArrayStackTest {

    @Test
    void push() {
        ResizingArrayStack<String> s = new ResizingArrayStack<>();
        s.push("a");
        s.push("b");
        s.push("c");
        assertEquals("c", s.pop());
    }
}