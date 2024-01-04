package ch1.sec1.ex6;

import edu.princeton.cs.algs4.StdOut;

public class Ex6 {
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
