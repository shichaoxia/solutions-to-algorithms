package chapter1.section4.exercise43;

import chapter1.section3.ResizingArrayStack;
import chapter1.section3.Stack;
import chapter1.section4.Stopwatch;
import edu.princeton.cs.algs4.StdOut;

@SuppressWarnings("InfiniteLoopStatement")
public class ResizingArraysVersusLinkedLists {

    public static void main(String[] args) {
        Stopwatch timer;
        StdOut.println("N Linked Resizing Linked/Resizing");
        for (int N = 250; true; N += N) {
            ResizingArrayStack<Integer> rs = new ResizingArrayStack<>();
            Stack<Integer> ls = new Stack<>();

            timer = new Stopwatch();
            for (int i = 0; i < N; ++i)
                rs.push(i);
            double rsTime = timer.elapsedTime();

            timer = new Stopwatch();
            for (int i = 0; i < N; ++i)
                ls.push(i);
            double lsTime = timer.elapsedTime();
            StdOut.printf("%10d %7.3f %7.3f %7.1f%n", N, lsTime, rsTime, lsTime / rsTime);
        }
    }
}
