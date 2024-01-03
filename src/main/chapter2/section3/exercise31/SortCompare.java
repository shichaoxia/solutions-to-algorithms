package chapter2.section3.exercise31;

import chapter2.section3.Quick;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

@SuppressWarnings({"rawtypes"})
public class SortCompare {
    public static void main(String[] args) {
        compare();
    }

    private static double time(Comparable[] a) {
        Stopwatch s = new Stopwatch();
        Quick.sort(a);
        return s.elapsedTime();
    }

    private static void compare() {
        StdOut.printf("%10s %10s %10s %10s %10s%n", "T\\time/N", "10^3", "10^4", "10^5", "10^6");
        Comparable[] a;
        double time;
        for (int T = 5; T < 50; T += 5) {
            StdOut.printf("%10d", T);
            for (int N = 1_000; N <= 1_000_000; N *= 10) {
                a = generateArray(N);
                time = trial(a, T);
                StdOut.printf(" %10.4f", time);
            }
            StdOut.println();
        }
    }

    private static double trial(Comparable[] a, int T) {
        double totalTime = 0.0;
        for (int i = 0; i < T; i++) {
            totalTime += time(a);
        }
        return totalTime / T;
    }

    private static Comparable[] generateArray(int length) {
        Comparable[] a = new Comparable[length];
        for (int i = 0; i < length; i++) a[i] = i;
        return a;
    }
}
