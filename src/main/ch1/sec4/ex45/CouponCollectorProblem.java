package ch1.sec4.ex45;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.HashSet;
import java.util.Set;

public class CouponCollectorProblem {
    
    public static int numbersBeforeAll(int N) {
        Set<Integer> s = new HashSet<>();
        for (int i = 0; i < N; i++) {
            s.add(i);
        }
        // int[] a = new int[N];
        int cnt = 0;
        while (!s.isEmpty()) {
            int item = StdRandom.uniform(N);
            s.remove(item);
            cnt += 1;
        }
        return cnt;
    }

    public static void main(String[] args) {
        StdOut.printf("%7s %7s %7s%n", "N", "Actual", "Sim");
        for (int N = 125; N < 1_000_000; N += N)
            StdOut.printf("%7d %7d %7.0f%n", N, numbersBeforeAll(N), N * Math.log1p(N));
    }
}
