package ch1.sec3.ex37;

import edu.princeton.cs.algs4.StdOut;

public class Josephus {

    public static LinkedList<Integer> play(int total, int killNum) {
        LinkedList<Integer> l = new LinkedList<>();
        for (int i = 0; i < total; i++) {
            l.addLast(i);
        }
        DoubleNode<Integer> cursor = l.first;
        int count = 1;
        while (l.size() >= killNum) {
            while (count != killNum) {
                count += 1;
                cursor = l.circularNext(cursor);
            }
            DoubleNode<Integer> newCursor = l.circularNext(cursor);
            StdOut.print(cursor.item + " ");
            l.remove(cursor);
            cursor = newCursor;
            count = 1;
        }
        return l;
    }

    public static void main(String[] args) {
        StdOut.println(play(7, 2));
    }

}
