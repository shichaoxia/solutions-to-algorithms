package com.claudhart.algs4.chapter2.section4.exercise26;

@SuppressWarnings({"unused", "DuplicatedCode"})
public class MaxPQ<Key extends Comparable<Key>> {
    @SuppressWarnings("FieldMayBeFinal")
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
        MaxPQ<Integer> pq = new MaxPQ<>(10);
        for (int i = 0; i < 10; i++) pq.insert(i);
        pq.printHeap();
        pq.delMax();
        pq.delMax();
        pq.delMax();
        pq.printHeap();
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

    // tag::snippet[]
    private void swim(int k) {
        int end = k;

        while (k > 1 && less(k / 2, end))
            k /= 2;

        wrappedShiftRight(k, end);
    }

    private void wrappedShiftRight(int start, int end) {
        Key lastItem = pq[end];
        for (int i = end; i > start; i--) {
            pq[i] = pq[i - 1];
        }
        pq[start] = lastItem;
    }

    private void sink(int k) {
        int first = k;
        int[] sinkPath = new int[N];
        int pathLength = 0;
        sinkPath[pathLength++] = k;
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && less(j, j + 1)) j++;
            if (!less(first, j)) break;
            sinkPath[pathLength++] = j;
            k = j;
        }
        int[] path = new int[pathLength];
        System.arraycopy(sinkPath, 0, path, 0, pathLength);
        wrappedShiftLeft(path);
    }

    private void wrappedShiftLeft(int[] path) {
        Key firstItem = pq[path[0]];
        for (int i = 0; i < path.length - 1; i++) {
            pq[path[i]] = pq[path[i + 1]];
        }
        pq[path[path.length - 1]] = firstItem;
    }
    // end::snippet[]

    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    @SuppressWarnings("SameParameterValue")
    private void exch(int i, int j) {
        Key swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
    }

    public void printHeap() {
        int level = 0;
        int levelNodes = (int) Math.pow(2, level);
        int startIndex = 1;
        while (startIndex <= N) {
            for (int i = 0; i < levelNodes && startIndex <= N; i++) {
                System.out.print(pq[startIndex++] + " ");
            }
            level++;
            levelNodes = (int) Math.pow(2, level);
            System.out.println();
        }
    }
}
