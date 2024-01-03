package chapter2.section4.exercise35;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

public class ElementarySample {

    final double[] p;

    private double T;

    public ElementarySample(double[] p) {
        this.p = p;
        T = sum();
    }

    public static void main(String[] args) {
        double[] p = {0.1, 0.2, 0.3, 0.4};
        ElementarySample sample = new ElementarySample(p);
        System.out.println(Arrays.toString(p) + sample.random());
        sample.change(0, 1.1);
        System.out.println(Arrays.toString(p) + sample.random());
    }

    public IndexAndProbability random() {
        int index = StdRandom.uniform(p.length);
        return new IndexAndProbability(index, p[index] / T);
    }

    private double sum() {
        double sum = 0;
        for (double v : p) {
            sum += v;
        }
        return sum;
    }

    public void change(int i, double v) {
        T += v - p[i];
        p[i] = v;
    }

    public record IndexAndProbability(int index, double probability) {
    }
}
