package ch2.sec2.ex28;


import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

import java.util.Arrays;

@SuppressWarnings("DuplicatedCode")
public class SortCompare {
    public static double time(String alg, Double[] a) {
        Stopwatch timer = new Stopwatch();
        if (alg.equals("Merge")) Merge.sort(a);
        if (alg.equals("MergeBU")) MergeBU.sort(a);
        return timer.elapsedTime();
    }

    
    public static double timeRandomInput(String alg, int N, int T) {
        double total = 0.0;
        Double[] a = new Double[N];
        for (int t = 0; t < T; t++) {
            for (int i = 0; i < N; i++)
                a[i] = StdRandom.uniform();
            total += time(alg, a);
        }
        return total;
    }

    @SuppressWarnings("CommentedOutCode")
    public static void main(String[] args) {
//        String alg1 = "Merge";
//        String alg2 = "MergeBU";
//        int T = 10;
//        StdOut.printf("%10s %10s%n", "N", "MergeBU/Merge");
//        for (int N = 1_000; N <= 1_000_000; N *= 10) {
//            double t1 = timeRandomInput(alg1, N, T);
//            double t2 = timeRandomInput(alg2, N, T);
//            StdOut.printf("%10d %10.1f%n", N, t2/t1);
//        }
        Double[] arr1 = randomArray(10_000);
        Double[] arr2 = Arrays.copyOf(arr1, arr1.length);
        Merge.sort(arr1);
        System.out.println(Merge.stat);
        MergeBU.sort(arr2);
        System.out.println(MergeBU.stat);
    }

    public static Double[] randomArray(int length) {
        Double[] a = new Double[length];
        for (int i = 0; i < length; i++)
            a[i] = StdRandom.uniform();
        return a;
    }

}
