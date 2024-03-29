package ch1.sec3.ex48;

import ch1.sec3.ex33.Deque;


public class Stack<Item> {

    private final Deque<Item> q = new Deque<>();
    private int N1;
    private int N2;

    public int size1() {
        return N1;
    }

    public void push1(Item item) {
        q.pushLeft(item);
        N1 += 1;
    }

    public Item pop1() {
        if (N1 == 0)
            return null;
        N1 -= 1;
        return q.popLeft();
    }

    public int size2() {
        return N2;
    }

    public void push2(Item item) {
        q.pushRight(item);
        N2 += 1;
    }

    public Item pop2() {
        if (N2 == 0)
            return null;
        N2 -= 1;
        return q.popRight();
    }

}
