package chapter2.section3.exercise30;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

@SuppressWarnings({"rawtypes", "DuplicatedCode"})
public class SortCompare {

    private static final String originalAlg = "shuffle";
    private static final String newAlg = "NoShuffle";

    public static void main(String[] args) {
        compare();
    }

    private static double time(String alg, Comparable[] a) {
        Stopwatch s = new Stopwatch();
        switch (alg) {
            case originalAlg -> chapter2.section3.Quick.sort(a);
            case newAlg -> Quick.sort(a);
        }
        return s.elapsedTime();
    }

    private static void compare() {
        String[] nonrandomTypes = {"gaussian", "poisson", "geometric", "discrete", "halfZeroHalfOne", "halfZeroHalfReminder", "halfZeroHalfRandom"};
        for (String type : nonrandomTypes) {
            StdOut.printf("%s %n", type);
            StdOut.printf("%10s %10s %10s %10s%n", "N", newAlg, originalAlg, "ratio");
            Comparable[] a;
            double newAlgTime, originalAlgTime;
            for (int N = 100; N <= 100_000; N *= 10) {
                a = generateArray(type, N);
                newAlgTime = trial(newAlg, a);
                originalAlgTime = trial(originalAlg, a);
                StdOut.printf("%10d %10.4f %10.4f %10.1f%n", N, newAlgTime, originalAlgTime, newAlgTime / originalAlgTime);
            }
        }
    }

    private static double trial(String alg, Comparable[] a) {
        int T = 5;
        double totalTime = 0.0;
        for (int i = 0; i < T; i++) {
            totalTime += time(alg, a);
        }
        return totalTime / 10;
    }

    private static Comparable[] generateArray(String type, int N) {
        if (type.equals("gaussian") || type.equals("poisson") || type.equals("geometric") || type.equals("discrete"))
            return chapter2.section1.exercise35.SortCompare.generateArray(type, N);
        else if (type.equals("halfZeroHalfOne") || type.equals("halfZeroHalfReminder") || type.equals("halfZeroHalfRandom")) {
            return chapter2.section1.exercise36.SortCompare.generateArray(type, N);
        }
        return null;
    }
}
