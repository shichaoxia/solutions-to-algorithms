package ch1.sec3.ex49;

import ch1.sec3.Stack;
import edu.princeton.cs.algs4.StdOut;

public class Queue<Item> {

    private final Stack<Item> s1 = new Stack<>();
    private final Stack<Item> s2 = new Stack<>();
    private int N;

    
    public boolean isEmpty() {
        return N == 0;
    }

    
    public int size() {
        return N;
    }

    public void enqueue(Item item) {
        if (s1.isEmpty())
            switchToS1();
        N += 1;
        s1.push(item);
    }

    @SuppressWarnings("UnusedReturnValue")
    public Item dequeue() {
        if (s1.isEmpty() && s2.isEmpty())
            return null;
        if (s2.isEmpty())
            switchToS2();
        N -= 1;
        return s2.pop();
    }

    private void switchToS1() {
        while (!s2.isEmpty())
            s1.push(s2.pop());
    }

    private void switchToS2() {
        while (!s1.isEmpty())
            s2.push(s1.pop());
    }

    @Override
    public String toString() {
        if (s1.isEmpty()) {
            switchToS1();
        }
        return s1.toString();
    }

    public static void main(String[] args) {
        Queue<String> q = new Queue<>();
        q.enqueue("A");
        q.enqueue("B");
        q.enqueue("C");
        StdOut.println(q);
        q.dequeue();
        StdOut.println(q);
    }

}
