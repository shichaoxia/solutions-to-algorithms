package chapter1.section1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Exercise5Test {

    @Test
    void testSolution() {
        assertTrue(Exercise5.solution(0.1, 0.1));
        assertTrue(!Exercise5.solution(0.1, 2.0));
    }
}
