package com.claudhart.algs4.chapter3.section2.exercise17;

import com.claudhart.algs4.chapter3.section2.BST;

import java.util.Arrays;

public class Client {
    public static void main(String[] args) {
        BST<String, Integer> bst = new BST<>();
        String[] a = "E A S Y Q U T I O N".split(" ");
        Arrays.stream(a).forEach(s -> bst.put(s, (int) s.charAt(0)));

        System.out.println("Before delete:");
        System.out.println(bst);

        Arrays.stream(a).forEach(s -> {
            bst.delete(s);
            System.out.println("After delete " + s + ":");
            System.out.println(bst);
        });
    }

}
