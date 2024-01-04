package ch1.sec4.ex12;

import java.util.Arrays;

import edu.princeton.cs.algs4.StdOut;

public class PublicElements {
    final int[] a;
    final int[] b;
    final int N;
    int cursorA = 0;
    int cursorB = 0;
    Integer lastPublicElement = null;

    public PublicElements(int[] a, int[] b) {
        this.a = Arrays.copyOf(a, a.length);
        this.b = Arrays.copyOf(b, b.length);
        this.N = a.length;
    }

    public void find() {
        while (cursorA <= N - 1 && cursorB <= N - 1) {
            if (a[cursorA] == b[cursorB]) {
                int publicElement = a[cursorA];
                // Ignore duplicate public element
                if (lastPublicElement == null || publicElement != lastPublicElement) {
                    StdOut.println(publicElement);
                }
                lastPublicElement = publicElement;
            }
            compareNext();
        }
    }

    private void compareNext() {
        if (cursorA == N - 1 && cursorB == N - 1) {
            // Both reach the end, increase either to stop the loop
            cursorA += 1;
            cursorB += 1;
        } else if (cursorA == N - 1 && cursorB < N - 1) {
            // A reaches the end while B does not, increase B regardless the elements
            cursorB += 1;
        } else if (cursorB == N - 1 && cursorA < N - 1) {
            // B reaches the end while A does not, increase A
            cursorA += 1;
        } else {
            // Neither reach the end, increase the cursor of whichever element is smaller
            if (a[cursorA] < b[cursorB]) {
                cursorA += 1;
            } else if (a[cursorA] > b[cursorB]) {
                cursorB += 1;
            } else {
                cursorA += 1;
                cursorB += 1;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 1, 1, 2, 4, 5, 8, 8, 8};
        int[] b = {1, 2, 2, 2, 3, 4, 6, 7, 9};

        PublicElements p = new PublicElements(a, b);
        p.find();
    }
}
