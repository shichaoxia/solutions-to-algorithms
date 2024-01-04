package ch2.sec5.ex25;

import edu.princeton.cs.algs4.StdDraw;

import java.util.Comparator;


public record Point2D(double x, double y) {

    public static final Comparator<Point2D> X_ORDER = new XOrder();
    public static final Comparator<Point2D> Y_ORDER = new YOrder();
    public static final Comparator<Point2D> R_ORDER = new ROrder();

    public static void main(String[] args) {
        System.out.println(Math.atan2(-10, 10));
        System.out.println(Math.atan2(-10, -10));
    }

    public double r() {
        return Math.sqrt(x * x + y * y);
    }

    public double theta() {
        return Math.toDegrees(Math.atan2(y, x));
    }

    public double distTo(Point2D that) {
        double dx = this.x - that.x;
        double dy = this.y - that.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    public double angleTo(Point2D that) {
        double dx = that.x - this.x;
        double dy = that.y - this.y;
        return Math.atan2(dy, dx);
    }

    public double distToOrigin() {
        return Math.sqrt(x * x + y * y);
    }

    public void draw() {
        StdDraw.point(x, y);
    }

    public Comparator<Point2D> atan2Order() {
        return new Atan2Order();
    }

    public Comparator<Point2D> distanceToOrder() {
        return new DistanceToOrder();
    }

    private static class XOrder implements Comparator<Point2D> {
        public int compare(Point2D p, Point2D q) {
            return Double.compare(p.x, q.x);
        }
    }

    private static class YOrder implements Comparator<Point2D> {
        public int compare(Point2D p, Point2D q) {
            return Double.compare(p.y, q.y);
        }
    }

    private static class ROrder implements Comparator<Point2D> {
        public int compare(Point2D p, Point2D q) {
            return Double.compare(p.r(), q.r());
        }
    }

    private class DistanceToOrder implements Comparator<Point2D> {
        public int compare(Point2D p1, Point2D p2) {
            double dist1 = distTo(p1);
            double dist2 = distTo(p2);
            return Double.compare(dist1, dist2);
        }
    }

    private class Atan2Order implements Comparator<Point2D> {
        public int compare(Point2D p1, Point2D p2) {
            double angle1 = angleTo(p1);
            double angle2 = angleTo(p2);
            return Double.compare(angle1, angle2);
        }
    }
}
