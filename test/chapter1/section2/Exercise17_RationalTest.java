package chapter1.section2;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import chapter1.section2.Exercise17.Rational;

public class Exercise17_RationalTest {

    @Test
    void testPlus() {
        Rational a = new Rational(Long.MAX_VALUE, 1L);
        Rational b = new Rational(1L, 1L);
        assertThrows(ArithmeticException.class, () -> a.plus(b));
    }

    @Test
    void testMinus() {
        Rational a = new Rational(Long.MIN_VALUE + 1, 1L);
        Rational b = new Rational(2L, 1L);
        assertThrows(ArithmeticException.class, () -> a.minus(b));
    }

    @Test
    void testTimes() {
        Rational a = new Rational(Long.MAX_VALUE, 1L);
        Rational b = new Rational(2L, 1L);
        assertThrows(ArithmeticException.class, () -> a.times(b));
    }

    @Test
    void testDivides() {
        Rational a = new Rational(Long.MAX_VALUE, 1L);
        Rational b = new Rational(1L, 2L);
        assertThrows(ArithmeticException.class, () -> a.divides(b));
    }

}
