package com.claudhart.algs4.chapter2.section3.exercise24;

import edu.princeton.cs.algs4.Insertion;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

@SuppressWarnings({"rawtypes", "unchecked", "DuplicatedCode"})
public class Samplesort {

    // tag::snippet[]
    private static final int CUTOFF = 10;

    public static void sort(Comparable[] a) {
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        int size = hi - lo + 1;
        if (size <= CUTOFF) {
            Insertion.sort(a, lo, hi + 1);
            return;
        }

        // Number of samples ≈ lg(n/ln(n))
        int samplesNum = (int) Math.round(Math.log(size / Math.log(size)) / Math.log(2));

        // Randomly select samples
        for (int i = 0; i < samplesNum; i++) {
            int randomIndex = StdRandom.uniform(lo, hi + 1);
            exch(a, lo + i, randomIndex);
        }

        sort(a, lo, lo + samplesNum - 1);

        sort(a, lo + samplesNum, hi, samplesNum);
    }

    private static void sort(Comparable[] a, int lo, int hi, int samplesNum) {
        if (lo > hi) return;

        if (samplesNum == 0) {
            Insertion.sort(a, lo, hi + 1);
            return;
        }

        int halfSamplesWaitingMoved, samplesOnLeft, samplesOnRight;

        if (samplesNum > 0) {
            // Move half of the samples to the right.
            halfSamplesWaitingMoved = samplesNum / 2;
            samplesOnLeft = samplesNum - halfSamplesWaitingMoved;
            samplesOnRight = -halfSamplesWaitingMoved;
            for (int i = 0; i < halfSamplesWaitingMoved; i++)
                exch(a, --lo, hi--);
        } else {
            // Move half of the samples to the left.
            // Represent samples on the right side using negative numbers.
            // When dividing into two uneven parts, it is necessary to move the larger half to the left,
            // otherwise the right side will always have one element left out and unable to participate in the partition.
            halfSamplesWaitingMoved = (-samplesNum + 1) / 2;
            samplesOnLeft = halfSamplesWaitingMoved;
            samplesOnRight = samplesNum + halfSamplesWaitingMoved;
            for (int i = 0; i < halfSamplesWaitingMoved; i++)
                exch(a, lo++, ++hi);
        }

        // Partition on the median of the samples
        lo -= 1;
        samplesOnLeft -= 1;

        int partition = partition(a, lo, hi);

        sort(a, lo, partition - 1, samplesOnLeft);
        sort(a, partition + 1, hi, samplesOnRight);
    }
    // end::snippet[]

    private static int partition(Comparable[] a, int lo, int hi) {
        int i = lo, j = hi + 1;
        Comparable v = a[lo];
        while (true) {
            while (less(a[++i], v)) if (i == hi) break;
            while (less(v, a[--j])) if (j == lo) break;
            if (i >= j) break;
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }

    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
