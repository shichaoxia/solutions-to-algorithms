package ch1.sec3.ex40;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class MoveToFront {
    @SuppressWarnings("DataFlowIssue")
    public static void main(String[] args) {
        String[] a = null;
        while (!StdIn.isEmpty()) {
            a = StdIn.readAllStrings();
        }
        LinkedList<String> l = new LinkedList<>();
        for (String s : a) {
            LinkedList<String>.DoubleNode node = l.find(s);
            if (node != null) {
                l.remove(node);
            }
            l.addFirst(s);
        }
        StdOut.println(l);
    }
}
