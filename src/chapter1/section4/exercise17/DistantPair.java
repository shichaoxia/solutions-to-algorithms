package chapter1.section4.exercise17;

import edu.princeton.cs.algs4.StdOut;

public class DistantPair {

    public static Pair find(double[] a) {
        int N = a.length;

        double smallest = a[0];
        double biggest = a[0];

        for (int i = 0; i < N; i++) {
            if (a[i] < smallest)
                smallest = a[i];
            if (a[i] > biggest)
                biggest = a[i];
        }

        return new Pair(smallest, biggest);
    }

    private static record Pair(double l, double r) {
    }

    public static void main(String[] args) {
        double[] a = { 1.0, 3.0, 8.0, 9.0 };
        StdOut.println(find(a));
    }
}
