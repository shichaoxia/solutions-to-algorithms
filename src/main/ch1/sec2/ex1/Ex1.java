package ch1.sec2.ex1;

import java.util.Arrays;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Ex1 {
    public static Point2D[] generateDots(int N) {
        Point2D[] dots = new Point2D[N];
        for (int i = 0; i < N; i++) {
            double x = StdRandom.uniform(0.0, 1.0);
            double y = StdRandom.uniform(0.0, 1.0);
            dots[i] = new Point2D(x, y);
        }
        return dots;
    }

    public static double shortestDistance(Point2D[] dots) {
        double shortestDistance = dots[0].distanceTo(dots[1]);
        for (int i = 0; i < dots.length; i++) {
            for (int j = i + 1; j < dots.length; j++) {
                double dist = dots[i].distanceTo(dots[j]);
                if (dist < shortestDistance)
                    shortestDistance = dist;
            }
        }
        return shortestDistance;
    }

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        Point2D[] dots = generateDots(N);
        StdOut.printf("Dots: %s%n", Arrays.toString(dots));
        StdOut.printf("Shortest: %s%n", shortestDistance(dots));
    }
}
