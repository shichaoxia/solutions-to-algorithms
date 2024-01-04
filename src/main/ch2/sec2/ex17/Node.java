package ch2.sec2.ex17;

@SuppressWarnings({"rawtypes", "unchecked"})
public class Node {
    public Comparable item;
    public Node next;

    public boolean less(Node other) {
        return this.item.compareTo(other.item) < 0;
    }

    @Override
    public String toString() {
        return "Node{" +
                "item=" + item +
                ", next=" + next +
                '}';
    }
}
