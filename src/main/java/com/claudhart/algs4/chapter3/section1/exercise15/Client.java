package com.claudhart.algs4.chapter3.section1.exercise15;

import edu.princeton.cs.algs4.BinarySearchST;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

import java.util.stream.IntStream;

public class Client {
    public static void main(String[] args) {
        final int MAX = 10_000;
        int[] searchesNums = {1_000, 1_000_000, 1_000_000_000};
        int insertsNum;
        Stopwatch timer;
        System.out.printf("%10s | %11s | %11s | %7s%n", "Searches", "Insert time", "Search time", "I/Total");
        for (int searchesNum : searchesNums) {
            insertsNum = searchesNum / 1_000;

            var st = new BinarySearchST<Integer, Integer>();

            timer = new Stopwatch();
            IntStream.range(0, insertsNum).forEach(i -> st.put(StdRandom.uniform(MAX), i));
            double insertTime = timer.elapsedTime();

            timer = new Stopwatch();
            IntStream.range(0, searchesNum).forEach(i -> st.get(StdRandom.uniform(MAX)));
            double searchTime = timer.elapsedTime();

            System.out.printf("%11d | %11.3f | %11.3f | %7.3f%n", searchesNum, insertTime, searchTime, insertTime / (insertTime + searchTime));
        }
    }
}
