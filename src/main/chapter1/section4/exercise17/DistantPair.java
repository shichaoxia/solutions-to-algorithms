package chapter1.section4.exercise17;

import edu.princeton.cs.algs4.StdOut;

@SuppressWarnings("ClassEscapesDefinedScope")
public class DistantPair {

    public static Pair find(double[] a) {

        double smallest = a[0];
        double biggest = a[0];

        for (double v : a) {
            if (v < smallest)
                smallest = v;
            if (v > biggest)
                biggest = v;
        }

        return new Pair(smallest, biggest);
    }

    private record Pair(double l, double r) {
    }

    public static void main(String[] args) {
        double[] a = { 1.0, 3.0, 8.0, 9.0 };
        StdOut.println(find(a));
    }
}
