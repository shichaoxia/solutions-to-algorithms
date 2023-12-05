package com.claudhart.algs4.chapter1.section5.exercise24;

import com.claudhart.algs4.chapter1.section5.WeightedQuickUnionUF;
import com.claudhart.algs4.chapter1.section5.exercise13.WeightedQuickUnionCompressionUF;
import com.claudhart.algs4.chapter1.section5.exercise18.Connection;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

import java.util.Arrays;

@SuppressWarnings("DuplicatedCode")
public class FastAlgorithmsForErdosRenyiModel {
    public static void main(String[] args) {
        int trailsNum = Integer.parseInt(args[0]);
        StdOut.printf("%10s %10s %12s %8s%n", "N", "Weighted", "Compression", "Ratio");
        for (int N = 250; N <= 10_000_000; N += N) {
            TrailResult[] results = new TrailResult[trailsNum];
            for (int i = 0; i < trailsNum; i++) {
                TrailResult result = trial(N);
                results[i] = result;
            }
            double weighted = Arrays.stream(results)
                    .map(n -> n.weighted)
                    .reduce(0.0, Double::sum)
                    / trailsNum;
            double compression = Arrays.stream(results)
                    .map(n -> n.compression)
                    .reduce(0.0, Double::sum)
                    / trailsNum;
            StdOut.printf("%10d %10f %12f %8.1f%n", N, weighted, compression, weighted / compression);
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

        WeightedQuickUnionUF qf = new WeightedQuickUnionUF(N);
        Stopwatch stopwatch = new Stopwatch();
        for (Connection connection : connections) {
            if (qf.connected(connection.p, connection.q)) continue;
            qf.union(connection.p, connection.q);
        }
        double weightedTime = stopwatch.elapsedTime();

        WeightedQuickUnionCompressionUF qu = new WeightedQuickUnionCompressionUF(N);
        stopwatch = new Stopwatch();
        for (Connection connection : connections) {
            if (qu.connected(connection.p, connection.q)) continue;
            qu.union(connection.p, connection.q);
        }
        double compressionTime = stopwatch.elapsedTime();

        return new TrailResult(weightedTime, compressionTime);
    }

    private record TrailResult(double weighted, double compression) {
    }

}
