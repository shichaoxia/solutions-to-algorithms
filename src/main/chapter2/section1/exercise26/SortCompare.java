package chapter2.section1.exercise26;

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

    public static double insertionPrimitiveTime(int[] a) {
        Stopwatch timer = new Stopwatch();
        InsertionPrimitive.sort(a);
        return timer.elapsedTime();
    }

    public static double timeRandomInput(String alg, int N, int T) {
        // Use alg to sort T random arrays of length N.
        double total = 0.0;
        if (alg.equals("InsertionPrimitive")) {
            int[] a = new int[N];
            for (int t = 0; t < T; t++) {
                // Perform one experiment (generate and sort an array).
                for (int i = 0; i < N; i++)
                    a[i] = StdRandom.uniform(0, 1_000_000);
                total += insertionPrimitiveTime(a);
            }
        } else {
            Integer[] a = new Integer[N];
            for (int t = 0; t < T; t++) {
                // Perform one experiment (generate and sort an array).
                for (int i = 0; i < N; i++)
                    a[i] = StdRandom.uniform(0, 1_000_000);
                total += time(alg, a);
            }
        }
        return total;
    }

    public static void main(String[] args) {
        String alg1 = args[0];
        String alg2 = args[1];
        int N = Integer.parseInt(args[2]);
        int T = Integer.parseInt(args[3]);
        double t1 = timeRandomInput(alg1, N, T); // total for alg1
        double t2 = timeRandomInput(alg2, N, T); // total for alg2
        StdOut.printf("For %d random Doubles\n %s is", N, alg1);
        StdOut.printf(" %.1f times faster than %s\n", t2 / t1, alg2);
    }

}
