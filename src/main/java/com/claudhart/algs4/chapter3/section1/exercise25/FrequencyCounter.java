package com.claudhart.algs4.chapter3.section1.exercise25;

import com.claudhart.algs4.chapter3.section1.SequentialSearchST;
import com.claudhart.algs4.chapter3.section1.ST;
import edu.princeton.cs.algs4.Stopwatch;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

@SuppressWarnings("DuplicatedCode")
public class FrequencyCounter {

    final int minLen;
    final ST<String, Integer> st;
    final File file;

    public FrequencyCounter(int minLen, String file, ST<String, Integer> st) {
        this.minLen = minLen;
        this.file = new File(file);
        this.st = st;
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

    /********* Test Client *********/

    public static void main(String[] args) {
        printHeader();
        var sequentialResult = trial(new SequentialSearchST<>());
        var cachedSequentialResult = trial(new CachedSequentialSearchST<>());
        printRow("Sequential", sequentialResult.first, sequentialResult.second, sequentialResult.third);
        printRow("Cached", cachedSequentialResult.first, cachedSequentialResult.second, cachedSequentialResult.third);
    }

    private static Triple<String, Integer, Double> trial(ST<String, Integer> st) {
        Stopwatch timer = new Stopwatch();
        FrequencyCounter fc = new FrequencyCounter(1, "algs4-data/tale.txt", st);
        fc.count();
        String word = fc.max();
        int count = fc.st.get(word);
        double time = timer.elapsedTime();
        return new Triple<>(word, count, time);
    }

    private static void printHeader() {
        System.out.printf("%10s %10s %10s %10s\n", "alg", "word", "count", "time");
    }

    private static void printRow(String algorithm, String max, int count, double time) {
        System.out.printf("%10s %10s %10d %10.1f\n", algorithm, max, count, time);
    }

    private record Triple<T, U, V>(T first, U second, V third) {
    }
}
