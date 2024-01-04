package ch2.sec4.ex31;

@SuppressWarnings("DuplicatedCode")
public class MinPQ<Key extends Comparable<Key>> {
    private final Key[] pq;
    private int N = 0;

    @SuppressWarnings("unchecked")
    public MinPQ(int maxN) {
        pq = (Key[]) new Comparable[maxN + 1];
    }

    public static void main(String[] args) {
        MinPQ<Integer> pq = new MinPQ<>(10);
        for (int i = 0; i < 10; i++) pq.insert(10 - i);
        pq.printHeap();
        pq.delMin();
        pq.delMin();
        pq.delMin();
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

    @SuppressWarnings("UnusedReturnValue")
    public Key delMin() {
        Key max = pq[1];
        exch(1, N--);
        pq[N + 1] = null;
        sink(1);
        return max;
    }

    
    public Key peek() {
        return pq[1];
    }

    // tag::snippet[]
    private void swim(int k) {
        if (k == 1) return;
        int[] ancestors = new int[(int) (Math.log(k) / Math.log(2))];
        for (int i = ancestors.length - 1, p = k / 2; p > 0; i--, p /= 2) {
            ancestors[i] = p;
        }

        int insertLocation = findInsertLocation(ancestors, 0, ancestors.length - 1, k);

        wrappedShiftRight(insertLocation, k);
    }

    private int findInsertLocation(int[] a, int lo, int hi, int k) {
        if (lo == hi && greater(a[lo], k)) return a[lo];
        int mid = (hi + lo) / 2;
        if (greater(a[mid], k)) return findInsertLocation(a, lo, mid, k);
        else return findInsertLocation(a, mid + 1, hi, k);
    }

    private void wrappedShiftRight(int start, int end) {
        Key lastItem = pq[end];
        for (int i = end; i > start; i--) {
            pq[i] = pq[i - 1];
        }
        pq[start] = lastItem;
    }
    // end::snippet[]

    @SuppressWarnings("SameParameterValue")
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
        return pq[i].compareTo(pq[j]) > 0;
    }

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
