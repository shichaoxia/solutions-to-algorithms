package chapter1.section1;

import java.util.Arrays;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import static chapter1.section1.BinarySearch.rank;

public class Exercise23 {

    public static void main(String[] args) {
        int[] whitelist = new In(args[0]).readAllInts();
        Arrays.sort(whitelist);
        StdOut.println("Whitelist: " + Arrays.toString(whitelist));
        while (!StdIn.isEmpty()) {
            int key = StdIn.readInt();
            int idx = rank(key, whitelist);
            String presentPrefix = (idx < 0) ? "+" : "-";
            StdOut.printf("%s %d %d%n", presentPrefix, key, idx);
        }
    }
}
