package ch2.sec1.ex16;

import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Certification {
    public static <T extends Comparable<T>> boolean check(T[] original, T[] sorted) {
        return areObjectsTheSame(original, sorted) && isSorted(sorted);
    }

    public static <T extends Comparable<T>> boolean areObjectsTheSame(T[] original, T[] sorted) {
        if (original.length != sorted.length) return false;
        List<T> list = new ArrayList<>();
        Collections.addAll(list, original);
        for (T item : sorted) {
            if (!list.remove(item)) return false;
        }
        return list.isEmpty();
    }

    public static <T extends Comparable<T>> boolean less(T v, T w) {
        return v.compareTo(w) < 0;
    }

    public static <T extends Comparable<T>> boolean isSorted(T[] a) {
        for (int i = 1; i < a.length; i++)
            if (less(a[i], a[i - 1])) return false;
        return true;
    }

    public static void main(String[] args) {
        String[] a = {"C", "A", "B"};
        String[] b = Arrays.copyOf(a, a.length);
        Arrays.sort(b);
        StdOut.println(check(a, b));
    }
}
