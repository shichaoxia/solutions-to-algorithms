package ch3.sec2.ex18;

import ch3.sec2.BST;

import java.util.Arrays;

public class Client {
    public static void main(String[] args) {
        String[] a = "E A S Y Q U E S T I O N".split(" ");
        BST<String, Integer> bst = new BST<>();
        String[] b = a.clone();
        Arrays.sort(b);
        System.out.println("Alphabetical order: " + Arrays.toString(b));
        for (String s : a) bst.put(s, (int) s.charAt(0));
        System.out.println("Before delete:");
        System.out.println(bst);

        for (String s : b) {
            bst.delete(s);
            System.out.println("After delete " + s + ":");
            System.out.println(bst);
        }
    }
}
