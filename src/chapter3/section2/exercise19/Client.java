package chapter3.section2.exercise19;

import chapter3.section2.BST;

import java.util.Arrays;

public class Client {
    public static void main(String[] args) {
        String[] a = "E A S Y Q U T I O N".split(" ");
        BST<String, Integer> bst = new BST<>();
        for (String s : a) bst.put(s, 0);
        System.out.println("Before delete:");
        System.out.println(bst);

        Arrays.stream("E I N O Q S T U Y".split(" ")).forEach(key -> {
            bst.delete(key);
            System.out.println("After delete " + key + ":");
            System.out.println(bst);
        });
    }
}
