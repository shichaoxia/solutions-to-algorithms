package com.claudhart.algs4.chapter2.section4.exercise29;

@SuppressWarnings({"unused", "DuplicatedCode"})
public class MaxPQ {
    private final Item[] pq;
    private int N = 0;

    public MaxPQ(int maxN) {
        pq = new Item[maxN + 1];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    // tag::snippet[]
    public void insert(Item v) {
        pq[++N] = v;
        v.maxIndex = N;
        swim(N);
    }

    public Item delMax() {
        Item max = pq[1];
        del(1);
        return max;
    }

    public void del(int k) {
        exch(k, N--);
        pq[N + 1] = null;
        sink(k);
    }

    public Item findMax() {
        return pq[1];
    }

    private void exch(int i, int j) {
        Item swap = pq[i];
        pq[i] = pq[j];
        pq[i].maxIndex = i;
        pq[j] = swap;
        pq[j].maxIndex = j;
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
}
