package com.claudhart.algs4.chapter1.section2.exercise10;

import java.util.Arrays;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

public class Exercise10 {
    public static class VisualCounter {
        final private int max;
        private int total;
        private final int[] totalHistory;
        private int opNum;

        VisualCounter(int N, int max) {
            this.max = max;
            this.totalHistory = new int[N];
        }

        int increment() {
            if (opNum == totalHistory.length || total == max)
                return -1;
            total += 1;
            totalHistory[opNum] = total;
            opNum += 1;
            return 0;
        }

        int reduction() {
            if (opNum == totalHistory.length || total == -max)
                return -1;
            total -= 1;
            totalHistory[opNum] = total;
            opNum += 1;
            return 0;
        }

        int tally() {
            return totalHistory[opNum - 1];
        }

        void draw() {
            double xUnit = 1.0 / totalHistory.length;
            double gap = xUnit / 10.0;
            double yUnit = 1.0 / max;
            StdDraw.setYscale(-1.0, 1.0);
            for (int i = 0; i < totalHistory.length; i++) {
                double x = xUnit * (i + 0.5);
                double y = totalHistory[i] / 2.0 * yUnit;
                double rw = xUnit / 2.0 - gap;
                double rh = Math.abs(y);
                StdDraw.filledRectangle(x, y, rw, rh);
            }
        }

        @Override
        public String toString() {
            return "VisualCounter [max=" + max + ", opNum=" + opNum + ", totalHistory=" + Arrays.toString(totalHistory)
                    + "]";
        }
    }

    public static void main(String[] args) {
        VisualCounter vc = new VisualCounter(6, 2);
        for (int i = 0; i < 3; i++) {
            String success = vc.increment() == 0 ? "successfully" : "failed";
            StdOut.printf("Increase %s, counter: %s%n", success, vc);
        }
        for (int i = 0; i < 5; i++) {
            String success = vc.reduction() == 0 ? "successfully" : "failed";
            StdOut.printf("Reduce %s, counter: %s%n", success, vc);
        }
        vc.draw();
    }
}
