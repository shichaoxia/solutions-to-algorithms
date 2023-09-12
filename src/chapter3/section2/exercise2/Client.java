package chapter3.section2.exercise2;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Client {
    public static void main(String[] args) {
        String[] a = "A X C S E R H".split(" ");
        Set<String> set = new HashSet<>();
        System.out.println("Insert keys: " + Arrays.toString(a));
        System.out.println("BST: ");
        arrayToBst(a).printTree();
        set.add(Arrays.toString(a));
        System.out.println("Worse case: ");
        while (set.size() < 6) {
            StdRandom.shuffle(a);
            if (arrayToBst(a).height() == 6) {
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
