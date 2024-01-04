package ch1.sec3.ex6;

import ch1.sec3.Queue;
import ch1.sec3.Stack;
import edu.princeton.cs.algs4.StdOut;

public class Ex6 {
    public static void reverse(Queue<String> q) {
        Stack<String> stack = new Stack<>();
        while (!q.isEmpty())
            stack.push(q.dequeue());
        while (!stack.isEmpty())
            q.enqueue(stack.pop());
    }

    public static void main(String[] args) {
        Queue<String> q = new Queue<>();
        q.enqueue("a");
        q.enqueue("b");
        q.enqueue("c");
        StdOut.println("Original q: " + q);
        reverse(q);
        StdOut.println("Reversed q: " + q);
    }
}
