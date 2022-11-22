package chapter1.section2;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class Exercise6Test {
    @Test
    void testCircularRotation() {
        String a = "ACTGACG";
        String b = "TGACGAC";
        String c = "ACTGAGC";
        assertTrue(Exercise6.circularRotation(a, b));
        assertTrue(!Exercise6.circularRotation(a, c));
    }
}
