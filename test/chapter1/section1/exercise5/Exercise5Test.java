package chapter1.section1.exercise5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Exercise5Test {

    @Test
    void testSolution() {
        assertTrue(Exercise5.solution(0.1, 0.1));
        assertFalse(Exercise5.solution(0.1, 2.0));
    }
}
