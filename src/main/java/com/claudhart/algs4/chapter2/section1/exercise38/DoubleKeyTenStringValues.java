package com.claudhart.algs4.chapter2.section1.exercise38;

public class DoubleKeyTenStringValues implements Comparable<DoubleKeyTenStringValues> {
    final String key = SortCompare.randomString(10);
    @SuppressWarnings("unused")
    String val0 = SortCompare.randomString(10);
    @SuppressWarnings("unused")
    String val1 = SortCompare.randomString(10);
    @SuppressWarnings("unused")
    String val2 = SortCompare.randomString(10);
    @SuppressWarnings("unused")
    String val3 = SortCompare.randomString(10);
    @SuppressWarnings("unused")
    String val4 = SortCompare.randomString(10);
    @SuppressWarnings("unused")
    String val5 = SortCompare.randomString(10);
    @SuppressWarnings("unused")
    String val6 = SortCompare.randomString(10);
    @SuppressWarnings("unused")
    String val7 = SortCompare.randomString(10);
    @SuppressWarnings("unused")
    String val8 = SortCompare.randomString(10);
    @SuppressWarnings("unused")
    String val9 = SortCompare.randomString(10);

    @Override
    public int compareTo(DoubleKeyTenStringValues o) {
        return this.key.compareTo(o.key);
    }
}
