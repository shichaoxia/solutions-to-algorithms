package chapter2.section4.exercise33;

public class IndexMinPQ<Key extends Comparable<Key>> {
    public final Key[] keys;
    private final int[] pq;
    private final int[] qp;
    private int N = 0;

    @SuppressWarnings("unchecked")
    public IndexMinPQ(int maxN) {
        keys = (Key[]) new Comparable[maxN + 1];
        pq = new int[maxN + 1];
        qp = new int[maxN + 1];
        for (int i = 0; i <= maxN; i++) qp[i] = -1;
    }

    void insert(int k, Key key) {
        keys[k] = key;
        pq[++N] = k;
        qp[k] = N;
        swim(N);
    }

    void change(int k, Key key) {
        keys[k] = key;
        swim(qp[k]);
        sink(qp[k]);
    }

    boolean contains(int k) {
        return qp[k] != -1;
    }

    void delete(int k) {
        int index = qp[k];
        exch(index, N--);
        swim(index);
        sink(index);
        keys[k] = null;
        qp[k] = -1;
    }

    Key min() {
        return keys[pq[1]];
    }

    int minIndex() {
        return pq[1];
    }

    public Key delMin() {
        int indexOfMin = pq[1];
        exch(1, N--);
        sink(1);
        Key min = keys[indexOfMin];
        keys[indexOfMin] = null;
        qp[indexOfMin] = -1;
        pq[N + 1] = -1;
        return min;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    private void swim(int k) {
        while (k > 1 && greater(k / 2, k)) {
            exch(k, k / 2);
            k /= 2;
        }
    }

    private void sink(int k) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && greater(j, j + 1)) j++;
            if (!greater(k, j)) break;
            exch(k, j);
            k = j;
        }
    }

    private boolean greater(int i, int j) {
        return keys[pq[i]].compareTo(keys[pq[j]]) > 0;
    }

    private void exch(int i, int j) {
        int swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;

        qp[pq[i]] = i;
        qp[pq[j]] = j;
    }

    public void printHeap() {
        int level = 0;
        int levelNodes = (int) Math.pow(2, level);
        int startIndex = 1;
        while (startIndex <= N) {
            for (int i = 0; i < levelNodes && startIndex <= N; i++) {
                System.out.print(keys[pq[startIndex++]] + " ");
            }
            level++;
            levelNodes = (int) Math.pow(2, level);
            System.out.println();
        }
    }

}
