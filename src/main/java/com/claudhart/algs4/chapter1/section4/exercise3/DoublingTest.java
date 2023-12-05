package com.claudhart.algs4.chapter1.section4.exercise3;

import java.util.ArrayList;

import com.claudhart.algs4.chapter1.section4.Stopwatch;
import com.claudhart.algs4.chapter1.section4.ThreeSum;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

@SuppressWarnings("DuplicatedCode")
public class DoublingTest {
    @SuppressWarnings("ResultOfMethodCallIgnored")
    public static double timeTrial(int N) {
        int MAX = 1_000_000;
        int[] a = new int[N];
        for (int i = 0; i < N; i++)
            a[i] = StdRandom.uniform(-MAX, MAX);
        Stopwatch timer = new Stopwatch();
        ThreeSum.count(a);
        return timer.elapsedTime();
    }

    public static void main(String[] args) {
        int scale = Integer.parseInt(args[0]);
        int type = Integer.parseInt(args[1]);
        ArrayList<Trial> trials = new ArrayList<>();

        for (int N = 250; N <= scale; N += N) {
            double time = timeTrial(N);
            trials.add(new Trial(N, time));
            StdOut.printf("%7d %5.1f\n", N, time);
        }
        if (type == 0)
            draw(trials);
        else
            drawLg(trials);
    }

    private static void draw(ArrayList<Trial> trials) {
        Trial first = trials.get(0);
        Trial last = trials.get(trials.size() - 1);
        StdDraw.setXscale(first.N, last.N);
        StdDraw.setYscale(first.time, last.time);
        for (int i = 0; i < trials.size(); i++) {
            StdDraw.setPenRadius(0.02);
            StdDraw.point(trials.get(i).N, trials.get(i).time);
            if (i != 0) {
                StdDraw.setPenRadius(0.005);
                StdDraw.line(trials.get(i - 1).N, trials.get(i - 1).time, trials.get(i).N, trials.get(i).time);
            }
        }
    }

    private static void drawLg(ArrayList<Trial> trials) {
        ArrayList<Trial> lgTrials = new ArrayList<>();
        for (Trial t : trials) {
            lgTrials.add(new Trial(Math.log(t.N), Math.log(t.time)));
        }
        draw(lgTrials);
    }

    private record Trial(double N, double time) {
    }
}
