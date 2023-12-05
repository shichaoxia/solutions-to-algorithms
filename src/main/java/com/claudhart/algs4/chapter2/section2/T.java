package com.claudhart.algs4.chapter2.section2;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class T {
    public static void main(String[] args) {
        @SuppressWarnings("SpellCheckingInspection") String s = "AEQSUYEINOST";
        StdOut.println(sortString(s));
    }

    public static String sortString(String inputString) {
        // Converting input string to character array
        char[] tempArray = inputString.toCharArray();

        // Sorting temp array using
        Arrays.sort(tempArray);

        // Returning new sorted string
        return new String(tempArray);
    }
}
