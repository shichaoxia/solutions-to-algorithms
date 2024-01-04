package ch1.sec2.ex4;

import edu.princeton.cs.algs4.StdOut;

public class Ex4 {
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
