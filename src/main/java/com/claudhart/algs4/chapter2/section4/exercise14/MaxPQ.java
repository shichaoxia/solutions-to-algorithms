package com.claudhart.algs4.chapter2.section4.exercise14;

@SuppressWarnings({"unused", "DuplicatedCode"})
public class MaxPQ<Key extends Comparable<Key>> {
    private final Key[] pq;
    private int N = 0;

    private int exchangeNum = 0;

    @SuppressWarnings("unchecked")
    public MaxPQ(int maxN) {
        pq = (Key[]) new Comparable[maxN + 1];
    }

    public static void main(String[] args) {
        int capacity = 15;
        MaxPQ<Integer> maxPQ = new MaxPQ<>(capacity);
        for (int i = 1; i <= capacity; i++) maxPQ.insert(i);
        System.out.printf("%17s %9s%n", "size after remove", "exchanges");
        for (int i = 0; i < 3; i++) {
            maxPQ.resetExchangeNum();
            maxPQ.delMax();
            System.out.printf("%17d %9d%n", maxPQ.size(), maxPQ.getExchangeNum());
        }
    }

    public int getExchangeNum() {
        return exchangeNum;
    }

    public void resetExchangeNum() {
        exchangeNum = 0;
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
        exchangeNum++;
    }
}
