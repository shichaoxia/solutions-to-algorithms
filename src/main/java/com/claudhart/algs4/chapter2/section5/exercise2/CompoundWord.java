package com.claudhart.algs4.chapter2.section5.exercise2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CompoundWord {

    public static List<String> findCompoundWords(String[] words) {
        List<String> output = new ArrayList<>();
        Arrays.sort(words);
        for (int i = 1; i < words.length; i++) {
            if (words[i].startsWith(words[i - 1])) {
                String suffix = words[i].substring(words[i - 1].length());
                if (Arrays.binarySearch(words, suffix) >= 0) {
                    output.add(words[i]);
                }
            }
        }
        return output;
    }

}
