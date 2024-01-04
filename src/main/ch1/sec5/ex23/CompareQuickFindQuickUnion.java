package ch1.sec5.ex23;

import ch1.sec5.QuickFindUF;
import ch1.sec5.QuickUnionUF;
import ch1.sec5.ex18.Connection;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

import java.util.Arrays;

@SuppressWarnings("DuplicatedCode")
public class CompareQuickFindQuickUnion {
    public static void main(String[] args) {
        int trailsNum = Integer.parseInt(args[0]);
        StdOut.printf("%6s %10s %12s %8s%n", "N", "Quick-find", "Quick-union", "Ratio");
        for (int N = 250; N <= 128_000; N += N) {
            TrailResult[] results = new TrailResult[trailsNum];
            for (int i = 0; i < trailsNum; i++) {
                TrailResult result = trial(N);
                results[i] = result;
            }
            double quickFindTime = Arrays.stream(results)
                    .map(n -> n.quickFind)
                    .reduce(0.0, Double::sum)
                    / trailsNum;
            double quickUnionTime = Arrays.stream(results)
                    .map(n -> n.quickUnion)
                    .reduce(0.0, Double::sum)
                    / trailsNum;
            StdOut.printf("%6d %10f %12f %8.1f%n", N, quickFindTime, quickUnionTime, quickFindTime / quickUnionTime);
        }
    }

    private static Connection[] randomConnections(int N) {
        Connection[] connections = new Connection[N];
        for (int i = 0; i < N; i++)
            connections[i] = new Connection(StdRandom.uniform(N), StdRandom.uniform(N));
        return connections;
    }

    private static TrailResult trial(int N) {
        Connection[] connections = randomConnections(N);

        QuickFindUF qf = new QuickFindUF(N);
        Stopwatch stopwatch = new Stopwatch();
        for (Connection connection : connections) {
            if (qf.connected(connection.p, connection.q)) continue;
            qf.union(connection.p, connection.q);
        }
        double quickFindTime = stopwatch.elapsedTime();

        QuickUnionUF qu = new QuickUnionUF(N);
        stopwatch = new Stopwatch();
        for (Connection connection : connections) {
            if (qu.connected(connection.p, connection.q)) continue;
            qu.union(connection.p, connection.q);
        }
        double quickUnionTime = stopwatch.elapsedTime();

        return new TrailResult(quickFindTime, quickUnionTime);
    }

    private record TrailResult(double quickFind, double quickUnion) {
    }

}
