package chapter1.section1;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class Exercise13Test {

    @Test
    void transpose() {
        int[][] a = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] b = {{1, 4, 7}, {2, 5, 8}, {3, 6, 9}};
        int[][] c = Exercise13.transpose(3, 3, a);
        assertTrue(Arrays.deepEquals(b, c));
    }
}
