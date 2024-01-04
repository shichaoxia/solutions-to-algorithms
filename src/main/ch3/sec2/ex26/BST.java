package ch3.sec2.ex26;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.stream.IntStream;

@SuppressWarnings("DuplicatedCode")
public class BST<Key extends Comparable<Key>, Value> {
    private Node root;

    private class Node {
        private final Key key;
        private Value val;
        private Node left, right;
        private int N;

        public Node(Key key, Value val, int N) {
            this.key = key;
            this.val = val;
            this.N = N;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            @SuppressWarnings("unchecked") Node node = (Node) o;
            return N == node.N && Objects.equals(key, node.key) && Objects.equals(val, node.val) && Objects.equals(left, node.left) && Objects.equals(right, node.right);
        }

        @Override
        public int hashCode() {
            return Objects.hash(key, val, left, right, N);
        }
    }

// --Commented out by Inspection START (12/5/23, 12:27):
//    public int size() {
//        return size(root);
//    }
// --Commented out by Inspection STOP (12/5/23, 12:27)

    private int size(Node x) {
        if (x == null) return 0;
        else return x.N;
    }

// --Commented out by Inspection START (12/5/23, 12:27):
//    public Value get(Key key) {
//        return get(root, key);
//    }
// --Commented out by Inspection STOP (12/5/23, 12:27)

    
     public void put(Key key, Value val) {
        root = put(root, key, val);
    }

    private Node put(Node x, Key key, Value val) {
        if (x == null) return new Node(key, val, 1);
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = put(x.left, key, val);
        else if (cmp > 0) x.right = put(x.right, key, val);
        else x.val = val;
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    private void printTree(StringBuilder sb, Node x, String prefix, boolean isRoot, boolean isLeft, boolean hasSibling) {
        if (x == null) return;
        sb.append(prefix);
        String pointer = isLeft ? "┄┄┄" : "───";
        if (!isRoot) sb.append(hasSibling ? "├" + pointer : "└" + pointer);
        sb.append(x.key).append("\n");
        if (!isRoot) prefix += hasSibling ? "│   " : "    ";
        printTree(sb, x.right, prefix, false, false, x.left != null);
        printTree(sb, x.left, prefix, false, true, false);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        printTree(sb, root, "", true, false, false);
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        @SuppressWarnings("rawtypes") BST other = (BST) o;
        @SuppressWarnings("unchecked") boolean result = isIdentical(root, other.root);
        return result;
    }

    private boolean isIdentical(Node root1, Node root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;
        if (root1.val != root2.val) return false;
        return isIdentical(root1.left, root2.left) && isIdentical(root1.right, root2.right);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + calculateHashCode(root);
        return result;
    }

    private int calculateHashCode(Node node) {
        if (node == null) return 0;
        int result = 31 * node.val.hashCode();
        result += calculateHashCode(node.left);
        result += calculateHashCode(node.right);
        return result;
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permuteHelper(nums, 0, result);
        return result;
    }

    private static void permuteHelper(int[] nums, int start, List<List<Integer>> result) {
        if (start == nums.length) {
            List<Integer> permutation = new ArrayList<>();
            for (int num : nums) permutation.add(num);
            result.add(permutation);
        } else {
            for (int i = start; i < nums.length; i++) {
                swap(nums, start, i);
                permuteHelper(nums, start + 1, result);
                swap(nums, start, i);
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    @SuppressWarnings("SameParameterValue")
    private static void shapes(int N, BiConsumer<Integer, Map<BST<Integer, Integer>, Integer>> consumer) {
        int[] nums = new int[N];
        IntStream.range(0, N).forEach(i -> nums[i] = i);

        List<List<Integer>> result = permute(nums);
        Map<BST<Integer, Integer>, Integer> map = new HashMap<>();
        BST<Integer, Integer> bst;

        for (List<Integer> permutation : result) {
            bst = new BST<>();
            for (int num : permutation) bst.put(num, num);
            if (map.containsKey(bst)) map.put(bst, map.get(bst) + 1);
            else map.put(bst, 1);
        }

        consumer.accept(N, map);
    }

    public static void main(String[] args) {
        shapes(6, (theN, map) -> {
            map = sortByValue(map);
            int total = map.values().stream().mapToInt(Integer::intValue).sum();
            System.out.println("N = " + theN + ", total = " + total + "\n");
            map.forEach((bst, count) -> {
                float ratio = (float) count / total;
                System.out.print(bst);
                System.out.printf("count = %d, ratio = %.3f%n%n", count, ratio);
            });
        });
    }

    public static Map<BST<Integer, Integer>, Integer> sortByValue(Map<BST<Integer, Integer>, Integer> map) {
        List<Map.Entry<BST<Integer, Integer>, Integer>> entryList = new ArrayList<>(map.entrySet());
        entryList.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        return entryList.stream().collect(LinkedHashMap::new, (m, e) -> m.put(e.getKey(), e.getValue()), LinkedHashMap::putAll);
    }
}
