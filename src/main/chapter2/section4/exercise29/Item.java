package chapter2.section4.exercise29;

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
