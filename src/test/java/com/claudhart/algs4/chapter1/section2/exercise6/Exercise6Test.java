package com.claudhart.algs4.chapter1.section2.exercise6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Exercise6Test {
    @SuppressWarnings("SpellCheckingInspection")
    @Test
    void testCircularRotation() {
        String a = "ACTGACG";
        String b = "TGACGAC";
        String c = "ACTGAGC";
        assertTrue(Exercise6.circularRotation(a, b));
        assertFalse(Exercise6.circularRotation(a, c));
    }
}
