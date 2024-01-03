package chapter2.section5.exercise26;

import chapter2.section5.exercise25.Point2D;
import edu.princeton.cs.algs4.StdDraw;

import java.util.Arrays;

public class SimplePolygon {
    public static void drawSimplePolygon(Point2D[] points) {
        Point2D lowestPoint = getLowestPoint(points);
        Arrays.sort(points, lowestPoint.atan2Order());
        connect(points);
    }

    private static Point2D getLowestPoint(Point2D[] points) {
        Point2D lowestPoint = points[0];
        for (int i = 1; i < points.length; i++) {
            if (points[i].y() < lowestPoint.y()) lowestPoint = points[i];
            else if (points[i].y() == lowestPoint.y() && points[i].x() < lowestPoint.x()) lowestPoint = points[i];
        }
        return lowestPoint;
    }

    private static void connect(Point2D[] points) {
        for (int i = 0; i < points.length - 1; i++)
            connect(points[i], points[i + 1]);
        connect(points[points.length - 1], points[0]);
    }

    private static void connect(Point2D p1, Point2D p2) {
        StdDraw.line(p1.x(), p1.y(), p2.x(), p2.y());
    }

    public static void main(String[] args) {
        Point2D[] points = new Point2D[10];
        for (int i = 0; i < points.length; i++) {
            points[i] = new Point2D(Math.random(), Math.random());
            points[i].draw();
        }
        drawSimplePolygon(points);
    }
}
