package ch2.sec5.ex8;

import edu.princeton.cs.algs4.Quick;

public class Frequency {
    public static String frequency(String[] a) {
        Quick.sort(a);
        int N = a.length;
        int k = -1;
        String[] keys = new String[N];
        int[] frequencies = new int[N];
        for (int i = 0; i < N; i++) {
            if (k == -1 || !a[i].equals(a[i - 1])) {
                keys[++k] = a[i];
                frequencies[k] = 1;
            } else {
                frequencies[k] += 1;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            if (keys[i] == null) break;
            sb.append(keys[i]).append(" ").append(frequencies[i]).append("\n");
        }
        return sb.toString();
    }
}
