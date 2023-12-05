package com.claudhart.algs4.chapter2.section5.exercise4;

public class RemoveDuplicates {
    public static String[] dedup(String[] a) {
        int n = a.length;
        String[] aux = new String[n];
        int i = 0;
        for (String s : a) {
            if (i == 0 || !s.equals(aux[i - 1])) {
                aux[i++] = s;
            }
        }
        String[] result = new String[i];
        System.arraycopy(aux, 0, result, 0, i);
        return result;
    }
}
