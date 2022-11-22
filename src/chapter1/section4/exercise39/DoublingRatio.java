package chapter1.section4.exercise39;

import chapter1.section4.ThreeSum;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

public class DoublingRatio {
    public static double timeTrial(int N) {
        int MAX = 1_000_000;
        int[] a = new int[N];
        for (int i = 0; i < N; i++)
            a[i] = StdRandom.uniform(-MAX, MAX);
        Stopwatch timer = new Stopwatch();
        ThreeSum.count(a);
        return timer.elapsedTime();
    }

    public static void main(String[] args) {
        int trialTimes = Integer.parseInt(args[0]);
        double prev = timeTrial(125);
        for (int N = 250; true; N += N) {
            double avgTime = 0;
            for (int cnt = trialTimes; cnt > 0; --cnt)
                avgTime += timeTrial(N);
            avgTime /= trialTimes;
            StdOut.printf("%6d %7.1f ", N, avgTime);
            StdOut.printf("%5.1f\n", avgTime / prev);
            prev = avgTime;
        }
    }
}
