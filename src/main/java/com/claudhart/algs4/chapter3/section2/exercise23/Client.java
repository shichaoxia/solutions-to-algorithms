package com.claudhart.algs4.chapter3.section2.exercise23;

import com.claudhart.algs4.chapter3.section2.BST;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        Integer[] a = {5, 3, 7, 2, 4, 6, 8, 1, 9};
        BST<Integer, Integer> bst1 = new BST<>();
        BST<Integer, Integer> bst2 = new BST<>();
        for (Integer i : a) {
            bst1.put(i, i);
            bst2.put(i, i);
        }

        List<Pair<Integer>> pairs = new ArrayList<>();

        for (int i = 0; i < a.length; i++)
            for (int j = i; j < a.length; j++)
                pairs.add(new Pair<>(a[i], a[j]));

        for (Pair<Integer> pair : pairs) {
            bst1 = new BST<>();
            bst2 = new BST<>();
            for (Integer i : a) {
                bst1.put(i, i);
                bst2.put(i, i);
            }
            bst1.delete(pair.key1);
            bst1.delete(pair.key2);
            bst2.delete(pair.key2);
            bst2.delete(pair.key1);
            if (!bst1.equals(bst2)) System.out.println(pair);
        }
    }

    private record Pair<Key>(Key key1, Key key2) {
    }
}
