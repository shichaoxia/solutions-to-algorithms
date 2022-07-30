package chapter1.section1;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Exercise11Test {

    @Test
    void printingTwoDimensionalBooleanArray() {
        boolean[] row1 = {true, true, false};
        boolean[] row2 = {true, false, false};
        boolean[] row3 = {false, true, true};
        boolean[][] a = {row1, row2, row3};
        String output = """
                 123
                1**\s
                2* \s
                3 **
                """;

        PrintStream defaultOut = System.out;

        ByteArrayOutputStream os = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(os);
        System.setOut(ps);

        Exercise11.printTwoDimensionalBooleanArray(a);

        assertEquals(output, os.toString());
        System.setOut(defaultOut);
    }
}
