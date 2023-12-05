package com.claudhart.algs4.chapter1.section3.exercise6;

import com.claudhart.algs4.chapter1.section3.Queue;
import com.claudhart.algs4.chapter1.section3.Stack;
import edu.princeton.cs.algs4.StdOut;

public class Exercise6 {
    public static void reverse(Queue<String> q) {
        Stack<String> stack = new Stack<String>();
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
