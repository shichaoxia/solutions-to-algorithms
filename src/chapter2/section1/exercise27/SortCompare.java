package chapter2.section1.exercise27;

import edu.princeton.cs.algs4.*;

public class SortCompare {
    public static double time(String alg, Double[] a) {
        Stopwatch timer = new Stopwatch();
        if (alg.equals("Insertion")) Insertion.sort(a);
        if (alg.equals("Selection")) Selection.sort(a);
        if (alg.equals("Shell")) Shell.sort(a);
        if (alg.equals("Merge")) Merge.sort(a);
        if (alg.equals("Quick")) Quick.sort(a);
        if (alg.equals("Heap")) Heap.sort(a);
        return timer.elapsedTime();
    }

    public static double timeRandomInput(String alg, int N, int T) {
        // Use alg to sort T random arrays of length N.
        double total = 0.0;
        Double[] a = new Double[N];
        for (int t = 0; t < T; t++) {
            // Perform one experiment (generate and sort an array).
            for (int i = 0; i < N; i++)
                a[i] = StdRandom.uniform();
            total += time(alg, a);
        }
        return total;
    }

    public static void ratioTest(String alg) {
        int T = 3;
        StdOut.printf("%6s %6s %6s%n", "N", "time", "ratio");
        double previous = timeRandomInput(alg, 128, T);
        for (int N = 128 * 2; N < Math.pow(2, 17); N *= 2) {
            double time = timeRandomInput(alg, N, T);
            StdOut.printf("%6d %6.3f %6.2f%n", N, time, Math.log(time / previous) / Math.log(2));
            previous = time;
        }
    }

    public static void main(String[] args) {
        StdOut.println("Ratio column displays the logarithm of the ratio to the base of 2.");
        String[] algs = {"Selection", "Insertion", "Shell"};
        for (String alg : algs) {
            StdOut.println(alg);
            ratioTest(alg);
        }
    }

}
