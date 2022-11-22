package chapter1.section4.exercise38;

import chapter1.section4.Stopwatch;
import chapter1.section4.ThreeSum;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class DoublingRatio {
    public static double[] timeTrial(int N) {
        int MAX = 1_000_000;
        int[] a = new int[N];
        for (int i = 0; i < N; i++)
            a[i] = StdRandom.uniform(-MAX, MAX);

        double[] result = new double[2];

        Stopwatch timer = new Stopwatch();
        ThreeSum.count(a);
        result[0] = timer.elapsedTime();

        timer = new Stopwatch();
        NaiveThreeSum.count(a);
        result[1] = timer.elapsedTime();

        return result;
    }

    public static void main(String[] args) {
        for (int N = 250; true; N += N) {
            double[] result = timeTrial(N);
            StdOut.printf("%10d %10.5f %10.5f %5.1f%n", N, result[0], result[1], result[1] / result[0]);
        }
    }
}
