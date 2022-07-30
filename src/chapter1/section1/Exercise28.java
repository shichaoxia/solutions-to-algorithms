package chapter1.section1;

import java.util.HashSet;
import java.util.Set;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Exercise28 {
    public static void main(String[] args) {
        int[] whitelist = new In(args[0]).readAllInts();

        Set<Integer> set = new HashSet<Integer>();
        for (int el : whitelist)
            set.add(el);

        StdOut.println(set);
    }
}
