package chapter2.section1.exercise38;

import edu.princeton.cs.algs4.StdRandom;

public class IntKeyOneIntArrayValue implements Comparable<IntKeyOneIntArrayValue> {
    int key = StdRandom.uniform(0, 1_000_000);
    int[] val = new int[20];

    public IntKeyOneIntArrayValue() {
        for (int i = 0; i < 20; i++) {
            val[i] = StdRandom.uniform(0, 1_000_000);
        }
    }

    @Override
    public int compareTo(IntKeyOneIntArrayValue o) {
        return this.key - o.key;
    }
}
