package chapter2.section3;

import edu.princeton.cs.algs4.StdOut;

public class PrintArrayAndIndices {
    @SuppressWarnings("rawtypes")
    public static void print(Comparable[] a, int lo, int hi, int i, int j, String message) {
        printArray(a);
        StdOut.printf("%n");

        printArray(composeIndexArray(a, lo, "lo"));
        StdOut.printf("%4s%s", "", message);
        StdOut.printf("%n");

        printArray(composeIndexArray(a, i, "i"));
        StdOut.printf("%n");

        printArray(composeIndexArray(a, j, "j"));
        StdOut.printf("%n");

        printArray(composeIndexArray(a, hi, "hi"));
        StdOut.printf("%n");
    }

    @SuppressWarnings("rawtypes")
    public static void print(Comparable[] a, int lo, int lt, int i, int gt, int hi, String message) {
        printArray(a);
        StdOut.printf("%n");

        printArray(composeIndexArray(a, lo, "lo", hi, "hi"));
        StdOut.printf("%4s%s", "", message);
        StdOut.printf("%n");

        printArray(composeIndexArray(a, lt, "lt"));
        StdOut.printf("%n");

        printArray(composeIndexArray(a, i, "i"));
        StdOut.printf("%n");

        printArray(composeIndexArray(a, gt, "gt"));
        StdOut.printf("%n");
    }

    @SuppressWarnings("rawtypes")
    public static void printArray(Comparable[] a) {
        for (int k = 0; k < a.length; k++) {
            StdOut.printf("%s", a[k].toString());
            if (k != a.length - 1 && !a[k].equals("lo") && !a[k].equals("hi"))
                StdOut.printf(" ");
        }
    }

    @SuppressWarnings({"SameParameterValue", "rawtypes"})
    private static String[] composeIndexArray(Comparable[] a, int i, String iName, int j, String jName) {
        String[] indexArray = new String[a.length + 1];
        for (int k = 0; k < indexArray.length; k++) {
            if (k == i) {
                indexArray[k] = iName;
            } else if (k == j) {
                indexArray[k] = jName;
            } else {
                indexArray[k] = " ";
            }
        }
        return indexArray;
    }

    @SuppressWarnings("rawtypes")
    private static String[] composeIndexArray(Comparable[] a, int i, String iName) {
        String[] indexArray = new String[a.length + 1];
        for (int k = 0; k < indexArray.length; k++)
            indexArray[k] = k == i ? iName : " ";
        return indexArray;
    }
}
