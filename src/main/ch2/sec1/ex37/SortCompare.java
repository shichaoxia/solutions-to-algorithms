package ch2.sec1.ex37;

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

    public static Integer[] ninetyFivePercentSorted(int N) {
        Integer[] a = new Integer[N];
        int k = (int) (0.95 * N);
        for (int i = 0; i < k; i++) a[i] = 0;
        for (int i = k; i < N; i++) a[i] = StdRandom.uniform(1, 1_000_000 + 1);
        return a;
    }

    public static Integer[] withinTenPositionsOfFinalPlace(int N) {
        Integer[] a = new Integer[N];
        for (int i = 0; i < N; i++) a[i] = StdRandom.uniform(i - 10, i + 10 + 1);
        return a;
    }

    public static Integer[] sortedExceptForFivePercent(int N) {
        Integer[] a = new Integer[N];
        int k = (int) (0.95 * N);
        for (int i = 0; i < k; i++) a[i] = 0;
        for (int i = k; i < N; i++) a[i] = StdRandom.uniform(1, 1_000_000 + 1);
        StdRandom.shuffle(a);
        return a;
    }

    public static Integer[] generateArray(String arrayCase, int N) {
        return switch (arrayCase) {
            case "ninetyFivePercentSorted" -> ninetyFivePercentSorted(N);
            case "withinTenPositionsOfFinalPlace" -> withinTenPositionsOfFinalPlace(N);
            case "sortedExceptForFivePercent" -> sortedExceptForFivePercent(N);
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
        String[] arrayCases = {"ninetyFivePercentSorted", "withinTenPositionsOfFinalPlace", "sortedExceptForFivePercent"};
        String[] algs = {"Selection", "Insertion", "Shell"};
        for (String arrayCase : arrayCases)
            for (String alg : algs) doublingTest(alg, arrayCase);
    }

}
