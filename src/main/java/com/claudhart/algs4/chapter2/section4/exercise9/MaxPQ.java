package com.claudhart.algs4.chapter2.section4.exercise9;

import java.util.*;

@SuppressWarnings({"unused", "DuplicatedCode"})
public class MaxPQ<Key extends Comparable<Key>> {
    @SuppressWarnings("FieldMayBeFinal")
    private Key[] pq;
    private int N = 0;

    @SuppressWarnings("unchecked")
    public MaxPQ(int maxN) {
        pq = (Key[]) new Comparable[maxN + 1];
    }

    public static void main(String[] args) {
        String input = "A B C D E";
        allDifferentHeaps(input);
        input = "A A A B B";
        allDifferentHeaps(input);
    }

    private static void allDifferentHeaps(String input) {
        String[] keys = input.split("\\s+");
        SortedSet<String> pqs = new TreeSet<>();
        String[][] permutations = permutation(keys, 0, keys.length - 1);
        for (String[] permutation : permutations) {
            MaxPQ<String> pq = new MaxPQ<>(permutation.length);
            for (String key : permutation) {
                pq.insert(key);
            }
            pqs.add(Arrays.toString(pq.pq));
        }
        for (String pq : pqs) {
            System.out.println(pq.replace("null", "_"));
        }
    }

    public static String[][] permutation(String[] arr, int start, int end) {
        List<String[]> result = new ArrayList<>();
        if (start == end) {
            // 递归结束条件：已经到了数组最后一个元素
            result.add(arr.clone());
        } else {
            for (int i = start; i <= end; i++) {
                // 交换第i个元素和第start个元素的位置
                String temp = arr[i];
                arr[i] = arr[start];
                arr[start] = temp;

                // 递归获取子数组的排列
                String[][] subResult = permutation(arr, start + 1, end);
                result.addAll(Arrays.asList(subResult));

                // 恢复第i个元素和第start个元素的位置
                temp = arr[i];
                arr[i] = arr[start];
                arr[start] = temp;
            }
        }
        return result.toArray(new String[result.size()][]);
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void insert(Key v) {
        pq[++N] = v;
        swim(N);
    }

    public Key delMax() {
        Key max = pq[1];
        exch(1, N--);
        pq[N + 1] = null;
        sink(1);
        return max;
    }

    private void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            exch(k, k / 2);
            k /= 2;
        }
    }

    @SuppressWarnings("SameParameterValue")
    private void sink(int k) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && less(j, j + 1)) j++;
            if (!less(k, j)) break;
            exch(k, j);
            k = j;
        }
    }

    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void exch(int i, int j) {
        Key swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
    }
}
