package com.claudhart.algs4.chapter1.section1.exercise30;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class Exercise30Test {
    @Test
    void testMatrix() {
        Boolean[][] m = Exercise30.matrix(4);
        for (Boolean[] a: m) {
            System.out.println(Arrays.toString(a));
        }
    }
}
