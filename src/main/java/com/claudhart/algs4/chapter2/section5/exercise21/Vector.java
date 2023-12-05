package com.claudhart.algs4.chapter2.section5.exercise21;

public class Vector {
    int first;
    int second;
    int third;

    public Vector(int first, int second, int third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public int compareTo(Vector that) {
        if (this.first < that.first) return -1;
        if (this.first > that.first) return 1;
        if (this.second < that.second) return -1;
        if (this.second > that.second) return 1;
        return Integer.compare(this.third, that.third);
    }
}
