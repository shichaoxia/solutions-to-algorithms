package chapter2.section2.exercise18;

import edu.princeton.cs.algs4.StdRandom;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.FileReader;

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
    public static LinkedList shuffle(LinkedList l) {
        if (l.size < 2) return l;
        LinkedList firstHalf = l.divide();
        return randomMerge(shuffle(firstHalf), shuffle(l));
    }

    public static LinkedList randomMerge(LinkedList a, LinkedList b) {
        LinkedList l = new LinkedList();
        boolean pickB = randomBool();
        while (a.size != 0 || b.size != 0) {
            if (a.size == 0) l.addLast(b.randomRemove());
            else if (b.size == 0) l.addLast(a.randomRemove());
            else if (pickB) l.addLast(b.randomRemove());
            else l.addLast(a.randomRemove());
            pickB = randomBool();
        }
        return l;
    }
    // end::snippet[]

    public static boolean randomBool() {
        return StdRandom.uniform(0, 2) == 1;
    }

    /**
     * @return If the linked list is empty or has only one element, return an empty linked list; otherwise, divide the
     * linked list into two (⌊size/2⌋ and rest) and return the first half of the linked list while pointing to the
     * second half.
     */
    @NotNull
    public LinkedList divide() {
        int prevSize = size / 2;
        if (prevSize == 0) return new LinkedList();
        Node prevBorder = at(prevSize - 1);
        return splitAfter(prevBorder);
    }

    @NotNull
    public LinkedList splitAfter(@NotNull Node node) {
        LinkedList l = new LinkedList();
        int splitSize = countFromFirstTo(node);
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

    public LinkedList addFirst(Comparable item) {
        Node newFirst = new Node();
        newFirst.item = item;
        if (first == null) last = newFirst;
        else newFirst.next = first;
        first = newFirst;
        size += 1;
        return this;
    }

    public LinkedList addLast(Comparable item) {
        Node newLast = new Node();
        newLast.item = item;
        if (last == null) first = newLast;
        else last.next = newLast;
        last = newLast;
        size += 1;
        return this;
    }

    @Nullable
    public Comparable removeFirst() {
        if (first == null) return null;
        Node oldFirst = first;
        if (first == last) {
            first = null;
            last = null;
        } else {
            first = first.next;
            oldFirst.next = null;
        }
        size -= 1;
        return oldFirst.item;
    }

    @Nullable
    public Comparable removeLast() {
        if (last == null) return null;
        Node oldLast = last;
        if (first == last) {
            last = null;
            first = null;
        } else {
            Node prevLast = at(size - 1);
            prevLast.next = null;
            last = prevLast;
        }
        size -= 1;
        return oldLast.item;
    }

    @Nullable
    public Comparable randomRemove() {
        if (size == 0) return null;
        int chosenIndex = StdRandom.uniform(0, size);
        if (chosenIndex == 0) return removeFirst();
        if (chosenIndex == size - 1) return removeLast();

        Node prevChosen = at(chosenIndex - 1);
        Node chosen = prevChosen.next;
        prevChosen.next = chosen.next;
        chosen.next = null;

        size -= 1;
        return chosen.item;
    }

    @NotNull
    public Node at(int index) {
        if (index > size - 1)
            throw new IndexOutOfBoundsException();
        Node node = first;
        for (; index != 0; index--)
            node = node.next;
        return node;
    }


    public int countFromFirstTo(Node node) {
        if (node == null) throw new RuntimeException("node should not be null");
        int count = 1;
        for (Node i = first; i != node; i = i.next)
            count += 1;
        return count;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Node i = first; i != null; i = i.next) s.append(i.item);
        return s.toString();
    }
}
