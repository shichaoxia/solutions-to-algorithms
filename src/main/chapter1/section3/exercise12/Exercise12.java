package chapter1.section3.exercise12;

import chapter1.section3.Stack;
import edu.princeton.cs.algs4.StdOut;

public class Exercise12 {
    public static <Item> Stack<Item> copy(Stack<Item> s) {
        Stack<Item> newStack = new Stack<>();
        Stack<Item> tmpStack = new Stack<>();
        for (Item item : s) {
            tmpStack.push(item);
        }
        for (Item item : tmpStack) {
            newStack.push(item);
        }
        return newStack;
    }

    public static void main(String[] args) {
        Stack<String> s = new Stack<>();
        s.push("a");
        s.push("b");
        s.push("c");

        StdOut.println("Original stack: " + s);
        String o = s.peek();
        StdOut.println("Top item of original stack: " + s.peek() + "@" + System.identityHashCode(o));

        Stack<String> newStack = copy(s);
        String n = s.peek();
        StdOut.println("Copied stack: " + newStack);
        StdOut.println("Top item of copied stack: " + s.peek() + "@" + System.identityHashCode(n));
    }
}
