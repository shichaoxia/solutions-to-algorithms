package ch2.sec3.ex24;

import ch2.sec3.Quick;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

import static ch2.sec3.ex24.Samplesort.sort;

@SuppressWarnings({"rawtypes"})
public class SortCompare {

    private static final String originalAlg = "quick";
    private static final String newAlg = "samplesort";

    public static void main(String[] args) {
        doublingRatio();
        compareWithOriginal();
    }

    private static double time(String alg, Comparable[] a) {
        Stopwatch s = new Stopwatch();
        switch (alg) {
            case originalAlg -> Quick.sort(a);
            case newAlg -> sort(a);
        }
        return s.elapsedTime();
    }

    private static void doublingRatio() {
        StdOut.printf("Doubling ratio test:%n");
        StdOut.printf("%10s %10s %10s%n", "N", "time", "log ratio");
        int N = 500;
        Comparable[] a = generateArray(N);
        double previous = trial(newAlg, a);
        for (N = 1_000; N <= 128_000; N += N) {
            a = generateArray(N);
            double time = trial(newAlg, a);
            StdOut.printf("%10d %10.4f %10.1f%n", N, time, Math.log(time / previous) / Math.log(2));
            previous = time;
        }
    }

    private static void compareWithOriginal() {
        StdOut.printf("%nCompare with original:%n");
        StdOut.printf("%10s %10s %10s %10s%n", "N", newAlg, originalAlg, "ratio");
        for (int N = 1000; N <= 128_000; N += N) {
            Comparable[] a = generateArray(N);
            double newAlgTime = trial(newAlg, a);
            double originalAlgTime = trial(originalAlg, a);
            StdOut.printf("%10d %10.3f %10.3f %10.2f%n", N, newAlgTime, originalAlgTime, newAlgTime / originalAlgTime);
        }
    }

    private static double trial(String alg, Comparable[] a) {
        int T = 10;
        double totalTime = 0.0;
        for (int i = 0; i < T; i++) {
            totalTime += time(alg, a);
        }
        return totalTime / 10;
    }

    private static Comparable[] generateArray(int length) {
        Comparable[] a = new Comparable[length];
        for (int i = 0; i < length; i++) a[i] = i;
        return a;
    }
}
