package chapter1.section5.exercise22;

import chapter1.section5.QuickUnionUF;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

public class DoublingTestForErdosRenyiModel {

    private static Result trail(int N, int T) {
        int cumulativePairs = 0;
        double cumulativeTime = 0.0;
        for (int i = 0; i < T; ++i) {
            Stopwatch sw = new Stopwatch();
            cumulativePairs += pairsToGetOneComponent(N);
            cumulativeTime += sw.elapsedTime();
        }
        return new Result(cumulativeTime / T, cumulativePairs / T);
    }

    private static int pairsToGetOneComponent(int N) {
        QuickUnionUF uf = new QuickUnionUF(N);
        for (int i = 1; true; ++i) {
            int m = StdRandom.uniform(N);
            int n = StdRandom.uniform(N);
            if (uf.connected(m, n)) continue;
            uf.union(m, n);
            if (uf.count() == 1) return i;
        }
    }


    public static void main(String[] args) {
        int T = Integer.parseInt(args[0]);
        int N = 250;
        double previousTime = trail(N, T).avgTime;
        StdOut.printf("%5s %25s %10s%n", "N", "Avg processed connections", "Time ratio");
        for (; N <= 16_000; N += N) {
            Result r = trail(N, T);
            StdOut.printf("%5d %25d %10.1f%n", N, r.avgPairs, r.avgTime / previousTime);
            previousTime = r.avgTime;
        }
    }

    private record Result(double avgTime, int avgPairs) {
    }

}
