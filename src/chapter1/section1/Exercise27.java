package chapter1.section1;

import java.util.HashMap;
import java.util.Map;

import edu.princeton.cs.algs4.StdOut;

public class Exercise27 {

    static int calledTimes = 0;
    static int calculateTimes = 0;

    public static double binomial(int N, int k, double p) {
        calledTimes += 1;
        if (N == 0 && k == 0)
            return 1.0;
        if (N < 0 || k < 0)
            return 0.0;
        return (1.0 - p) * binomial(N - 1, k, p) + p * binomial(N - 1, k - 1, p);
    }

    static Map<IntTuple, Double> cache = new HashMap<>();

    public static double memorizedBinomial(int N, int k, double p) {
        IntTuple key = new IntTuple(N, k);
        if (cache.containsKey(key)) {
            return cache.get(key);
        }
        calculateTimes += 1;
        if (N == 0 && k == 0)
            return 1.0;
        if (N < 0 || k < 0)
            return 0.0;
        double result = (1.0 - p) * memorizedBinomial(N - 1, k, p) + p * memorizedBinomial(N - 1, k - 1, p);
        cache.put(key, result);
        return result;
    }

    public static void main(String[] args) {
        StdOut.printf("Non-memorized calculation result: %f%n", binomial(10, 5, 0.25));
        StdOut.printf("Called times: %d%n", calledTimes);
        StdOut.printf("Memorized calculation result: %f%n", memorizedBinomial(10, 5, 0.25));
        StdOut.printf("Calculate times: %d%n", calculateTimes);
        StdOut.printf("Number of cached results: %d%n", cache.size());
    }
}

record IntTuple(int N, int k) {
}
