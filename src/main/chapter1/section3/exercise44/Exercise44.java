package chapter1.section3.exercise44;

import chapter1.section3.Stack;
import edu.princeton.cs.algs4.StdOut;

public class Exercise44 {
    public static class Buffer {
        private final Stack<Character> left;
        private final Stack<Character> right;

        public Buffer() {
            left = new Stack<>();
            right = new Stack<>();
        }

        public void insert(char c) {
            left.push(c);
        }

        public void left(int k) {
            if (left.isEmpty() || k == 0)
                return;
            char c = left.pop();
            right.push(c);
            left(k - 1);
        }

        
        public void right(int k) {
            if (left.isEmpty() || k == 0)
                return;
            char c = right.pop();
            left.push(c);
            right(k - 1);
        }

        
        public int size() {
            return left.size() + right.size();
        }

        @Override
        public String toString() {
            StringBuilder s = new StringBuilder();
            Stack<Character> tmp = new Stack<>();
            for (Character c : left)
                tmp.push(c);
            for (Character c : tmp)
                s.append(c);
            s.append("|");
            for (Character c : right)
                s.append(c);
            return s.toString();
        }
    }

    public static void main(String[] args) {
        Buffer b = new Buffer();
        b.insert('a');
        b.insert('b');
        b.insert('c');
        b.insert('d');
        b.insert('e');
        StdOut.println("Insert     : " + b);
        b.left(2);
        StdOut.println("Move  left : " + b);
        b.insert('x');
        b.insert('y');
        StdOut.println("Insert     : " + b);
    }
}
