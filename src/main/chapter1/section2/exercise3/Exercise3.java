package chapter1.section2.exercise3;

import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.Interval2D;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Exercise3 {
    public static Interval2D[] generate(int N, double minBoundary, double maxBoundary) {
        Interval2D[] intervals = new Interval2D[N];
        for (int i = 0; i < N; i++) {
            double min1 = StdRandom.uniform(minBoundary, maxBoundary);
            double max1 = StdRandom.uniform(min1, maxBoundary);
            double min2 = StdRandom.uniform(minBoundary, maxBoundary);
            double max2 = StdRandom.uniform(min2, maxBoundary);
            intervals[i] = new Interval2D(new Interval1D(min1, max1), new Interval1D(min2, max2));
        }
        return intervals;
    }

    public static void draw(Interval2D[] intervals) {
        for (Interval2D i : intervals) {
            StdDraw.setPenColor(
                    StdRandom.uniform(0, 256),
                    StdRandom.uniform(0, 256),
                    StdRandom.uniform(0, 256));
            i.draw();
        }
    }

    public static void stats(Interval2D[] intervals) {
        for (int i = 0; i < intervals.length; i++) {
            Interval2D a = intervals[i];
            for (int j = i + 1; j < intervals.length; j++) {
                Interval2D b = intervals[j];
                if (a.intersects(b))
                    StdOut.printf("%s intersects with %s%n", a, b);
            }
        }
    }

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        double min = Double.parseDouble(args[1]);
        double max = Double.parseDouble(args[2]);
        Interval2D[] intervals = generate(N, min, max);
        stats(intervals);
        draw(intervals);
    }
}
