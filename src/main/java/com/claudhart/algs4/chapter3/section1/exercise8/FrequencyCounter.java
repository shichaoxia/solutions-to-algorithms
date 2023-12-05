package com.claudhart.algs4.chapter3.section1.exercise8;

import com.claudhart.algs4.chapter3.section1.BinarySearchST;
import com.claudhart.algs4.chapter3.section1.ST;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FrequencyCounter {

    int minLen;
    ST<String, Integer> st;
    File file;

    public FrequencyCounter(int minLen, String file, int capacity) {
        this.minLen = minLen;
        this.file = new File(file);
        st = new BinarySearchST<>(capacity);
    }

    public static void main(String[] args) {
        FrequencyCounter fc = new FrequencyCounter(10, "algs4-data/tale.txt", 140_000);
        fc.count();
        String max = fc.max();
        System.out.println(max + " " + fc.st.get(max));
    }

    public void count() {
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                String word = scanner.next();
                if (word.length() < minLen) continue;
                if (!st.contains(word)) st.put(word, 1);
                else st.put(word, st.get(word) + 1);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public String max() {
        String max = "";
        st.put(max, 0);
        for (String word : st.keys())
            if (st.get(word) > st.get(max)) max = word;
        return max;
    }
}
