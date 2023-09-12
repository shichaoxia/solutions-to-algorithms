package chapter2.section2.exercise17;

@SuppressWarnings({"rawtypes", "DuplicatedCode"})
public class LinkedList {
    public Node first;
    public Node last;
    public int size;

    public static LinkedList fromArray(Comparable[] a) {
        LinkedList l = new LinkedList();
        for (Comparable comparable : a) l.addLast(comparable);
        return l;
    }

    // tag::snippet[]
    public static LinkedList sort(LinkedList l) {
        if (l.size == 0) return l;
        while (l.findSortedSegment() != l.last)  // Restart the sorting process from the beginning if the list is not fully sorted.
            l = merge(l);
        return l;
    }

    /**
     * A merge trip
     */
    public static LinkedList merge(LinkedList l) {
        if (l.size == 0) return l;
        LinkedList segOne = l.splitSortedSegment();
        LinkedList segTwo = l.splitSortedSegment();
        if (segTwo.size == 0) return segOne;
        return concatenate(merge(segOne, segTwo), merge(l));
    }

    public static LinkedList merge(LinkedList a, LinkedList b) {
        LinkedList l = new LinkedList();
        while (a.size != 0 || b.size != 0)
            if (a.size == 0) l.addLast(b.removeFirst());
            else if (b.size == 0) l.addLast(a.removeFirst());
            else if (b.first.less(a.first)) l.addLast(b.removeFirst());
            else l.addLast(a.removeFirst());
        return l;
    }
    // end::snippet[]

    public static LinkedList concatenate(LinkedList a, LinkedList b) {
        if (a.size == 0) return b;
        else if (b.size == 0) return a;
        else {
            LinkedList l = new LinkedList();
            l.size = a.size + b.size;
            a.last.next = b.first;
            l.first = a.first;
            l.last = b.last;
            return l;
        }
    }

    public LinkedList addFirst(Comparable item) {
        Node node = new Node();
        node.item = item;
        if (first == null) {
            first = node;
            last = node;
        } else {
            node.next = first;
            first = node;
        }
        size += 1;
        return this;
    }

    public LinkedList addLast(Comparable item) {
        Node node = new Node();
        node.item = item;
        if (last == null) first = node;
        else last.next = node;
        last = node;
        size += 1;
        return this;
    }

    public Comparable removeFirst() {
        if (first == null) return null;
        Node node = first;
        first = first.next;
        node.next = null;
        size -= 1;
        return node.item;
    }

    public LinkedList splitAfter(Node node) {
        LinkedList l = new LinkedList();
        if (node == null) return l;
        int splitSize = count(node);
        if (node == last) {
            l.first = first;
            l.last = last;
            first = null;
            last = null;
        } else {
            l.first = first;
            l.last = node;
            first = node.next;
            node.next = null;
        }
        l.size = splitSize;
        size = size - splitSize;
        return l;
    }

    public int count(Node node) {
        if (node == null) throw new RuntimeException("node should not be null");
        int count = 1;
        for (Node i = first; i != node; i = i.next)
            count += 1;
        return count;
    }

    public Node findSortedSegment() {
        if (first == null) return null;
        Node i = first;
        while (i.next != null && !i.next.less(i)) {
            i = i.next;
        }
        return i;
    }

    public LinkedList splitSortedSegment() {
        return splitAfter(findSortedSegment());
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Node i = first; i != null; i = i.next) s.append(i.item);
        return s.toString();
    }
}
