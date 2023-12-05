package com.claudhart.algs4.chapter2.section5.exercise17;

import com.claudhart.algs4.chapter2.section1.Insertion;
import com.claudhart.algs4.chapter2.section1.Selection;
import com.claudhart.algs4.chapter2.section1.Shell;
import com.claudhart.algs4.chapter2.section2.Merge;
import com.claudhart.algs4.chapter2.section3.Quick;
import com.claudhart.algs4.chapter2.section4.HeapsortZero;

import java.util.Arrays;

@SuppressWarnings("rawtypes")
public class CheckStability {
    public static void main(String[] args) {
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

        Student[] students = Arrays.stream(s.split("\n"))
                .map(Student::new)
                .toArray(Student[]::new);

        String[] algs = {"Insertion", "Selection", "Shell", "Merge", "Quick", "Heap"};

        System.out.printf("%10s %10s", "Algorithm", "Is stable");
        for (String alg : algs) {
            Student[] sorted = sort(alg, students);
            System.out.printf("\n%10s %10s", alg, isStable(students, sorted));
        }
    }

    public static Student[] sort(String alg, Student[] a) {
        Student[] copy = Arrays.copyOf(a, a.length);
        switch (alg) {
            case "Insertion" -> Insertion.sort(copy);
            case "Selection" -> Selection.sort(copy);
            case "Shell" -> Shell.sort(copy);
            case "Merge" -> Merge.sort(copy);
            case "Quick" -> Quick.sort(copy);
            case "Heap" -> HeapsortZero.sort(copy);
            default -> throw new RuntimeException("Invalid algorithm");
        }
        return copy;
    }

    @SuppressWarnings("unchecked")
    public static boolean isStable(Comparable[] original, Comparable[] sorted) {
        for (int i = 1; i < sorted.length; i++) {
            if (sorted[i].compareTo(sorted[i - 1]) == 0) {
                int repeatingEnd = repeatingRange(sorted, i);
                int repeatingStart = i - 1;
                if (!isIndicesInOriginalSameOrder(original, sorted, repeatingStart, repeatingEnd)) return false;
            }
        }
        return true;
    }

    @SuppressWarnings("unchecked")
    public static int repeatingRange(Comparable[] a, int from) {
        int to = from + 1;
        while (to < a.length && a[to].compareTo(a[to - 1]) == 0) to++;
        return to - 1;
    }

    public static boolean isIndicesInOriginalSameOrder(Comparable[] original, Comparable[] sorted, int from, int to) {
        Integer[] indices = new Integer[to - from + 1];
        for (int i = from; i <= to; i++) {
            indices[i - from] = index(original, sorted[i]);
        }
        return isSorted(indices);
    }

    public static int index(Comparable[] a, Comparable item) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == item) return i;
        }
        return -1;
    }

    @SuppressWarnings("unchecked")
    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (a[i].compareTo(a[i - 1]) < 0) return false;
        }
        return true;
    }

    public static class Student implements Comparable<Student> {
        final int id;
        final String name;

        public Student(String s) {
            String[] fields = s.split(" ");
            this.id = Integer.parseInt(fields[0]);
            this.name = fields[1];
        }

        @Override
        public int compareTo(Student that) {
            return this.name.compareTo(that.name);
        }

        @Override
        public String toString() {
            return "Student{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}
