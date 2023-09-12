package chapter2.section2.exercise18;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

@SuppressWarnings("DuplicatedCode")
public class DoublingRatio {
    public static void main(String[] args) {
        double previous = time(randomList(500), 1);
        StdOut.printf("%10s %10s %10s%n", "N", "time", "log ratio");
        for (int N = 1000; N <= 128_000; N += N) {
            double time = time(randomList(N), 1);
            double ratio = time / previous;
            StdOut.printf("%10d %10.3f %10.1f%n", N, time, Math.log(ratio) / Math.log(2));
            previous = time;
        }
    }

    public static double time(LinkedList a, int T) {
        double time = 0.0;
        for (int i = 0; i < T; i++) {
            Stopwatch sw = new Stopwatch();
            LinkedList.shuffle(a);
            time += sw.elapsedTime();
        }
        return time / T;
    }

    public static LinkedList randomList(int length) {
        Double[] a = new Double[length];
        for (int i = 0; i < length; i++)
            a[i] = StdRandom.uniform();
        return LinkedList.fromArray(a);
    }
}
