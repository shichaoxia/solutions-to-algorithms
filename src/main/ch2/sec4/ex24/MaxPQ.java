package ch2.sec4.ex24;

import edu.princeton.cs.algs4.StdRandom;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MaxPQ<Key extends Comparable<Key>> {
    // tag::snippet1[]
    private int N = 0;
    private Node<Key> root;
    private Node<Key> lastNode; // Last inserted node in the heap
    // end::snippet1[]
    public static void main(String[] args) {
        MaxPQ<Integer> pq = new MaxPQ<>();
        Integer[] a = new Integer[10];
        for (int i = 0; i < a.length; i++) a[i] = i;
        StdRandom.shuffle(a);
        System.out.println("Items to be inserted:");
        System.out.println(Arrays.toString(a));
        System.out.println();
        for (int i : a) {
            pq.insert(i);
        }
        System.out.println("Binary tree representation of the heap:");
        printBinaryTree(pq.root);

        System.out.println("After del: " + pq.delMax());
        printBinaryTree(pq.root);

        System.out.println("After del: " + pq.delMax());
        printBinaryTree(pq.root);
    }

    public static void printBinaryTree(Node<?> root) {
        int maxLevel = maxLevel(root);
        printNodeInternal(Collections.singletonList(root), 1, maxLevel);
    }

    private static void printNodeInternal(List<Node<?>> nodes, int level, int maxLevel) {
        if (nodes.isEmpty() || isAllElementsNull(nodes))
            return;

        int floor = maxLevel - level;
        int edgeLines = (int) Math.pow(2, Math.max(floor - 1, 0));
        int firstSpaces = (int) Math.pow(2, floor) - 1;
        int betweenSpaces = (int) Math.pow(2, floor + 1) - 1;

        printWhitespaces(firstSpaces);

        List<Node<?>> newNodes = new ArrayList<>();
        for (Node<?> node : nodes) {
            if (node != null) {
                System.out.print(node.key);
                newNodes.add(node.left);
                newNodes.add(node.right);
            } else {
                newNodes.add(null);
                newNodes.add(null);
                System.out.print(" ");
            }
            printWhitespaces(betweenSpaces);
        }
        System.out.println();

        for (int i = 1; i <= edgeLines; i++) {
            for (Node<?> node : nodes) {
                printWhitespaces(firstSpaces - i);

                if (node == null) {
                    printWhitespaces(edgeLines + edgeLines + i + 1);
                    continue;
                }

                if (node.left != null) {
                    System.out.print("/");
                } else {
                    printWhitespaces(1);
                }
                printWhitespaces(i + i - 1);

                if (node.right != null) {
                    System.out.print("\\");
                } else {
                    printWhitespaces(1);
                }

                printWhitespaces(edgeLines + edgeLines - i);
            }
            System.out.println();
        }

        printNodeInternal(newNodes, level + 1, maxLevel);
    }

    private static void printWhitespaces(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print(" ");
        }
    }

    private static int maxLevel(Node<?> node) {
        if (node == null) {
            return 0;
        }

        return Math.max(maxLevel(node.left), maxLevel(node.right)) + 1;
    }

    private static boolean isAllElementsNull(List<Node<?>> list) {
        for (Object object : list) {
            if (object != null) {
                return false;
            }
        }

        return true;
    }

    // tag::snippet2[]
    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void insert(Key k) {
        Node<Key> newNode = new Node<>(k, null, null, null);
        if (N == 0) root = newNode;
        else insertAfter(lastNode, newNode);
        lastNode = newNode;
        N++;
        swim(lastNode);
    }

    private void insertAfter(Node<Key> n, Node<Key> newNode) {
        if (n == root) {
            newNode.up = n;
            if (n.left == null) n.left = newNode;
            else n.right = newNode;
            return;
        }
        Node<Key> nParent = n.up;
        if (n == nParent.left) {
            nParent.right = newNode;
        } else {
            int cnt = 0;
            while (n == nParent.right && nParent != root) {
                n = nParent;
                nParent = nParent.up;
                cnt++;
            }
            if (n == nParent.left) {
                nParent = nParent.right;
                cnt--;
                while (cnt > 0) {
                    nParent = nParent.left;
                    cnt--;
                }
            } else {
                while (nParent.left != null) {
                    nParent = nParent.left;
                }
            }
            nParent.left = newNode;
        }
        newNode.up = nParent;
    }

    public Key delMax() {
        if (N == 0) {
            throw new RuntimeException("Priority queue underflow");
        } else {
            Key max = root.key;
            if (N == 1) {
                root = null;
            } else {
                root.key = lastNode.key;
                Node<Key> nodeBeforeLastNode = previous(lastNode);
                Node<Key> lastNodeParent = lastNode.up;
                if (lastNodeParent.left == lastNode) {
                    lastNodeParent.left = null;
                } else {
                    lastNodeParent.right = null;
                }
                lastNode.up = null;
                lastNode = nodeBeforeLastNode;
                sink(root);
            }
            N--;
            return max;
        }
    }

    private Node<Key> previous(Node<Key> n) {
        if (n == root) {
            return null;
        }
        Node<Key> nParent = n.up;
        if (n == nParent.right) {
            // Under the same parent, the left child is the previous node.
            return nParent.left;
        } else {
            int cnt = 0;
            while (n == nParent.left && nParent != root) {
                n = nParent;
                nParent = nParent.up;
                cnt++;
            }
            if (n == nParent.right) {
                // The cousin node on the left is the previous node.
                nParent = nParent.left;
                cnt--;
                while (cnt > 0) {
                    nParent = nParent.right;
                    cnt--;
                }
                return nParent.right;
            } else {
                // The rightmost node on the upper level is the previous node.
                while (nParent.right != null) {
                    nParent = nParent.right;
                }
                return nParent;
            }
        }
    }

    private void swim(Node<Key> n) {
        while (n != root && less(n.up, n)) {
            exch(n, n.up);
            n = n.up;
        }
    }

    private void sink(Node<Key> n) {
        while (n.left != null) {
            Node<Key> j = n.left;
            if (n.right != null && less(n.left, n.right)) j = n.right;
            if (!less(n, j)) break;
            exch(n, j);
            n = j;
        }
    }

    private boolean less(Node<Key> i, Node<Key> j) {
        return i.compareTo(j) < 0;
    }

    private void exch(Node<Key> i, Node<Key> j) {
        Key temp = i.key;
        i.key = j.key;
        j.key = temp;
    }

    private static class Node<Key extends Comparable<Key>> {
        public Key key;
        public Node<Key> left;
        public Node<Key> right;
        public Node<Key> up;

        public Node(Key key, Node<Key> left, Node<Key> right, Node<Key> up) {
            this.key = key;
            this.left = left;
            this.right = right;
            this.up = up;
        }

        public int compareTo(Node<Key> that) {
            return this.key.compareTo(that.key);
        }
    }
    // end::snippet2[]
}
