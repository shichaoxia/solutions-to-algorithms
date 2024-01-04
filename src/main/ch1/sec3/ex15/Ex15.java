package ch1.sec3.ex15;

import ch1.sec3.Queue;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Ex15 {
    public static void main(String[] args) {
        int k = Integer.parseInt(args[0]);
        Queue<String> q = new Queue<>();
        while (!StdIn.isEmpty())
            q.enqueue(StdIn.readString());
        int countForward = q.size() - k + 1;
        String out = null;
        while (countForward != 0) {
            out = q.dequeue();
            countForward -= 1;
        }
        StdOut.printf("Penultimate %dth string: %s%n", k, out);
    }
}
