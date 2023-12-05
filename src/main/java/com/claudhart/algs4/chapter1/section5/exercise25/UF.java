package com.claudhart.algs4.chapter1.section5.exercise25;

public interface UF {

    @SuppressWarnings("unused")
    int count();

    boolean connected(int p, int q);

    @SuppressWarnings("unused")
    int find(int p);

    void union(int p, int q);
}