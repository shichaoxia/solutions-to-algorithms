package ch2.sec1.ex36;

import edu.princeton.cs.algs4.*;

@SuppressWarnings("DuplicatedCode")
public class SortCompare {
    public static double time(String alg, Integer[] a) {
        Stopwatch timer = new Stopwatch();
        if (alg.equals("Insertion")) Insertion.sort(a);
        if (alg.equals("Selection")) Selection.sort(a);
        if (alg.equals("Shell")) Shell.sort(a);
        if (alg.equals("Merge")) Merge.sort(a);
        if (alg.equals("Quick")) Quick.sort(a);
        if (alg.equals("Heap")) Heap.sort(a);
        return timer.elapsedTime();
    }

    public static Integer[] halfZeroHalfOne(int N) {
        Integer[] a = new Integer[N];
        int k = N / 2;
        for (int i = 0; i < k; i++) a[i] = 0;
        for (int i = k; i < N; i++) a[i] = 1;
        return a;
    }

    public static Integer[] halfZeroHalfReminder(int N) {
        Integer[] a = new Integer[N];
        half(a, 0, 0);
        return a;
    }

    private static void half(Integer[] a, int start, int value) {
        int len = a.length;
        int left = len - start;
        if (left == 1) {
            a[start] = value;
            return;
        }
        int end = start + left / 2;
        for (int i = start; i < end; i++) a[i] = value;
        half(a, end, value + 1);
    }

    public static Integer[] halfZeroHalfRandom(int N) {
        Integer[] a = new Integer[N];
        int k = N / 2;
        for (int i = 0; i < k; i++) a[i] = 0;
        for (int i = k; i < N; i++) a[i] = StdRandom.uniform(1_000_000);
        return a;
    }

    public static Integer[] generateArray(String arrayCase, int N) {
        return switch (arrayCase) {
            case "halfZeroHalfOne" -> halfZeroHalfOne(N);
            case "halfZeroHalfReminder" -> halfZeroHalfReminder(N);
            case "halfZeroHalfRandom" -> halfZeroHalfRandom(N);
            default -> null;
        };
    }

    public static void doublingTest(String alg, String arrayCase) {
        StdOut.printf("%s ", arrayCase);
        StdOut.println(alg);
        StdOut.printf("%10s %10s %10s%n", "N", "time", "ratio");
        int N = 250;
        Integer[] a = generateArray(arrayCase, N);
        double previous = time(alg, a);
        for (N = 500; N <= 64_000; N += N) {
            a = generateArray(arrayCase, N);
            double time = time(alg, a);
            double ratio = time / previous;
            previous = time;
            StdOut.printf("%10d %10.3f %10.1f%n", N, time, ratio);
        }
    }

    public static void main(String[] args) {
        String[] arrayCases = {"halfZeroHalfOne", "halfZeroHalfReminder", "halfZeroHalfRandom"};
        String[] algs = {"Selection", "Insertion", "Shell"};
        for (String arrayCase : arrayCases)
            for (String alg : algs) doublingTest(alg, arrayCase);
    }

}
