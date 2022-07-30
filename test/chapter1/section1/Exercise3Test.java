package chapter1.section1;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Exercise3Test {

    @Test
    void testMain() {
        PrintStream defaultOut = System.out;

        ByteArrayOutputStream os = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(os);
        System.setOut(ps);

        Exercise3.main(new String[]{"1", "2", "3"});
        assertEquals("not equal", os.toString());

        os.reset();

        Exercise3.main(new String[]{"2", "2", "2"});
        assertEquals("equal", os.toString());

        System.setOut(defaultOut);
    }
}
