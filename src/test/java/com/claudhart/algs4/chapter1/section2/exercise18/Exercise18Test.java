package com.claudhart.algs4.chapter1.section2.exercise18;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.claudhart.algs4.chapter1.section2.exercise18.Exercise18.Accumulator;

public class Exercise18Test {
    @Test
    void testVar() {
        Accumulator a = new Accumulator();
        a.addDataValue(1.0);
        a.addDataValue(3.0);
        a.addDataValue(5.0);
        assertEquals(4.0, a.var());
    }

    @Test
    void testStddev() {
        Accumulator a = new Accumulator();
        a.addDataValue(1.0);
        a.addDataValue(3.0);
        a.addDataValue(5.0);
        assertEquals(2.0, a.stddev());
    }
}
