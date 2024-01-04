package ch3.sec2.ex10;

import ch3.sec2.BST;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class TestBST {
    public static void main(String[] args) {
        BST<Double, Double> bst = new BST<>();
        int[] nums = {5, 3, 7, 2, 4, 6, 8};
        for (double num : nums) bst.put(num, num);
        assertEqual(bst.min(), 2.0);
        assertEqual(bst.max(), 8.0);
        assertEqual(bst.floor(4.5), 4.0);
        assertEqual(bst.ceiling(4.5), 5.0);
        assertEqual(bst.select(3), 5.0);
        assertEqual(bst.rank(5.5), 4);

        bst.delete(8.0);
        assertEqual(bst.max(), 7.0);

        bst.deleteMin();
        assertEqual(bst.min(), 3.0);

        bst.deleteMax();
        assertEqual(bst.max(), 6.0);

        String r = StreamSupport.stream(bst.keys().spliterator(), false)
                .map(Object::toString)
                .collect(Collectors.joining(", "));
        assertEqual(r, "3.0, 4.0, 5.0, 6.0");
    }

    private static <T> void assertEqual(T actual, T expected) {
        if (!actual.equals(expected)) {
            throw new AssertionError("actual: " + actual + ", expected: " + expected);
        }
    }
}
