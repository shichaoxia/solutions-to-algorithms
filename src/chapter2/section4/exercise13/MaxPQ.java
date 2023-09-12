package chapter2.section4.exercise13;

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
        MaxPQ<Integer> maxPQ = new MaxPQ<>(10);
        maxPQ.insert(1);
        maxPQ.insert(2);
        maxPQ.insert(3);
        maxPQ.insert(4);
        maxPQ.insert(5);
        maxPQ.insert(6);
        maxPQ.insert(7);
        maxPQ.insert(8);
        maxPQ.insert(9);
        maxPQ.insert(10);
        while (!maxPQ.isEmpty()) {
            System.out.println(maxPQ.delMax());
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

    // tag::snippet[]
    @SuppressWarnings("SameParameterValue")
    private void sink(int k) {
        while (2 * k + 1 <= N) {
            int j = 2 * k;
            if (less(j, j + 1)) j++;
            if (!less(k, j)) break;
            exch(k, j);
            k = j;
        }
        if (2 * k <= N && less(k, 2 * k)) exch(k, 2 * k);
    }
    // end::snippet[]

    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void exch(int i, int j) {
        Key swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
    }
}
