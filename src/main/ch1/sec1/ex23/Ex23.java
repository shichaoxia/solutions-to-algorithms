package ch1.sec1.ex23;

import ch1.sec1.BinarySearch;

import java.util.Arrays;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Ex23 {

    public static void main(String[] args) {
        int[] whitelist = new In(args[0]).readAllInts();
        Arrays.sort(whitelist);
        StdOut.println("Whitelist: " + Arrays.toString(whitelist));
        while (!StdIn.isEmpty()) {
            int key = StdIn.readInt();
            int idx = BinarySearch.rank(key, whitelist);
            String presentPrefix = (idx < 0) ? "+" : "-";
            StdOut.printf("%s %d %d%n", presentPrefix, key, idx);
        }
    }
}
