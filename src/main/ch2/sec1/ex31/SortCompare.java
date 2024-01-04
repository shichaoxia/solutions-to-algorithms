package ch2.sec1.ex31;

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

    public static double timeRandomInput(String alg, int N, int T) {
        // Use alg to sort T random arrays of length N.
        double total = 0.0;
        Integer[] a = new Integer[N];
        for (int t = 0; t < T; t++) {
            // Perform one experiment (generate and sort an array).
            for (int i = 0; i < N; i++)
                a[i] = StdRandom.uniform(0, 2);
            total += time(alg, a);
        }
        return total;
    }

    
    public static Integer[] randomArray(int N) {
        Integer[] a = new Integer[N];
        for (int i = 0; i < N; i++)
            a[i] = StdRandom.uniform(0, 2);
        return a;
    }

    public static void ratioTest(String alg) {
        int T = 5;
        StdOut.printf("%10s %10s %10s %10s%n", "N", "time", "ratio", "log2");
        double previous = timeRandomInput(alg, 500, T);
        int K = (alg.equals("Shell")) ? 2_048_000 : 64_000;
        for (int N = 1_000; N <= K; N *= 2) {
            double time = timeRandomInput(alg, N, T);
            double ratio = time / previous;
            StdOut.printf("%10d %10.3f %10.2f %10.2f%n", N, time, ratio, Math.log(ratio) / Math.log(2));
            previous = time;
        }
    }

    public static void main(String[] args) {
        String[] algs = {"Selection", "Insertion", "Shell"};
        for (String alg : algs) {
            StdOut.println(alg);
            ratioTest(alg);
        }
    }

}
