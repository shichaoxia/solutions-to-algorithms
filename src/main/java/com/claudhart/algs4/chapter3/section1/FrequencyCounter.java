package com.claudhart.algs4.chapter3.section1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class FrequencyCounter {
    @SuppressWarnings({"Convert2Diamond", "DuplicatedCode", "DataFlowIssue"})
    public static void main(String[] args) {
        //noinspection SpellCheckingInspection
        int minlen = Integer.parseInt(args[0]);     // key-length cutoff
        ST<String, Integer> st = new ST<String, Integer>() {
            @Override
            public void put(String s, Integer val) {

            }

            @Override
            public Integer get(String s) {
                return null;
            }

            @Override
            public void delete(String s) {

            }

            @Override
            public boolean contains(String s) {
                return false;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public int size() {
                return 0;
            }

            @Override
            public Iterable<String> keys() {
                return null;
            }
        };
        while (!StdIn.isEmpty()) {                  // Build symbol table and count frequencies.
            String word = StdIn.readString();
            if (word.length() < minlen) continue;   // Ignore short keys.
            if (!st.contains(word)) st.put(word, 1);
            else st.put(word, st.get(word) + 1);
        }
        // Find a key with the highest frequency count.
        String max = "";
        st.put(max, 0);
        for (String word : st.keys())
            if (st.get(word) > st.get(max))
                max = word;
        StdOut.println(max + " " + st.get(max));
    }
}
