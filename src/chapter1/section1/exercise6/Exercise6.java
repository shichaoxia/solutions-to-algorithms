package chapter1.section1.exercise6;

import edu.princeton.cs.algs4.StdOut;

public class Exercise6 {
    public static void printFibonacci() {
        int f = 0;  // 1 1 2 3 5 8
        int g = 1;  // 0 1 1 2 3 5
        for (int i = 0; i <= 15; i++) {
            StdOut.println(f);
            f = f + g;
            g = f - g;
        }
    }
}
