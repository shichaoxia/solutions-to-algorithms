package chapter1.section3;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class Exercise4Test {
    @Test
    void testParentheses() {
        assertTrue(Exercise4.parentheses("[()]{}{[()()]()}"));
        assertTrue(!Exercise4.parentheses("[(])"));
    }
}
