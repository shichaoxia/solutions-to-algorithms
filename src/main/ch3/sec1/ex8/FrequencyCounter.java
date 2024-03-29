package ch3.sec1.ex8;

import ch3.sec1.BinarySearchST;
import ch3.sec1.ST;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

@SuppressWarnings("DuplicatedCode")
public class FrequencyCounter {

    final int minLen;
    final ST<String, Integer> st;
    final File file;

    public FrequencyCounter(int minLen, String file, int capacity) {
        this.minLen = minLen;
        this.file = new File(file);
        st = new BinarySearchST<>(capacity);
    }

    public static void main(String[] args) {
        FrequencyCounter fc = new FrequencyCounter(10, "algs4-data/tale.txt", 140_000);
        fc.count();
        String max = fc.max();
        System.out.println(max + " " + fc.st.get(max));
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
}
