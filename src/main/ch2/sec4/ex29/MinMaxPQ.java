package ch2.sec4.ex29;


@SuppressWarnings({"rawtypes"})
public class MinMaxPQ {
    private final MinPQ minPQ;
    private final MaxPQ maxPQ;

    public MinMaxPQ(int maxN) {
        minPQ = new MinPQ(maxN + 1);
        maxPQ = new MaxPQ(maxN + 1);
    }

    public int size() {
        return minPQ.size();
    }

    public void insert(Comparable v) {
        Item item = new Item(v);
        minPQ.insert(item);
        maxPQ.insert(item);
    }

    public Comparable delMax() {
        Item item = maxPQ.delMax();
        minPQ.del(item.minIndex);
        return item.key;
    }

    public Comparable delMin() {
        Item item = minPQ.delMin();
        maxPQ.del(item.maxIndex);
        return item.key;
    }

    public Comparable findMax() {
        return maxPQ.findMax().key;
    }

    public Comparable findMin() {
        return minPQ.findMin().key;
    }
}
