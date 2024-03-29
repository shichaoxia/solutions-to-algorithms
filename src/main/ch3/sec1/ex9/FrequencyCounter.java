package ch3.sec1.ex9;

import ch3.sec1.BinarySearchST;
import ch3.sec1.ST;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FrequencyCounter {

    final int minLen;
    final ST<String, Integer> st;
    final File file;

    String lastPut = "";
    int putCount = 0;

    public FrequencyCounter(int minLen, String file, int capacity) {
        this.minLen = minLen;
        this.file = new File(file);
        st = new BinarySearchST<>(capacity);
    }

    public static void main(String[] args) {
        var cutoffs = new int[]{1, 8, 10};
        System.out.printf("%-10s | %-13s | %-10s\n", "Cutoff", "Last Put", "Put Count");
        for (var cutoff : cutoffs) {
            FrequencyCounter counter = new FrequencyCounter(cutoff, "algs4-data/tale.txt", 140_000);
            counter.count();
            System.out.printf("%10d | %13s | %10d\n", cutoff, counter.lastPut, counter.putCount);
        }
    }

    public void count() {
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                String word = scanner.next();
                if (word.length() < minLen) continue;
                if (st.contains(word)) put(word, st.get(word) + 1);
                else put(word, 1);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void put(String key, int value) {
        lastPut = key;
        putCount++;
        st.put(key, value);
    }

    
    public String max() {
        String max = "";
        st.put(max, 0);
        for (String word : st.keys())
            if (st.get(word) > st.get(max)) max = word;
        return max;
    }
}
