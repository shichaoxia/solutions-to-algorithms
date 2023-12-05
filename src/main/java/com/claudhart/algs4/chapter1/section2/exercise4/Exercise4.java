package com.claudhart.algs4.chapter1.section2.exercise4;

import edu.princeton.cs.algs4.StdOut;

public class Exercise4 {
    public static void print() {
        String string1 = "hello";
        String string2 = string1;
        string1 = "world";
        StdOut.println(string1);
        StdOut.println(string2);
    }
    public static void main(String[] args) {
        print();
    }
}
