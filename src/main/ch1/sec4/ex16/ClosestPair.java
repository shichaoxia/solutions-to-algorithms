package ch1.sec4.ex16;

import java.util.Arrays;

public class ClosestPair {

    public static Pair find(double[] a) {
        int N = a.length;
        Arrays.sort(a);
        double l = a[0];
        double r = a[1];
        double diff = Math.abs(a[0] - a[1]);
        for (int i = 1; i < N - 1; i++) {
            double newDiff = Math.abs(a[i] - a[i + 1]);
            if (newDiff < diff) {
                diff = newDiff;
                l = a[i];
                r = a[i + 1];
            }
        }
        return new Pair(l, r);
    }

    private record Pair(double l, double r) {
    }
}
