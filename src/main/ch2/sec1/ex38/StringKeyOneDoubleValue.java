package ch2.sec1.ex38;

import edu.princeton.cs.algs4.StdRandom;

public class StringKeyOneDoubleValue implements Comparable<StringKeyOneDoubleValue> {
    final String key = SortCompare.randomString(10);
    
    double val = StdRandom.uniform();

    @Override
    public int compareTo(StringKeyOneDoubleValue o) {
        return this.key.compareTo(o.key);
    }
}
