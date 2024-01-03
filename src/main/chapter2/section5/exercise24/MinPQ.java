package chapter2.section5.exercise24;


public class MinPQ<Key extends Comparable<Key>> {
    private final Wrapper<Key>[] pq;
    private int N = 0;

    @SuppressWarnings("unchecked")
    public MinPQ(int maxN) {
        pq = (Wrapper<Key>[]) new Wrapper[maxN + 1];
    }

    
    public boolean isEmpty() {
        return N == 0;
    }

    
    public int size() {
        return N;
    }

    public void insert(Key v) {
        pq[++N] = new Wrapper<>(v, N);
        swim(N);
    }

    public Key delMin() {
        Key max = pq[1].content;
        exch(1, N--);
        pq[N + 1] = null;
        sink(1);
        return max;
    }

    private void swim(int k) {
        while (k > 1 && less(k, k / 2)) {
            exch(k, k / 2);
            k /= 2;
        }
    }

    @SuppressWarnings("SameParameterValue")
    private void sink(int k) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j + 1 <= N && less(j + 1, j)) j += 1;
            if (less(j, k)) {
                exch(k, j);
                k = j;
            } else break;
        }
    }

    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void exch(int i, int j) {
        Wrapper<Key> swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
    }

    public static class Wrapper<Key extends Comparable<Key>> implements Comparable<Wrapper<Key>> {
        final Key content;
        final int order;

        public Wrapper(Key content, int order) {
            this.content = content;
            this.order = order;
        }

        @Override
        public int compareTo(MinPQ.Wrapper<Key> o) {
            if (content.compareTo(o.content) > 0)
                return 1;
            else if (content.compareTo(o.content) < 0)
                return -1;
            else
                return Integer.compare(order, o.order);
        }
    }

    @SuppressWarnings("ClassCanBeRecord")
    public static class Item implements Comparable<Item> {
        public final int id;
        public final String content;

        public Item(String content, int id) {
            this.content = content;
            this.id = id;
        }

        @Override
        public int compareTo(MinPQ.Item o) {
            return content.compareTo(o.content);
        }

        @Override
        public String toString() {
            return "{" + content + ", " + id + "}";
        }
    }
}
