package com.claudhart.algs4.chapter1.section2.exercise16;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.claudhart.algs4.chapter1.section2.exercise16.Exercise16.Rational;

public class Exercise16Test {

    static Rational a = new Rational(2, 3);
    static Rational b = new Rational(5, 6);

    @Test
    void testPlus() {
        assertTrue(a.plus(b).equals(new Rational(3, 2)));
    }

    @Test
    void testMinus() {
        assertTrue(a.minus(b).equals(new Rational(-1, 6)));
    }

    @Test
    void testTimes() {
        assertTrue(a.times(b).equals(new Rational(10, 18)));
    }

    @Test
    void testDivides() {
        assertTrue(a.divides(b).equals(new Rational(4, 5)));
    }

}
