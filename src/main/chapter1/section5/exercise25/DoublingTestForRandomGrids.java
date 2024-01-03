package chapter1.section5.exercise25;

import chapter1.section5.exercise18.Connection;
import chapter1.section5.exercise18.RandomGridGenerator;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

import java.lang.reflect.Constructor;
import java.util.Arrays;

@SuppressWarnings({"rawtypes", "unchecked"})
public class DoublingTestForRandomGrids {

    static final Class[] ufs = {QuickFindUF.class, QuickUnionUF.class, WeightedQuickUnionUF.class};

    public static void main(String[] args) {

        int trialsNum = Integer.parseInt(args[0]);

        try {
            for (Class clazz : ufs) {
                StdOut.println(clazz.getName());
                Constructor constructor = clazz.getDeclaredConstructor(Integer.TYPE);
                int N = 250;

                double previousTime = avgTrial(trialsNum, N, (UF) constructor.newInstance(N));
                StdOut.printf("%6s %6s %2s%n", "N", "Time", "Ratio");
                StdOut.printf("%6d %6.3f %2.1f%n", N, previousTime, Double.NaN);

                for (; N <= 2_000; N += N) {
                    double time = avgTrial(trialsNum, N, (UF) constructor.newInstance(N));
                    StdOut.printf("%6d %6.3f %2.1f%n", N, time, time / previousTime);
                    previousTime = time;
                }
            }
        } catch (Exception e) {
            StdOut.println(e);
        }
    }

    private static double trial(int N, UF uf) {
        Connection[] connections = RandomGridGenerator.generate(N);
        Stopwatch stopwatch = new Stopwatch();
        for (Connection connection : connections) {
            if (uf.connected(connection.p, connection.q)) continue;
            uf.union(connection.p, connection.q);
        }
        return stopwatch.elapsedTime();
    }

    private static double avgTrial(int T, int N, UF uf) {
        double[] times = new double[T];
        for (int i = 0; i < T; i++) times[i] = trial(N, uf);
        return Arrays.stream(times).reduce(.0, Double::sum) / T;
    }
}
