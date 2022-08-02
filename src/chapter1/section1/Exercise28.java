package chapter1.section1;

import java.util.Arrays;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Exercise28 {
    public static void main(String[] args) {
        int[] whitelist = new In(args[0]).readAllInts();
        StdOut.printf("%10s%s%n", "Original: ", Arrays.toString(whitelist));

        Arrays.sort(whitelist);
        StdOut.printf("%10s%s%n", "Sorted: ", Arrays.toString(whitelist));

        int[] tmp = new int[whitelist.length];
        int destIndex = 0;

        for (int i = 0; i < whitelist.length; i++) {
            // The last item has no follow-up, just copy it
            if (i == whitelist.length - 1) {
                tmp[destIndex] = whitelist[i];
                break;
            }
            // Ignore the same item as the latter
            if (whitelist[i] == whitelist[i + 1])
                continue;
            tmp[destIndex] = whitelist[i];
            destIndex += 1;
        }

        int tmpLength = destIndex + 1;
        whitelist = Arrays.copyOf(tmp, tmpLength);
        StdOut.printf("%10s%s%n", "Removed: ", Arrays.toString(whitelist));
    }
}
