package ch1.sec1.ex28;

import java.util.Arrays;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Ex28 {

    public static int[] removeDuplicate(int[] a) {
        Arrays.sort(a);
        int[] tmp = new int[a.length];
        int destIndex = 0;

        for (int i = 0; i < a.length; i++) {
            // The last item has no follow-up, just copy it
            if (i == a.length - 1) {
                tmp[destIndex] = a[i];
                break;
            }
            // Ignore elements that are identical to the latter
            if (a[i] == a[i + 1])
                continue;
            tmp[destIndex] = a[i];
            destIndex += 1;
        }

        int tmpLength = destIndex + 1;
        return Arrays.copyOf(tmp, tmpLength);
    }

    public static void main(String[] args) {
        int[] whitelist = new In(args[0]).readAllInts();
        StdOut.printf("%10s%s%n", "Original: ", Arrays.toString(whitelist));

        whitelist = removeDuplicate(whitelist);
        StdOut.printf("%10s%s%n", "Removed: ", Arrays.toString(whitelist));
    }
}
