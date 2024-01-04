package ch2.sec4.ex18;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;
import java.util.Objects;

public class MaxPQ<Key extends Comparable<Key>> implements Cloneable {
    private Key[] pq;
    private int N = 0;

    @SuppressWarnings("unchecked")
    public MaxPQ(int maxN) {
        pq = (Key[]) new Comparable[maxN + 1];
    }

    public static void main(String[] args) {
        System.out.println("One billion trials.");
        System.out.println("Insert then delMax, identical? " + trialOne());
        System.out.println("Two insert then two delMax, identical? " + trialTwo());
    }

    private static boolean trialOne() {
        boolean result = true;
        int N = 10;
        int TRIALS = 1_000_000;
        MaxPQ<Integer> pq, copy;
        for (int i = 0; i < TRIALS; i++) {
            pq = generateRandomPQ(N);
            copy = pq.clone();
            pq.insert(N);
            pq.delMax();
            if (!pq.equals(copy)) {
                result = false;
                break;
            }
        }
        return result;
    }

    private static boolean trialTwo() {
        boolean result = true;
        int N = 10;
        int TRIALS = 1_000_000;
        MaxPQ<Integer> pq, copy;
        for (int i = 0; i < TRIALS; i++) {
            pq = generateRandomPQ(N);
            copy = pq.clone();
            pq.insert(N);
            pq.insert(N + 1);
            pq.delMax();
            pq.delMax();
            if (!pq.equals(copy)) {
                result = false;
                break;
            }
        }
        return result;
    }

    private static MaxPQ<Integer> generateRandomPQ(int N) {
        Integer[] a = new Integer[N];
        for (int i = 0; i < N; i++) a[i] = i;
        StdRandom.shuffle(a);
        MaxPQ<Integer> pq = new MaxPQ<>(2 * N);
        for (int i : a) pq.insert(i);
        return pq;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void insert(Key v) {
        pq[++N] = v;
        swim(N);
    }

    public Key delMax() {
        Key max = pq[1];
        exch(1, N--);
        pq[N + 1] = null;
        sink(1);
        return max;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MaxPQ<?> maxPQ = (MaxPQ<?>) o;
        return N == maxPQ.N && Arrays.equals(pq, maxPQ.pq);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(N);
        result = 31 * result + Arrays.hashCode(pq);
        return result;
    }

    @Override
    public MaxPQ<Key> clone() {
        try {
            @SuppressWarnings("unchecked")
            MaxPQ<Key> clone = (MaxPQ<Key>) super.clone();
            clone.pq = pq.clone();
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
