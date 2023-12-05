package com.claudhart.algs4.chapter2.section1.exercise38;

public class DoubleKeyTenStringValues implements Comparable<DoubleKeyTenStringValues> {
    String key = SortCompare.randomString(10);
    String val0 = SortCompare.randomString(10);
    String val1 = SortCompare.randomString(10);
    String val2 = SortCompare.randomString(10);
    String val3 = SortCompare.randomString(10);
    String val4 = SortCompare.randomString(10);
    String val5 = SortCompare.randomString(10);
    String val6 = SortCompare.randomString(10);
    String val7 = SortCompare.randomString(10);
    String val8 = SortCompare.randomString(10);
    String val9 = SortCompare.randomString(10);

    @Override
    public int compareTo(DoubleKeyTenStringValues o) {
        return this.key.compareTo(o.key);
    }
}
