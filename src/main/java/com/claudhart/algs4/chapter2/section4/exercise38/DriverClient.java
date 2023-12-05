package com.claudhart.algs4.chapter2.section4.exercise38;

import com.claudhart.algs4.chapter1.section4.Stopwatch;
import com.claudhart.algs4.chapter2.section4.HeapsortZero;

import java.util.Arrays;

public class DriverClient {

    private static void trial(String arrayType) {
        Double[] a;
        int N = 10_000;
        a = generateArray(arrayType, N);
        double current, previous = time(a);
        System.out.println(arrayType);
        System.out.printf("%10s %10s %10s%n", "N", "time", "lg ratio");
        for (; N < 1_000_000; N *= 2) {
            a = generateKeysInOrderArray(N);
            current = time(a);
            System.out.printf("%10d %10.1f %10.1f%n", N, current, Math.log(current / previous) / Math.log(2));
            previous = current;
        }
    }

    private static Double[] generateKeysInOrderArray(int N) {
        Double[] a = new Double[N];
        double previous = 0;
        for (int i = 0; i < N; i++) {
            a[i] = previous + 1;
            previous = a[i];
        }
        return a;
    }

    private static Double[] generateKeysInReverseOrderArray(int N) {
        Double[] a = new Double[N];
        double previous = N;
        for (int i = 0; i < N; i++) {
            a[i] = previous;
            previous--;
        }
        return a;
    }

    private static Double[] generateAllKeysTheSameArray(int N) {
        Double[] a = new Double[N];
        Arrays.fill(a, 1.0);
        return a;
    }

    private static Double[] generateKeysHavingTwoDistinctValuesArray(int N) {
        Double[] a = new Double[N];
        for (int i = 0; i < N; i++) {
            if (i % 2 == 0) a[i] = 1.0;
            else a[i] = 2.0;
        }
        return a;
    }

    public static void main(String[] args) {
        String[] arrayTypes = {"keysInOrder", "KeysInReverseOrder", "AllKeysTheSame", "KeysHavingTwoDistinctValues"};
        for (String arrayType : arrayTypes) {
            trial(arrayType);
        }

    }

    private static double time(Double[] a) {
        int T = 10;
        double total = 0;
        for (int i = 0; i < T; i++) {
            Stopwatch timer = new Stopwatch();
            HeapsortZero.sort(a);
            total += timer.elapsedTime();
        }
        return total / T;
    }

    private static Double[] generateArray(String arrayType, int N) {
        Double[] a = new Double[N];
        switch (arrayType) {
            case "keysInOrder" -> a = generateKeysInOrderArray(N);
            case "KeysInReverseOrder" -> a = generateKeysInReverseOrderArray(N);
            case "AllKeysTheSame" -> a = generateAllKeysTheSameArray(N);
            case "KeysHavingTwoDistinctValues" -> a = generateKeysHavingTwoDistinctValuesArray(N);
        }
        return a;
    }

}
