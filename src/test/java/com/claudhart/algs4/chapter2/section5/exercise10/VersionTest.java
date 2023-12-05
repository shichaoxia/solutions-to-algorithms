package com.claudhart.algs4.chapter2.section5.exercise10;

import org.junit.jupiter.api.Test;

import com.claudhart.algs4.chapter2.section5.exercise10.Version;

import static org.junit.jupiter.api.Assertions.*;

class VersionTest {

    @Test
    void compareTo() {
        Version v1 = new Version(115, 1, 1);
        Version v2 = new Version(115, 10, 1);
        Version v3 = new Version(115, 10, 2);

        assertTrue(v1.compareTo(v2) < 0);
        assertTrue(v2.compareTo(v3) < 0);
        assertTrue(v1.compareTo(v3) < 0);
    }
}