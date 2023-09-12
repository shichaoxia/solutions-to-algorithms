package chapter3.section1.exercise19;

import chapter3.section1.BinarySearchST;
import chapter3.section1.OrderedST;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class FrequencyCounter {
    OrderedST<String, Integer> st = new BinarySearchST<>();
    int minLen;
    File file;

    public FrequencyCounter(int minLen, String file) {
        this.minLen = minLen;
        this.file = new File(file);
    }

    public static void main(String[] args) {
        FrequencyCounter fc = new FrequencyCounter(17, "algs4-data/tale.txt");
        fc.count();
        List<String> maxKeys = fc.max();
        for (String maxKey : maxKeys)
            System.out.println(maxKey + " " + fc.st.get(maxKey));
    }

    @SuppressWarnings("DuplicatedCode")
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

    public List<String> max() {
        String maxKey = st.min();
        int maxValue = st.get(maxKey);
        List<String> maxKeys = new ArrayList<>();

        for (String word : st.keys())
            if (st.get(word) > st.get(maxKey)) {
                maxKey = word;
                maxValue = st.get(word);
                maxKeys.clear();
                maxKeys.add(word);
            } else if (st.get(word) == maxValue)
                maxKeys.add(word);
        return maxKeys;
    }
}
