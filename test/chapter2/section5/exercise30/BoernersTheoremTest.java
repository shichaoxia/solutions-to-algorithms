package chapter2.section5.exercise30;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoernersTheoremTest {
    @Test
    void isColsSorted() {
        int colsNum = StdRandom.uniform(1, 100);
        int rowsNum = StdRandom.uniform(1, 100);
        Integer[][] matrix = new Integer[rowsNum][colsNum];
        for (int i = 0; i < rowsNum; i++)
            for (int j = 0; j < colsNum; j++)
                matrix[i][j] = StdRandom.uniform(100);
        BoernersTheorem.sortCols(matrix);
        BoernersTheorem.sortRows(matrix);
        assertTrue(BoernersTheorem.isColsSorted(matrix));
    }
}