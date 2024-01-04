package ch3.sec2.ex3;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Client {
    public static void main(String[] args) {
        String[] a = "H C S R A E X".split(" ");
        System.out.println("Insert keys: " + Arrays.toString(a));
        System.out.println("BST: ");
        arrayToBst(a).printTree();
        Set<String> set = new HashSet<>();
        System.out.println("Best case: ");
        while (set.size() < 5) {
            StdRandom.shuffle(a);
            if (arrayToBst(a).height() == 2) {
                System.out.println(Arrays.toString(a));
                set.add(Arrays.toString(a));
            }
        }
    }

    public static BST<String, Integer> arrayToBst(String[] a) {
        BST<String, Integer> bst = new BST<>();
        for (int i = 0; i < a.length; i++) bst.put(a[i], i);
        return bst;
    }
}
