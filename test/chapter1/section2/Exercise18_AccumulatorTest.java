package chapter1.section2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import chapter1.section2.Exercise18.Accumulator;

public class Exercise18_AccumulatorTest {
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
