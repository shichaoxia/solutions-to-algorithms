package ch2.sec5.ex11;

import edu.princeton.cs.algs4.*;


import java.util.Arrays;

public class Entry implements Comparable<Entry> {
    private final int value;
    private final int originalIndex;

    public Entry(int value, int originalIndex) {
        this.value = value;
        this.originalIndex = originalIndex;
    }

    public static void main(String[] args) {
        Entry[] entries = new Entry[7];
        for (int i = 0; i < 7; i++) {
            entries[i] = new Entry(0, i);
        }
        System.out.printf("%10s %25s%n", "Algorithm", "Original Index");
        String[] algs = {"insertion", "selection", "shellsort", "mergesort", "quicksort", "heapsort"};
        for (String alg : algs) {
            System.out.printf("%10s %25s%n", alg, Arrays.toString(sort(alg, entries)));
        }
    }

    public static Entry[] sort(String alg, Entry[] entries) {
        Entry[] copyEntries = entries.clone();
        switch (alg) {
            case "insertion" -> Insertion.sort(copyEntries);
            case "selection" -> Selection.sort(copyEntries);
            case "shellsort" -> Shell.sort(copyEntries);
            case "mergesort" -> Merge.sort(copyEntries);
            case "quicksort" -> Quick.sort(copyEntries);
            case "heapsort" -> Heap.sort(copyEntries);
            default -> throw new IllegalArgumentException("Invalid algorithm: " + alg);
        }
        return copyEntries;
    }

    @Override
    public int compareTo(Entry o) {
        return Integer.compare(this.value, o.value);
    }

    @Override
    public String toString() {
        return String.valueOf(originalIndex);
    }
}
