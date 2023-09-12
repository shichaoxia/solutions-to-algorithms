package chapter2.section5.exercise30;

import java.util.Arrays;

@SuppressWarnings("rawtypes")
public class BoernersTheorem {
    public static void sortCols(Comparable[][] matrix) {
        int colNum = matrix[0].length;
        int rowNum = matrix.length;
        for (int i = 0; i < colNum; i++) {
            Comparable[] col = new Comparable[rowNum];
            for (int j = 0; j < rowNum; j++)
                col[j] = matrix[j][i];
            Arrays.sort(col);
            for (int j = 0; j < rowNum; j++)
                matrix[j][i] = col[j];
        }
    }

    public static void sortRows(Comparable[][] matrix) {
        for (Comparable[] row : matrix)
            Arrays.sort(row);
    }

    public static boolean isColsSorted(Comparable[][] matrix) {
        int colNum = matrix[0].length;
        int rowNum = matrix.length;
        for (int i = 0; i < colNum; i++) {
            Comparable[] col = new Comparable[rowNum];
            for (int j = 0; j < rowNum; j++)
                col[j] = matrix[j][i];
            if (!isSorted(col))
                return false;
        }
        return true;
    }

    @SuppressWarnings("unchecked")
    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++)
            if (a[i].compareTo(a[i - 1]) < 0)
                return false;
        return true;
    }
}
