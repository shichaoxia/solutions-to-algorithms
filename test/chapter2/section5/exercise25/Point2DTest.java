package chapter2.section5.exercise25;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Point2DTest {

    @Test
    void order() {
        Point2D p1 = new Point2D(2, 8);
        Point2D p2 = new Point2D(-4, 6);
        Point2D p3 = new Point2D(-3, -3);
        assertEquals(1, Point2D.X_ORDER.compare(p1, p2));
        assertEquals(1, Point2D.Y_ORDER.compare(p1, p2));
        assertEquals(1, Point2D.R_ORDER.compare(p1, p2));
        assertEquals(1, p3.distanceToOrder().compare(p1, p2));
        assertEquals(-1, p3.atan2Order().compare(p1, p2));
    }

    @Test
    void distTo() {
        Point2D p = new Point2D(0, 0);
        Point2D q = new Point2D(3, 4);
        assertEquals(5, p.distTo(q));
    }

    @Test
    void distToOrigin() {
        Point2D p = new Point2D(3, 4);
        assertEquals(5, p.distToOrigin());
    }
}