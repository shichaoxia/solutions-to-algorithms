package ch2.sec4.ex29;

@SuppressWarnings("rawtypes")
public class Item implements Comparable<Item> {
    public final Comparable key;
    public int minIndex;
    public int maxIndex;

    public Item(Comparable key) {
        this.key = key;
    }

    @SuppressWarnings("unchecked")
    @Override
    public int compareTo(Item that) {
        return key.compareTo(that.key);
    }

    @Override
    public String toString() {
        return key.toString();
    }
}
