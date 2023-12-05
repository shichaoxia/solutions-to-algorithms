package com.claudhart.algs4.chapter2.section5.exercise18;

import com.claudhart.algs4.chapter2.section5.exercise17.CheckStability;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ForceStabilityTest {

    @Test
    void stableSort() {
        String s = """
                13 John
                1 John
                7 John
                11 George
                2 Bob
                5 John
                9 John
                3 Alice
                4 Harry
                8 Eric
                12 Frank
                10 Alice
                6 Chris""";

        CheckStability.Student[] students = s.lines().map(CheckStability.Student::new).toArray(CheckStability.Student[]::new);

        String[] algs = {"Selection", "Quick", "Heap"};

        for (String alg : algs) {
            CheckStability.Student[] sorted = sort(alg, students);
            assertTrue(CheckStability.isStable(students, sorted));
        }
    }

    CheckStability.Student[] sort(String alg, CheckStability.Student[] a) {
        CheckStability.Student[] copy = Arrays.copyOf(a, a.length);
        ForceStability.stableSort(copy, alg);
        return copy;
    }
}