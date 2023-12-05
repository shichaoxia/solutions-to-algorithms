package com.claudhart.algs4.chapter2.section4.exercise22;

import java.util.Arrays;

@SuppressWarnings({"unused", "DuplicatedCode"})
public class MaxPQ<Key extends Comparable<Key>> {
    private Key[] pq;
    private int N = 0;

    @SuppressWarnings("unchecked")
    public MaxPQ(int maxN) {
        pq = (Key[]) new Comparable[maxN + 1];
    }

    @SuppressWarnings("unchecked")
    public MaxPQ(Key[] a) {
        N = a.length;
        pq = (Key[]) new Comparable[N + 1];
        System.arraycopy(a, 0, pq, 1, N);
        for (int k = N / 2; k >= 1; k--)
            sink(k);
    }

    public static void main(String[] args) {
        MaxPQ<Integer> pq = new MaxPQ<>(1);
        for (int i = 0; i < 4; i++) {
            pq.insert(i);
            System.out.println(pq);
        }
        for (int i = 0; i < 4; i++) {
            pq.delMax();
            System.out.println(pq);
        }
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    // tag::snippet[]
    public void insert(Key v) {
        if (N == pq.length - 1) {
            resize(pq.length * 2);
        }
        pq[++N] = v;
        swim(N);
    }

    private void resize(int capacity) {
        @SuppressWarnings("unchecked")
        Key[] temp = (Key[]) new Comparable[capacity];
        System.arraycopy(pq, 1, temp, 1, N);
        pq = temp;
    }

    public Key delMax() {
        Key max = pq[1];
        exch(1, N--);
        pq[N + 1] = null;
        sink(1);
        if (N > 0 && N == (pq.length - 1) / 4) {
            resize(pq.length / 2);
        }
        return max;
    }
    // end::snippet[]

    private void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            exch(k, k / 2);
            k /= 2;
        }
    }

    @SuppressWarnings("SameParameterValue")
    private void sink(int k) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && less(j, j + 1)) j++;
            if (!less(k, j)) break;
            exch(k, j);
            k = j;
        }
    }

    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void exch(int i, int j) {
        Key swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
    }

    @Override
    public String toString() {
        return "MaxPQ{" +
                "pq=" + Arrays.toString(pq) +
                ", N=" + N +
                '}';
    }
}
