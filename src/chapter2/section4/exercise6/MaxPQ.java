package chapter2.section4.exercise6;

import java.util.Arrays;

@SuppressWarnings({"unused", "DuplicatedCode"})
public class MaxPQ<Key extends Comparable<Key>> {
    @SuppressWarnings("FieldMayBeFinal")
    private Key[] pq;
    private int N = 0;

    @SuppressWarnings("unchecked")
    public MaxPQ(int maxN) {
        pq = (Key[]) new Comparable[maxN + 1];
    }

    public static void main(String[] args) {
        MaxPQ<String> pq = new MaxPQ<>(12);
        System.out.printf("%2s %39s%n", "op", "pq");
        String input = "P R I O * R * * I * T * Y * * * Q U E * * * U * E";
        String[] ops = input.split("\\s+");
        for (String op : ops) {
            if (op.equals("*")) {
                pq.delMax();
            } else {
                pq.insert(op);
            }
            System.out.printf("%2s %39s%n", op, Arrays.toString(pq.pq).replace("null", "_"));
        }
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

    @SuppressWarnings("UnusedReturnValue")
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
}
