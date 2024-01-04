package ch3.sec2.ex7;

public class BSTConst<Key extends Comparable<Key>, Value> {
    private Node root;

    // tag::snippet[]
    private class Node {
        private final Key key;
        private Value val;
        private Node left, right;
        private int N;
        private final int D;
        private int iPL;

        public Node(Key key, Value val, int N, int D, int iPL) {
            this.key = key;
            this.val = val;
            this.N = N;
            this.D = D;
            this.iPL = iPL;
        }
    }
    // end::snippet[]

    
    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if (x == null) return 0;
        else return x.N;
    }


    
    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) return get(x.left, key);
        else if (cmp > 0) return get(x.right, key);
        else return x.val;
    }

    // tag::snippet1[]
    public void put(Key key, Value val) {
        root = put(root, key, val, 0);
    }

    private Node put(Node x, Key key, Value val, int D) {
        if (x == null) return new Node(key, val, 1, D, D);
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = put(x.left, key, val, D + 1);
        else if (cmp > 0) x.right = put(x.right, key, val, D + 1);
        else x.val = val;
        x.N = size(x.left) + size(x.right) + 1;
        x.iPL = internalPathLength(x.left) + internalPathLength(x.right) + x.D;
        return x;
    }

    public int internalPathLength() {
        return internalPathLength(root);
    }

    private int internalPathLength(Node x) {
        if (x == null) return 0;
        return x.iPL;
    }
    // end::snippet1[]

    
    public void printTree() {
        printTree(root, "", true, false, false);
    }

    private void printTree(Node x, String prefix, boolean isRoot, boolean isLeft, boolean hasSibling) {
        if (x == null) return;
        System.out.print(prefix);
        String pointer = isLeft ? "┄┄┄" : "───";
        if (!isRoot)
            System.out.print(hasSibling ? "├" + pointer : "└" + pointer);
        System.out.println(x.key + " " + x.N + " " + x.D + " " + x.iPL);
        if (!isRoot)
            prefix += hasSibling ? "│   " : "    ";
        printTree(x.right, prefix, false, false, x.left != null);
        printTree(x.left, prefix, false, true, false);
    }
}
