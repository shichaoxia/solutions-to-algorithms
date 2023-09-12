package chapter2.section3.exercise28;

import edu.princeton.cs.algs4.StdOut;

@SuppressWarnings({"rawtypes", "DuplicatedCode"})
public class SortCompare {

    public static void main(String[] args) {
        compareM();
    }

    private static void compareM() {
        StdOut.printf("%nDifferent cutoff values have different recursive depths:%n");
        StdOut.printf("%10s %10s %10s %10s %10s%n", "M\\Depth/N", "10^3", "10^4", "10^5", "10^6");
        double time;
        Comparable[] a;
        Integer[] cutoffs = {10,20,50};
        for (int M:cutoffs) {
            StdOut.printf("%10d", M);
            for (int N = 1_000; N <= 1_000_000; N *= 10) {
                a = generateArray(N);
                time = trial(a, M);
                StdOut.printf(" %10.0f", time);
            }
            StdOut.printf("%n");
        }
    }

    private static double trial(Comparable[] a, int cutoff) {
        int T = 10;
        double totalDepth = 0.0;
        for (int i = 0; i < T; i++) {
            totalDepth += depth(a, cutoff);
        }
        return totalDepth / 10;
    }

    private static double depth(Comparable[] a, int cutoff) {
        Quick.sort(a, cutoff);
        return Quick.depth;
    }

    private static Comparable[] generateArray(int length) {
        Comparable[] a = new Comparable[length];
        for (int i = 0; i < length; i++) a[i] = i;
        return a;
    }
}
