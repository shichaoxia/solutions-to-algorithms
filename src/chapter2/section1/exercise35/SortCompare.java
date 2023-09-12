package chapter2.section1.exercise35;

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

    public static Double[] gaussian(int N) {
        Double[] a = new Double[N];
        for (int i = 0; i < N; i++) {
            a[i] = StdRandom.gaussian();
        }
        return a;
    }

    public static Double[] poisson(int N) {
        Double[] a = new Double[N];
        for (int i = 0; i < N; i++) {
            a[i] = (double) StdRandom.poisson(2);
        }
        return a;
    }

    public static Double[] geometric(int N) {
        Double[] a = new Double[N];
        for (int i = 0; i < N; i++) {
            a[i] = (double) StdRandom.geometric(0.3);
        }
        return a;
    }

    public static Double[] discrete(int N) {
        Double[] a = new Double[N];
        for (int i = 0; i < N; i++) {
            a[i] = i % 2 == 0 ? 0.0 : 1.0;
        }
        return a;
    }

    public static Double[] generateArray(String arrayCase, int N) {
        return switch (arrayCase) {
            case "gaussian" -> gaussian(N);
            case "poisson" -> poisson(N);
            case "geometric" -> geometric(N);
            case "discrete" -> discrete(N);
            default -> null;
        };
    }

    public static void doublingTest(String alg, String arrayCase) {
        StdOut.printf("%s ", arrayCase);
        StdOut.println(alg);
        StdOut.printf("%10s %10s %10s%n", "N", "time", "ratio");
        int N = 250;
        Double[] a = generateArray(arrayCase, N);
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
        String[] arrayCases = {"gaussian", "poisson", "geometric", "discrete"};
        String[] algs = {"Selection", "Insertion", "Shell"};
        for (String arrayCase : arrayCases)
            for (String alg : algs) doublingTest(alg, arrayCase);
    }

}
