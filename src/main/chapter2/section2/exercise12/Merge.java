package chapter2.section2.exercise12;

@SuppressWarnings({"rawtypes", "unchecked", "ManualArrayCopy"})
public class Merge {

    // tag::snippet[]
    private static Comparable[] aux;

    public static void sort(Comparable[] a, int blockSize) {
        if ((a.length % blockSize) != 0)
            throw new RuntimeException("The length of array should to be a multiple of the block size.");

        int blockNum = a.length / blockSize;

        aux = new Comparable[blockSize];

        for (int i = 0; i < blockNum; i++)
            sortBlock(a, i, blockSize);

        for (int mergePairs = blockNum - 1; mergePairs > 0; mergePairs--) {
            for (int currentPair = 0; currentPair < mergePairs; currentPair++) {
                mergeBlocks(a, currentPair, currentPair + 1, blockSize);
            }
        }
    }

    public static void sortBlock(Comparable[] a, int blockIndex, int blockSize) {
        int blockLo = blockIndex * blockSize;
        int blockHi = blockLo + blockSize - 1;
        Selection.sort(a, blockLo, blockHi);
    }

    public static void mergeBlocks(Comparable[] a, int blockAIndex, int blockBIndex, int blockSize) {
        int blockALo = blockAIndex * blockSize;
        int blockAHi = blockALo + blockSize - 1;
        int blockBLo = blockBIndex * blockSize;
        int blockBHi = blockBLo + blockSize - 1;
        merge(a, aux, blockALo, blockAHi, blockBHi);
    }

    public static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
        for (int i = 0; i < aux.length; i++)  // Copy left to aux
            aux[i] = a[i + lo];

        int leftIdx = 0, rightIdx = mid + 1;

        for (int i = lo; i <= hi; i++)
            if (leftIdx >= aux.length) a[i] = a[rightIdx++];
            else if (rightIdx > hi) a[i] = aux[leftIdx++];
            else if (less(a[rightIdx], aux[leftIdx])) a[i] = a[rightIdx++];
            else a[i] = aux[leftIdx++];
    }
    // end::snippet[]

    public static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++)
            if (less(a[i], a[i - 1])) return false;
        return true;
    }
}
