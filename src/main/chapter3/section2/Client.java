package chapter3.section2;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

public class Client {
    public static void main(String[] args) {
        String s = "A C E H M R S X";
        String[] a = s.split(" ");
        StdRandom.shuffle(a);
        System.out.println(Arrays.toString(a));
    }
}
