package chapter2.section2.exercise26;


import chapter2.section2.Merge;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

public class SortCompare {
    public static double time(String alg, Double[] a) {
        Stopwatch timer = new Stopwatch();
        if (alg.equals("Merge")) Merge.sort(a);
        if (alg.equals("MergeAuxInMerge")) MergeAuxInMerge.sort(a);
        return timer.elapsedTime();
    }

    @SuppressWarnings("DuplicatedCode")
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

    public static void main(String[] args) {
        String alg1 = "Merge";
        String alg2 = "MergeAuxInMerge";
        int T = 10;
        StdOut.printf("%10s %10s%n", "N", "MergeAuxInMerge/Merge");
        for (int N = 1000; N < 100_000; N += N) {
            double t1 = timeRandomInput(alg1, N, T);
            double t2 = timeRandomInput(alg2, N, T);
            StdOut.printf("%10d %10.1f%n", N, t2/t1);
        }
    }

}
