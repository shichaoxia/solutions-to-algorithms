package com.claudhart.algs4.chapter1.section1.exercise6;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Exercise6Test {

    @Test
    void testPrintSomething() {
        PrintStream defaultOut = System.out;

        ByteArrayOutputStream os = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(os);
        System.setOut(ps);

        Exercise6.printFibonacci();

        // 斐波那契数列
        assertEquals("0\n1\n1\n2\n3\n5\n8\n13\n21\n34\n55\n89\n144\n233\n377\n610\n", os.toString());

        System.setOut(defaultOut);
    }
}
