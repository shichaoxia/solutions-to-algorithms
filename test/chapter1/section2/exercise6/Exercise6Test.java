package chapter1.section2.exercise6;

import static org.junit.jupiter.api.Assertions.assertTrue;

import chapter1.section2.exercise6.Exercise6;
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
