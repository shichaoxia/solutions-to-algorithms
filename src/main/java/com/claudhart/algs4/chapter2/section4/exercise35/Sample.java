package com.claudhart.algs4.chapter2.section4.exercise35;

import java.util.Arrays;

public class Sample {
    final Node[] p;  // p[0] is not used

    public Sample(double[] p) {
        this.p = new Node[p.length + 1];
        for (int i = this.p.length - 1; i > 0; i--) {
            this.p[i] = new Node();
            this.p[i].weight = p[i - 1];
            if (2 * i + 1 < this.p.length)
                this.p[i].cumulativeWeight += this.p[2 * i].cumulativeWeight + this.p[2 * i + 1].cumulativeWeight + this.p[i].weight;
            if (2 * i < this.p.length)
                this.p[i].cumulativeWeight = this.p[2 * i].cumulativeWeight + this.p[i].weight;
            else
                this.p[i].cumulativeWeight = this.p[i].weight;
        }
    }

    public static void main(String[] args) {
        double[] p = {1, 2, 3, 4, 5};
        Sample sample = new Sample(p);
        System.out.println(Arrays.toString(sample.p) + sample.random());
        sample.change(1, 11);
        System.out.println(Arrays.toString(sample.p) + sample.random());
    }

    public IndexAndProbability random() {
        double r = Math.random() * p[1].cumulativeWeight;
        int i = 1;
        while (r < p[i].cumulativeWeight - p[i].weight) {
            i = 2 * i;
            if (r >= p[i].cumulativeWeight) {
                r -= p[i].cumulativeWeight;
                i += 1;
            }
        }
        return new IndexAndProbability(i, p[i].weight / p[1].cumulativeWeight);
    }

    public void change(int i, double v) {
        double diff = v - p[i].weight;
        p[i].weight = v;
        while (i >= 1) {
            p[i].cumulativeWeight += diff;
            i /= 2;
        }
    }

    public record IndexAndProbability(int index, double probability) {
    }

    private static class Node {
        double weight;
        double cumulativeWeight;

        @Override
        public String toString() {
            return "(" + weight + ", " + cumulativeWeight + ")";
        }
    }

}
