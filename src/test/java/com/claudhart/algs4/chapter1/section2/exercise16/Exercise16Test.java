package com.claudhart.algs4.chapter1.section2.exercise16;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.claudhart.algs4.chapter1.section2.exercise16.Exercise16.Rational;

public class Exercise16Test {

    static final Rational a = new Rational(2, 3);
    static final Rational b = new Rational(5, 6);

    @Test
    void testPlus() {
        assertEquals(a.plus(b), new Rational(3, 2));
    }

    @Test
    void testMinus() {
        assertEquals(a.minus(b), new Rational(-1, 6));
    }

    @Test
    void testTimes() {
        assertEquals(a.times(b), new Rational(10, 18));
    }

    @Test
    void testDivides() {
        assertEquals(a.divides(b), new Rational(4, 5));
    }

}
